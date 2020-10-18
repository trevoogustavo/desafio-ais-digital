package com.desafio.ais.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDTO {

	private String matricula;
	private String nome;
	private List<RegistroPontoDTO> registros ;
}
