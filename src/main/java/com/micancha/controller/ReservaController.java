package com.micancha.controller;

import com.micancha.service.ReservaServiceJPA;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaServiceJPA reservaServiceJPA;

    public ReservaController(ReservaServiceJPA reservaServiceJPA) {
        this.reservaServiceJPA = reservaServiceJPA;
    }


}
