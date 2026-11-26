package com.micancha.controller;

import com.micancha.dto.DetalleReservaDto;
import com.micancha.dto.ReservaDto;
import com.micancha.service.DetalleReservaServiceJPA;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/reservas")
public class DetalleReservaController {

    private final DetalleReservaServiceJPA detalleReservaServiceJPA;

    public DetalleReservaController(DetalleReservaServiceJPA detalleReservaServiceJPA) {
        this.detalleReservaServiceJPA = detalleReservaServiceJPA;
    }

    @GetMapping
    public PagedModel<DetalleReservaDto> getAll(@PageableDefault(size = 10, sort = "fechaReserva",
                                                        direction = Sort.Direction.ASC) Pageable pageable) {
        return new PagedModel<>(detalleReservaServiceJPA.getAll(pageable));

    }

    @GetMapping("/{id}")
    public DetalleReservaDto getById(@PathVariable Long id) {
        return detalleReservaServiceJPA.getById(id);
    }

    @PostMapping
    public ResponseEntity<DetalleReservaDto> save(@Valid @RequestBody ReservaDto dto,
                                                  @RequestParam Long usuarioId) {
        DetalleReservaDto creada = detalleReservaServiceJPA.save(dto, usuarioId);
        return ResponseEntity.created(URI.create("/api/reservas/" + creada.canchaId())).body(creada);
    }

    @PutMapping("/{id}")
    public DetalleReservaDto update(@PathVariable Long id, @Valid @RequestBody ReservaDto dto) {
        return detalleReservaServiceJPA.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        detalleReservaServiceJPA.delete(id);
        return ResponseEntity.noContent().build();
    }
}

