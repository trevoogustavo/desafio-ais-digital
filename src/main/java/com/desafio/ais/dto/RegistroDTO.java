package com.desafio.ais.dto;

import java.time.LocalDateTime;

import com.desafio.ais.enums.TurnoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistroDTO {

	private TurnoEnum turno;
	private LocalDateTime dataRegistro;
}
