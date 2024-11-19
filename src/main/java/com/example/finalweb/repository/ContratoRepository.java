package com.example.finalweb.repository;

import com.example.finalweb.entity.Contrato; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    
}
