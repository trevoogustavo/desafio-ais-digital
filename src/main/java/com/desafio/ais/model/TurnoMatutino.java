package com.desafio.ais.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name = "Turno_Matutino")
@Getter
@Setter
public class TurnoMatutino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "data_hora_entrada")
	private LocalDateTime dataHorarioEntrada;
	
	@Column(name = "data_hora_saida")
	private LocalDateTime dataHorarioSaida;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "registro_id")
	private RegistroPonto registro;
}
