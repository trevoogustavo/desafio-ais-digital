package com.desafio.ais.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.desafio.ais.enums.TurnoEnum;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroDTO {

	@NotNull
	private TurnoEnum turno;
	@NotNull
	private LocalDateTime dataRegistro;
}
