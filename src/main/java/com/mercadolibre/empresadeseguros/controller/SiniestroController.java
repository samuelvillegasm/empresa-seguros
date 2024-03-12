package com.mercadolibre.empresadeseguros.controller;

import com.mercadolibre.empresadeseguros.dto.request.CreateSiniestroDto;
import com.mercadolibre.empresadeseguros.dto.response.SiniestroDto;
import com.mercadolibre.empresadeseguros.service.impl.SiniestroService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siniestro")
public class SiniestroController {

    private final SiniestroService siniestroService;

    public SiniestroController(SiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SiniestroDto>> getAllSiniestros() {
        return ResponseEntity.ok().body(
                this.siniestroService.getAll()
        );
    }

    @PostMapping("/new")
    public ResponseEntity<SiniestroDto> postSiniestro(@RequestBody CreateSiniestroDto createSiniestroDto) {
        return new ResponseEntity<>(
                this.siniestroService.create(createSiniestroDto),
                HttpStatus.CREATED
        );
    }
}
