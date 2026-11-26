package com.micancha.mapper;

import com.micancha.dto.ReservaDto;
import com.micancha.entity.DetalleReservaEntity;
import com.micancha.entity.ReservaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cancha", ignore = true)
    @Mapping(target = "reserva", ignore = true)
    @Mapping(target = "total", ignore = true)
    @Mapping(target = "moneda", ignore = true)
    @Mapping(target = "estado", ignore = true)
    DetalleReservaEntity toEntity(ReservaDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cancha", ignore = true)   // el service asigna la nueva cancha
    @Mapping(target = "reserva", ignore = true)  // la cabecera no cambia
    @Mapping(target = "total", ignore = true)    // el service lo recalcula
    @Mapping(target = "moneda", ignore = true)   // no lo envía el cliente
    @Mapping(target = "estado", ignore = true)   // el cliente no cambia el estado
    void updateEntity(ReservaDto dto, @MappingTarget DetalleReservaEntity entity);
}
