package com.micancha.config;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.LocalTime;

@Validated
@ConfigurationProperties(prefix = "micancha.reservas")
public record ReservasProperties(
        @NotBlank String zonaHoraria,
        @NotNull LocalTime horaApertura,
        @NotNull LocalTime horaCierre
) {
}
