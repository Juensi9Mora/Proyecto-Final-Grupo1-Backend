package com.micancha.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
@EnableConfigurationProperties({ReservasProperties.class})
public class ReservasConfig {

    @Bean
    public Clock clock(ReservasProperties reservasProperties) {
        return Clock.system(ZoneId.of(reservasProperties.zonaHoraria()));
    }
}
