package com.desafio.ais.mappers;

import com.desafio.ais.dto.FuncionarioDTO;
import com.desafio.ais.model.Funcionario;
import org.mapstruct.Mapper;

import com.desafio.ais.dto.RegistroPontoDTO;
import com.desafio.ais.model.RegistroPonto;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistroPontoMapper {

    RegistroPontoDTO toDTO(RegistroPonto entity);

    RegistroPonto toEntity(RegistroPontoDTO dto);
}
