package com.micancha.service;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.dto.ReservaDto;
import com.micancha.emuns.EstadoReserva;
import com.micancha.emuns.Moneda;
import com.micancha.entity.CanchaEntity;
import com.micancha.entity.DetalleReservaEntity;
import com.micancha.entity.ReservaEntity;
import com.micancha.entity.UsuarioEntity;
import com.micancha.exception.RecursoNoEncontradoException;
import com.micancha.mapper.DetalleReservaMapper;
import com.micancha.mapper.ReservaMapper;
import com.micancha.repository.CanchaRepository;
import com.micancha.repository.DetalleReservaRepository;
import com.micancha.repository.ReservaRepository;
import com.micancha.repository.UsuarioRepository;
import com.micancha.validator.ReservaValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;


@Service
public class DetalleReservaServiceJPA implements DetalleReservaService {

    private final DetalleReservaRepository detalleReservaRepository;
    private final ReservaRepository reservaRepository;
    private final CanchaRepository canchaRepository;
    private final UsuarioRepository usuarioRepository;
    private final DetalleReservaMapper detalleReservaMapper;
    private final ReservaMapper reservaMapper;
    private final ReservaValidator reservaValidator;
    private final Clock clock;

    public DetalleReservaServiceJPA(DetalleReservaRepository detalleReservaRepository,
                                    ReservaRepository reservaRepository,
                                    CanchaRepository canchaRepository,
                                    UsuarioRepository usuarioRepository,
                                    DetalleReservaMapper detalleReservaMapper, ReservaMapper reservaMapper, ReservaValidator reservaValidator, Clock clock) {
        this.detalleReservaRepository = detalleReservaRepository;
        this.reservaRepository = reservaRepository;
        this.canchaRepository = canchaRepository;
        this.usuarioRepository = usuarioRepository;
        this.detalleReservaMapper = detalleReservaMapper;
        this.reservaMapper = reservaMapper;
        this.reservaValidator = reservaValidator;
        this.clock = clock;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DetalleReservaDto> getAll(Pageable pageable) {
        return detalleReservaRepository.findAll(pageable)
                .map(detalleReservaMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleReservaDto getById(Long id) {
        return detalleReservaMapper.toDto(detalleReservaRepository.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public DetalleReservaDto save(ReservaDto reservaDto, Long usuarioId) {
        UsuarioEntity usuario =  usuarioRepository.findById(usuarioId)
                .orElseThrow(()-> new RecursoNoEncontradoException("Usuario", usuarioId));
        CanchaEntity cancha = buscarCancha(reservaDto.canchaId());
        reservaValidator.validar(cancha, reservaDto, null);

        ReservaEntity reserva = new ReservaEntity();
        reserva.setFechaCreacion(LocalDateTime.now(clock));
        reserva.setUsuarioEntity(usuario);
        reserva = reservaRepository.save(reserva);

        DetalleReservaEntity detalle = reservaMapper.toEntity(reservaDto);
        detalle.setReserva(reserva);
        detalle.setCancha(cancha);
        detalle.setTotal(calcularTotal(cancha, reservaDto.cantidadHoras()));
        detalle.setMoneda(Moneda.COP.name());
        detalle.setEstado(EstadoReserva.PENDIENTE.name());

        return detalleReservaMapper.toDto(detalleReservaRepository.save(detalle));
    }

    @Override
    public DetalleReservaDto update(Long id, ReservaDto reservaDto) {
        DetalleReservaEntity detalle = buscarReserva(id);

        if (EstadoReserva.CANCELADA.name().equals(detalle.getEstado())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No se puede modificar una reserva cancelada");
        }

        CanchaEntity cancha = buscarCancha(reservaDto.canchaId());
        reservaValidator.validar(cancha, reservaDto, id);

        reservaMapper.updateEntity(reservaDto, detalle);
        detalle.setCancha(cancha);
        detalle.setTotal(calcularTotal(cancha, reservaDto.cantidadHoras()));

        return detalleReservaMapper.toDto(detalle);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        buscarReserva(id).setEstado(EstadoReserva.CANCELADA.name());
    }

    private DetalleReservaEntity buscarReserva(Long id) {
        return detalleReservaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Reserva", id));
    }

    private CanchaEntity buscarCancha(Long canchaId) {
        return canchaRepository.findById(canchaId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cancha", canchaId));
    }

    private BigDecimal calcularTotal(CanchaEntity cancha, Integer horas) {
        return cancha.getPrecioHora().multiply(BigDecimal.valueOf(horas));
    }
}
