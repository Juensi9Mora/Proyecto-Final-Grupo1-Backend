package com.micancha.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record DetalleReservaDto(

     Long canchaId,
     String canchaNombre,
     String canchaDireccion,
     LocalDate fechaReserva,
     LocalTime horaInicio,
     LocalTime horaFin,
     Integer cantidadHoras,
     BigDecimal precioHora,
     String metodoPago,
     BigDecimal total,
     String moneda,
     String estado
) {

}
