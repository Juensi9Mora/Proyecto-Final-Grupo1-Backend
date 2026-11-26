package com.micancha.controller;

import com.micancha.dto.ReservaDto;
import com.micancha.service.ReservaServiceJPA;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class ReservaController {

    private final ReservaServiceJPA reservaServiceJPA;

    public ReservaController(ReservaServiceJPA reservaServiceJPA) {
        this.reservaServiceJPA = reservaServiceJPA;
    }

    @GetMapping
    public ResponseEntity<List<ReservaDto>> getAll(){
        return ResponseEntity.ok(this.reservaServiceJPA.getAll());
    }
}
