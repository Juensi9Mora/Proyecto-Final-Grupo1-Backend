package com.micancha.controller;

import com.micancha.entity.Cancha;
import com.micancha.service.CanchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canchas")
public class CanchaController {

    private final CanchaService canchaService;

    @Autowired
    public CanchaController(CanchaService canchaService) {
        this.canchaService = canchaService;
    }

    @GetMapping
    public List<Cancha> getAllCanchas(){
        return canchaService.findAll();
    }

    @GetMapping("/{id}")
    public Cancha createCancha(@PathVariable Long id) {
        return canchaService.findById(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Cancha> getCanchasByNombre(@PathVariable String nombre) {
        return canchaService.findByNombre(nombre);
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<Cancha> getCanchasByCiudad(@PathVariable String ciudad) {
        return canchaService.findByCiudad(ciudad);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Cancha> getCanchasByCategoria(@PathVariable String categoria) {
        return canchaService.findByCategoria(categoria);
    }

    @GetMapping("/estado/{estado}")
    public List<Cancha> getCanchasByEstado(@PathVariable String estado) {
        return canchaService.findByEstado(estado);
    }

    @PostMapping
    public Cancha createCancha(@RequestBody Cancha cancha) {
        return canchaService.save(cancha);
    }

    @PutMapping("/{id}")
    public Cancha updateCancha(@PathVariable Long id, @RequestBody Cancha cancha) {
        return canchaService.update(id, cancha);
    }

    @DeleteMapping("/{id}")
    public void deleteCancha(@PathVariable Long id) {
        canchaService.deleteById(id);
    }
}
