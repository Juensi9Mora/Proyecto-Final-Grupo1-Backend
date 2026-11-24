package com.micancha.controller;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.entity.DetalleReservaEntity;
import com.micancha.service.DetalleReservaServiceJPA;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detalle-reserva")
public class DetalleReservaController {

    private final DetalleReservaServiceJPA detalleReservaServiceJPA;

    public DetalleReservaController(DetalleReservaServiceJPA detalleReservaServiceJPA) {
        this.detalleReservaServiceJPA = detalleReservaServiceJPA;
    }

    @GetMapping
    public ResponseEntity<List<DetalleReservaDto>> getAll(){
        return ResponseEntity.ok(this.detalleReservaServiceJPA.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleReservaDto> getById(@PathVariable Long id){
        DetalleReservaDto dto = this.detalleReservaServiceJPA.getById(id);

        if(dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }
}
