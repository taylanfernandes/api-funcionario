package com.taylan.crudfuncionario.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {
    
    private Integer id;

    private String nome;

    private String sobrenome;

    private String email;
    
    private Integer numeroNis;

}
