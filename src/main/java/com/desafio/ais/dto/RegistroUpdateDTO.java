package com.desafio.ais.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.desafio.ais.enums.TurnoEnum;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroUpdateDTO {
	
	@NotNull
	private TurnoEnum turno;
	@NotNull
	private LocalDateTime dataRegistro;
	@NotNull
	private LocalDateTime dataRegistroUpdate;
}
