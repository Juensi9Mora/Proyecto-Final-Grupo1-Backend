package com.micancha.dto;

import java.math.BigDecimal;
import java.time.LocalTime;

public record DetalleReservaDto(
     Long id,
     Long cancha_id,
     String cancha_nombre,
     LocalTime hora_inicio,
     Integer cantidad_horas,
     String metodo_pago,
     BigDecimal total,
     String moneda,
     String estado
) {

}
