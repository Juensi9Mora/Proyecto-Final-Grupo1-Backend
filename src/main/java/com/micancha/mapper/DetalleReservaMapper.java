package com.micancha.mapper;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.entity.DetalleReservaEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {MetodoPagoMapper.class, MonedaMapper.class, EstadoReservaMapper.class})
public interface DetalleReservaMapper {

    @Mapping(source = "cancha.id", target = "canchaId")
    @Mapping(source = "cancha.nombre", target = "canchaNombre")
    @Mapping(source = "cancha.direccion", target = "canchaDireccion")
    //@Mapping(source = "fechaReserva", target = "fechaReserva")
    //@Mapping(source = "horaInicio", target = "horaInicio")
    //@Mapping(source = "cantidadHoras", target = "cantidadHoras")
    @Mapping(source = "cancha.precioHora", target = "precioHora")
    @Mapping(source = "metodoPago", target = "metodoPago", qualifiedByName = "stringToMetodoPago")
    //@Mapping(source = "total", target = "total")
    @Mapping(source = "moneda", target = "moneda", qualifiedByName = "stringToMoneda")
    @Mapping(source = "estado", target = "estado", qualifiedByName = "stringToEstadoReserva")
    DetalleReservaDto toDto(DetalleReservaEntity  detalleReserva);
    List<DetalleReservaDto> toDto(List<DetalleReservaEntity> detalleReservas);

}
