package com.desafio.ais.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RegistroPontoDTO {
	
	private FuncionarioDTO funcionarioDTO;
	private TurnoMatutinoDTO matutino;
	private TurnoVespertinoDTO vespertino;

}
