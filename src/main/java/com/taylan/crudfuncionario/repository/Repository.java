package com.taylan.crudfuncionario.repository;

import com.taylan.crudfuncionario.model.entity.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Funcionario, Integer> {
    
}
