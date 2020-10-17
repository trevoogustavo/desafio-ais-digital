package com.desafio.ais.mappers;

import org.mapstruct.Mapper;

import com.desafio.ais.dto.FuncionarioDTO;
import com.desafio.ais.model.Funcionario;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper extends AbstractMapper<Funcionario, FuncionarioDTO>{

}
