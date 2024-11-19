package com.example.finalweb.controller;

import com.example.finalweb.entity.Contrato;
import com.example.finalweb.service.ContratoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    // Crear un nuevo contrato
    @PostMapping
    public Contrato crearContrato(@RequestBody Contrato contrato) {
        return contratoService.crearContrato(contrato);
    }

    // Actualizar un contrato existente
    @PutMapping("/{id}")
    public Contrato actualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        return contratoService.actualizarContrato(id, contrato);
    }

    // Eliminar un contrato por ID
    @DeleteMapping("/{id}")
    public void eliminarContrato(@PathVariable Long id) {
        contratoService.eliminarContrato(id);
    }

    // Consultar todos los contratos
    @GetMapping
    public List<Contrato> obtenerTodosLosContratos() {
        return contratoService.obtenerTodosContratos();
    }

    // Consultar un contrato por ID
    @GetMapping("/{id}")
    public Contrato obtenerContratoPorId(@PathVariable Long id) {
        return contratoService.obtenerContratoPorId(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado con el id: " + id));
    }
}
