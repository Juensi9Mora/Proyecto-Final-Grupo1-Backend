package com.micancha.dto;

import com.micancha.emuns.MetodoPago;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaDto(

    @NotNull @Positive
    Long canchaId,

    @NotNull
    LocalDate fechaReserva,

    @NotNull
    LocalTime horaInicio,

    @NotNull
    @Min(value = 1, message = "Mínimo 1 hora")
    @Max(value = 3, message = "Máximo 3 horas")
    Integer cantidadHoras,

    @NotNull(message = "El método de pago es obligatorio")
    MetodoPago metodoPago
) {
}
