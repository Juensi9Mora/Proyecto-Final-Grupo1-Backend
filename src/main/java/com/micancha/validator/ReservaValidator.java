package com.micancha.validator;

import com.micancha.config.ReservasProperties;
import com.micancha.dto.ReservaDto;
import com.micancha.emuns.EstadoCancha;
import com.micancha.emuns.EstadoReserva;
import com.micancha.entity.CanchaEntity;
import com.micancha.exception.ReservaInvalidaException;
import com.micancha.exception.ReservaNoDisponibleException;
import com.micancha.repository.DetalleReservaRepository;
import org.springframework.stereotype.Component;

import java.time.*;

@Component
public class ReservaValidator {

    private final DetalleReservaRepository detalleReservaRepository;
    private final ReservasProperties reservasProperties;
    private final Clock clock;

    public ReservaValidator(DetalleReservaRepository detalleReservaRepository, ReservasProperties reservasProperties, Clock clock) {
        this.detalleReservaRepository = detalleReservaRepository;
        this.reservasProperties = reservasProperties;
        this.clock = clock;
    }

    public void validar(CanchaEntity cancha, ReservaDto dto, Long idExcluido) {
        validarCanchaActiva(cancha);
        validarHoraEnPunto(dto.horaInicio());
        validarNoEsPasada(dto.fechaReserva(), dto.horaInicio());
        validarHorarioOperacion(dto.horaInicio(), dto.cantidadHoras());
        validarDisponibilidad(cancha.getId(), dto.fechaReserva(), dto.horaInicio(),
                dto.cantidadHoras(), idExcluido);
    }

    private void validarCanchaActiva(CanchaEntity cancha) {
        if (!EstadoCancha.ACTIVA.name().equals(cancha.getEstado())) {
            throw new ReservaInvalidaException("La cancha no está disponible para reservas");
        }
    }

    private void validarHoraEnPunto(LocalTime horaInicio) {
        if (horaInicio.getMinute() != 0 || horaInicio.getSecond() != 0) {
            throw new ReservaInvalidaException("La hora de inicio debe ser en punto (por ejemplo, 19:00)");
        }
    }

    private void validarNoEsPasada(LocalDate fecha, LocalTime horaInicio) {
        if (LocalDateTime.of(fecha, horaInicio).isBefore(LocalDateTime.now(clock))) {
            throw new ReservaInvalidaException("No se puede reservar en una fecha u hora que ya pasó");
        }
    }

    private void validarHorarioOperacion(LocalTime horaInicio, int horas) {
        long horasHastaCierre = Duration.between(horaInicio, reservasProperties.horaCierre()).toHours();

        if (horaInicio.isBefore(reservasProperties.horaApertura()) || horas > horasHastaCierre) {
            throw new ReservaInvalidaException("La reserva debe estar entre las "
                    + reservasProperties.horaApertura() + " y las " + reservasProperties.horaCierre());
        }
    }

    private void validarDisponibilidad(Long canchaId, LocalDate fecha, LocalTime inicio,
                                       int horas, Long idExcluido) {
        LocalTime fin = inicio.plusHours(horas);

        boolean ocupada = detalleReservaRepository
                .findByCancha_IdAndFechaReservaAndEstadoNot(canchaId, fecha, EstadoReserva.CANCELADA.name())
                .stream()
                .filter(d -> !d.getId().equals(idExcluido))
                .anyMatch(d -> inicio.isBefore(d.getHoraInicio().plusHours(d.getCantidadHoras()))
                        && d.getHoraInicio().isBefore(fin));

        if (ocupada) {
            throw new ReservaNoDisponibleException("La cancha ya está reservada en ese horario");
        }
    }
}
