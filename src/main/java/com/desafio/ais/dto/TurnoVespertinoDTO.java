package com.desafio.ais.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TurnoVespertinoDTO {

	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy:HH:mm", locale = "pt_BR")
	private LocalDateTime dataHorarioEntrada;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy:HH:mm", locale = "pt_BR")
	private LocalDateTime dataHorarioSaida;
}
