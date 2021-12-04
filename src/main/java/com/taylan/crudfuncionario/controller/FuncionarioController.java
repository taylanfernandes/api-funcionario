package com.taylan.crudfuncionario.controller;


import java.util.List;

import com.taylan.crudfuncionario.model.dto.FuncionarioDTO;
import com.taylan.crudfuncionario.service.FuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping(path = "/adicionar", consumes = "application/json")
    public void adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        service.adicionar(funcionarioDTO);
    }

    @DeleteMapping(path = "/remover/{idFuncionario}")
    public void remover(@PathVariable("idFuncionario") Integer idFuncionario){
        service.remover(idFuncionario);
    }

    @GetMapping(path = "/consultar/{idFuncionario}")
    public FuncionarioDTO consultar(@PathVariable("idFuncionario") Integer idFuncionario){
        return service.consultar(idFuncionario);
    }

    @GetMapping(path = "/listar")
    public List<FuncionarioDTO> listarFuncionarios() {
        return service.listar();
    }

    @PutMapping(path = "/editar/{idFuncionario}", consumes = "application/json")
    public void editar(@PathVariable("idFuncionario") Integer idFuncionario, @RequestBody FuncionarioDTO funcionarioDTO){
        service.editar(idFuncionario, funcionarioDTO);
    }
}
