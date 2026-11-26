package com.micancha.mapper;

import com.micancha.emuns.MetodoPago;
import org.mapstruct.Named;

public class MetodoPagoMapper {

    @Named("stringToMetodoPago")
    public static MetodoPago stringToMetodoPago(String metodoPago) {
        if (metodoPago == null) return null;

        return switch (metodoPago.toUpperCase()){
            case "EFECTIVO" -> MetodoPago.EFECTIVO;
            case "TARJETA_CREDITO" -> MetodoPago.TARJETA_CREDITO;
            case "TARJETA_DEBITO" -> MetodoPago.TARJETA_DEBITO;
            case "TRANSFERENCIA" -> MetodoPago.TRANSFERENCIA;
            default -> null;
        };
    }

    @Named("metodoPagoToString")
    public static String metodoPagoToString(MetodoPago metodoPago) {
        if (metodoPago == null) return null;

        return switch (metodoPago){
            case EFECTIVO -> "EFECTIVO";
            case TARJETA_CREDITO -> "TARJETA_CREDITO";
            case TARJETA_DEBITO -> "TARJETA_DEBITO";
            case TRANSFERENCIA -> "TRANSFERENCIA";
            default -> null;
        };
    }
}
