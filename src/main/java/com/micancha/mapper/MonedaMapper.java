package com.micancha.mapper;

import com.micancha.emuns.Moneda;
import org.mapstruct.Named;

public class MonedaMapper {

    @Named("stringToMoneda")
    public static Moneda stringToMoneda(String moneda) {
        if (moneda == null) return null;

        return switch (moneda.toUpperCase()){
            case "COP" -> Moneda.COP;
            case "PEN" -> Moneda.PEN;
            default -> null;
        };
    }

    @Named("monedaToString")
    public static String monedaToString(Moneda moneda) {
        if (moneda == null) return null;

        return switch (moneda){
            case COP -> "COP";
            case PEN -> "PEN";
            default -> null;
        };
    }
}
