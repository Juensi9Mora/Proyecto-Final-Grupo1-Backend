package com.micancha.dto;

import java.math.BigDecimal;
import java.time.LocalTime;

public record DetalleReservaDto(
     Long id,
     Long canchaId,
     String canchaNombre,
     LocalTime horaInicio,
     Integer cantidadHoras,
     String metodoPago,
     BigDecimal total,
     String moneda,
     String estado
) {

}
