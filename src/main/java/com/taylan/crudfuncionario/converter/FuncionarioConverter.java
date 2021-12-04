package com.taylan.crudfuncionario.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.taylan.crudfuncionario.model.dto.FuncionarioDTO;
import com.taylan.crudfuncionario.model.entity.Funcionario;

public class FuncionarioConverter {

    public FuncionarioDTO converterFuncionarioEmDTO(Funcionario funcionario){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        
        if(funcionario != null){
            if(funcionario.getId() != null){
                funcionarioDTO.setId(funcionario.getId());
            }
            if(funcionario.getNome() != null){
                funcionarioDTO.setNome(funcionario.getNome());
            }
            if(funcionario.getSobrenome() != null){
                funcionarioDTO.setSobrenome(funcionario.getSobrenome());
            }
            if(funcionario.getEmail() != null){
                funcionarioDTO.setEmail(funcionario.getEmail());
            }
            if(funcionario.getNumeroNIS() != null){
                funcionarioDTO.setNumeroNis(funcionario.getNumeroNIS());
            }
        }

        return funcionarioDTO;
    }

    public Funcionario converterFuncionarioDTO(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario();
        
        if(funcionarioDTO != null){
            if(funcionarioDTO.getId() != null){
                funcionario.setId(funcionarioDTO.getId());
            }
            if(funcionarioDTO.getNome() != null){
                funcionario.setNome(funcionarioDTO.getNome());
            }
            if(funcionarioDTO.getSobrenome() != null){
                funcionario.setSobrenome(funcionarioDTO.getSobrenome());
            }
            if(funcionarioDTO.getEmail() != null){
                funcionario.setEmail(funcionarioDTO.getEmail());
            }
            if(funcionarioDTO.getNumeroNis() != null){
                funcionario.setNumeroNIS(funcionarioDTO.getNumeroNis());
            }
        }

        return funcionario;
    }

    public List<FuncionarioDTO> converterListaFuncionarioEmListaDTO(Collection<Funcionario> funcionarios) {
        List<FuncionarioDTO> listaFuncionariosDTO = new ArrayList<>();
        if (funcionarios != null && !funcionarios.isEmpty()) {
           for (Funcionario f : funcionarios) {
            listaFuncionariosDTO.add(converterFuncionarioEmDTO(f));
           }
        }
        return listaFuncionariosDTO;
    }

    public List<Funcionario> converterFuncionario(Collection<FuncionarioDTO> funcionariosDTO) {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        if (funcionariosDTO != null && !funcionariosDTO.isEmpty()) {
            for (FuncionarioDTO f : funcionariosDTO) {
                listaFuncionarios.add(converterFuncionarioDTO(f));
           }
        }
        return listaFuncionarios;
    }

}
