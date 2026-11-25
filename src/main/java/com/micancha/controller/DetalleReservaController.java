package com.micancha.controller;

import com.micancha.dto.DetalleReservaDto;
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
    public ResponseEntity<List<DetalleReservaDto>> getAll() {
        return ResponseEntity.ok(this.detalleReservaServiceJPA.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleReservaDto> getById (@PathVariable Long id){
        DetalleReservaDto responseDto = this.detalleReservaServiceJPA.getById(id);

        if (responseDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseDto);
    }
}
/*
    @GetMapping("/mostrarreservas")
    public ResponseEntity<MensajeDto> getAll() {
        MensajeDto mensaje = new MensajeDto();
        List<DetalleReservaDto> list;
        list = this.detalleReservaServiceJPA.getAll();

        mensaje.setCode("0");
        mensaje.setMensaje("Lista de reservas");
        mensaje.setDato(list);

        return ResponseEntity.ok(mensaje);
    }
    */

