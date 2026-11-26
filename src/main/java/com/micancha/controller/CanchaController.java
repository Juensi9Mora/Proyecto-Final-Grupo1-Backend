
package com.micancha.controller;

import com.micancha.dto.CanchaDTO;
import com.micancha.entity.CanchaEntity;
import com.micancha.service.CanchaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/canchas")
public class CanchaController {

    private final CanchaService canchaService;

    @Autowired
    public CanchaController(CanchaService canchaService) {
        this.canchaService = canchaService;
    }

    @GetMapping
    public List<CanchaDTO> getAllCanchas() {
        return canchaService.findAll()
                .stream()
                .map(CanchaDTO::fromEntity)
                .toList();
    }

    @GetMapping("/{id}")
    public CanchaDTO getCanchaById(@PathVariable Long id) {
        return CanchaDTO.fromEntity(canchaService.findById(id));
    }

    @GetMapping("/estado/{estado}")
    public List<CanchaDTO> getByEstado(@PathVariable String estado) {
        return canchaService.findByEstado(estado)
                .stream()
                .map(CanchaDTO::fromEntity)
                .toList();
    }

    @GetMapping("/nombre/{nombre}")
    public List<CanchaDTO> getCanchasByNombre(@PathVariable String nombre) {
        return canchaService.findByNombre(nombre)
                .stream()
                .map(CanchaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<CanchaDTO> getCanchasByCiudad(@PathVariable String ciudad) {
        return canchaService.findByCiudad(ciudad)
                .stream()
                .map(CanchaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/categoria/{categoria}")
    public List<CanchaDTO> getCanchasByCategoria(@PathVariable String categoria) {
        return canchaService.findByCategoria(categoria)
                .stream()
                .map(CanchaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/pais/{pais}")
    public List<CanchaDTO> getCanchasByPais(@PathVariable String pais) {
        return canchaService.findByPais(pais)
                .stream()
                .map(CanchaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar")
    public List<CanchaDTO> getCanchasByCiudadAndCategoria(@RequestParam String ciudad, @RequestParam String categoria) {
        return canchaService.findByCiudadAndCategoria(ciudad, categoria)
                .stream()
                .map(CanchaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/precio")
    public List<CanchaDTO> getCanchasByPrecio(@RequestParam BigDecimal maximo) {
        return canchaService.findByPrecioHoraLessThanEqual(maximo)
                .stream()
                .map(CanchaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping
    public CanchaDTO createCancha(@RequestBody CanchaDTO canchaDTO) {
        CanchaEntity cancha = canchaDTO.toEntity();
        return CanchaDTO.fromEntity(canchaService.save(cancha));
    }

    @PutMapping("/{id}")
    public CanchaDTO updateCancha(@PathVariable Long id, @RequestBody CanchaDTO canchaDTO) {
        CanchaEntity cancha = canchaDTO.toEntity();
        return CanchaDTO.fromEntity(canchaService.update(id, cancha));
    }

    @DeleteMapping("/{id}")
    public void deleteCancha(@PathVariable Long id) {
        canchaService.deleteById(id);
    }
}