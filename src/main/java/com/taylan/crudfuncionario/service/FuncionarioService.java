package com.taylan.crudfuncionario.service;

import java.util.List;

import com.taylan.crudfuncionario.converter.FuncionarioConverter;
import com.taylan.crudfuncionario.model.dto.FuncionarioDTO;
import com.taylan.crudfuncionario.model.entity.Funcionario;
import com.taylan.crudfuncionario.repository.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FuncionarioService {

    private FuncionarioConverter converter = new FuncionarioConverter();

    @Autowired
    private Repository funcionarioRepository;

    public void adicionar(FuncionarioDTO funcionarioDTO){
        validarFuncionario(funcionarioDTO);
        final Funcionario funcionario = converter.converterFuncionarioDTO(funcionarioDTO);
        funcionarioRepository.save(funcionario);
    }

    public void remover(Integer idFuncionario){
        final Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElse(null);
        if(funcionario != null){
            funcionarioRepository.delete(funcionario);
        }
    }
   
    public FuncionarioDTO consultar(Integer idFuncionario){
        return converter.converterFuncionarioEmDTO(funcionarioRepository.findById(idFuncionario)
            .orElseThrow(() -> new RuntimeException("Nome do funcionário deve conter no minímo 2 caracteres")));
    }

    public void editar(Integer idFuncionario, FuncionarioDTO funcionarioDTO){
        final Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElse(null);
        if(funcionario != null){
            if(funcionarioDTO.getNome() != null 
                && !funcionarioDTO.getNome().isEmpty()){
                validarNome(funcionarioDTO.getNome());
                funcionario.setNome(funcionarioDTO.getNome());
            }
            if(funcionarioDTO.getSobrenome() != null 
                && !funcionarioDTO.getSobrenome().isEmpty()){
                validarSobrenome(funcionarioDTO.getSobrenome());
                funcionario.setSobrenome(funcionarioDTO.getSobrenome());
            }
            if(funcionarioDTO.getEmail() != null 
                && !funcionarioDTO.getEmail().isEmpty()){
                validarEmail(funcionarioDTO.getEmail());
                funcionario.setEmail(funcionarioDTO.getEmail());
            }
            if(funcionarioDTO.getNumeroNis() != null){
                funcionario.setNumeroNIS(funcionarioDTO.getNumeroNis());
            }
            funcionarioRepository.save(funcionario);
        }
    }

    public List<FuncionarioDTO> listar(){
        return converter.converterListaFuncionarioEmListaDTO(funcionarioRepository.findAll());
    }

    public void validarFuncionario(FuncionarioDTO funcionarioDTO){
        validarNome(funcionarioDTO.getNome());
        validarSobrenome(funcionarioDTO.getSobrenome());
        validarEmail(funcionarioDTO.getEmail());
    }

    private void validarNome(String nome){
        if(nome == null){
            throw new RuntimeException("Nome do funcionário não informado");
        }
        if(nome.length() < 2){
            throw new RuntimeException("Nome do funcionário deve conter no minímo 2 caracteres");
        }
        if(nome.length() > 30){
            throw new RuntimeException("Nome do funcionário deve conter no máximo 30 caracteres");
        }
    }

    private void validarSobrenome(String sobrenome){
        if(sobrenome == null){
            throw new RuntimeException("Sobrenome do funcionário não informado");
        }
        if(sobrenome.length() < 2){
            throw new RuntimeException("Sobrenome do funcionário deve conter no minímo 2 caracteres");
        }
        if(sobrenome.length() > 50){
            throw new RuntimeException("Sobrenome do Sobrenome deve conter no máximo 50 caracteres");
        }
    }

    private void validarEmail(String email){
        if (!StringUtils.hasLength(StringUtils.trimAllWhitespace(email))) {
            throw new RuntimeException("E-mail não informado");
        }
    }
}
