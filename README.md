# API Funcionario
A aplicação utiliza uma conexão com PostgresSQL.  
  
Necessário criação do container via comando: **docker run --name postgres -e POSTGRES_PASSWORD=12345 -p 5447:5432 -d postgres**


# Endpoints 
	
## Adicionar funcionario
@POST /funcionario/adicionar  
  
Envio:   
{
    "nome": "Taylan",
    "sobrenome": "Fernandes",
    "email": "@gmail.com",
    "numeroNis": 123654
}

Retorno:
200 OK

## Consultar
@GET /funcionario/consutar/{idFuncionario}

Retorno:
{
    "id": 1,
    "nome": "Taylan",
    "sobrenome": "Fernandes",
    "email": "taylan@gmail.com",
    "numeroNis": 123654
}

## Editar
@PATCH /funcionario/editar/{idFuncionario}  

Quaquer campo pode ser editado.

Envio:   
{  
   "email": "taylanfernandes@gmail.com" 
}

Retorno:
200 OK

## Deletar
@DELETE /funcionario/remover/{idFuncionario}

Retorno:
200 OK

## Listar
@GET /funcionario/listar
  
[
	{
        "id": 1,
        "nome": "Taylan",
        "sobrenome": "Fernandes",
        "email": "taylan@gmail.com",
        "numeroNis": 123654
    },
    {
        "id": 2,
        "nome": "Joao",
        "sobrenome": "Da Silva",
        "email": "joaosilva@gmail.com",
        "numeroNis": 123654
    }
]