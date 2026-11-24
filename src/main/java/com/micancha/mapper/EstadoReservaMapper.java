package com.micancha.mapper;

import com.micancha.emuns.EstadoReserva;
import org.mapstruct.Named;

public class EstadoReservaMapper {

    @Named("stringToEstadoReserva")
    public static EstadoReserva stringToEstadoReserva(String estadoReserva) {
        if (estadoReserva == null) return null;

        return switch (estadoReserva.toUpperCase()){
            case "PENDIENTE" -> EstadoReserva.PENDIENTE;
            case "CONFIRMADA" -> EstadoReserva.CONFIRMADA;
            case "EN_CURSO" -> EstadoReserva.EN_CURSO;
            case "COMPLETADA" -> EstadoReserva.COMPLETADA;
            default -> null;
        };
    }

    @Named("estadoReservaToString")
    public static String estadoReservaToString(EstadoReserva estadoReserva) {
        if (estadoReserva == null) return null;

        return switch (estadoReserva){
            case PENDIENTE -> "PENDIENTE";
            case CONFIRMADA -> "CONFIRMADA";
            case EN_CURSO -> "EN_CURSO";
            case COMPLETADA -> "COMPLETADA";
            default -> null;
        };
    }
}
