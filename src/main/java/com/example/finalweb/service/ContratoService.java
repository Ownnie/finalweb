package com.example.finalweb.service;

import com.example.finalweb.entity.Contrato;
import com.example.finalweb.repository.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository){
        this.contratoRepository = contratoRepository;
    }

    public Contrato crearContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public Contrato actualizarContrato(Long id, Contrato contratoActualizado) {
        return contratoRepository.findById(id)
        .map (contrato -> {
            contrato.setIdentificador(contratoActualizado.getIdentificador());
                    contrato.setValor(contratoActualizado.getValor());
                    contrato.setNombreContratante(contratoActualizado.getNombreContratante());
                    contrato.setDocumentoContratante(contratoActualizado.getDocumentoContratante());
                    contrato.setNombreContratantista(contratoActualizado.getNombreContratantista());
                    contrato.setDocumentoContratantista(contratoActualizado.getDocumentoContratantista());
                    contrato.setFechaInicial(contratoActualizado.getFechaInicial());
                    contrato.setFechaFinal(contratoActualizado.getFechaFinal());
                    return contratoRepository.save(contrato);
        }).orElseThrow(()-> new RuntimeException("Contrato no encontrado con el id: " + id));
    }

    public void eliminarContrato(Long id){
        contratoRepository.deleteById(id);
    }

    public List<Contrato> obtenerTodosContratos() {
        return contratoRepository.findAll();
    }

    public Optional<Contrato> obtenerContratoPorId(Long id){
        return contratoRepository.findById(id);
    } 

}
