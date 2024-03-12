package com.mercadolibre.empresadeseguros.controller;

import com.mercadolibre.empresadeseguros.dto.request.CreateVehiculoDto;
import com.mercadolibre.empresadeseguros.dto.response.VehiculoDto;
import com.mercadolibre.empresadeseguros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    private final IVehiculoService iVehiculoService;

    public VehiculoController(IVehiculoService iVehiculoService) {
        this.iVehiculoService = iVehiculoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<VehiculoDto>> getAllVehiculos(){
        return ResponseEntity.ok().body(
                this.iVehiculoService.getAll()
        );
    }
    @PostMapping("/new")
    public ResponseEntity<VehiculoDto> postVehiculo(@RequestBody CreateVehiculoDto createVehiculoDto){
        VehiculoDto vehiculoDto = iVehiculoService.create(createVehiculoDto);
        return new ResponseEntity<VehiculoDto>(
                    vehiculoDto,
                    HttpStatus.CREATED
        );
    }

    @GetMapping("/query")
    public ResponseEntity<?> query(){
        this.iVehiculoService.queries();
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
