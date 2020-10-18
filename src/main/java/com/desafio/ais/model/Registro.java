package com.desafio.ais.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafio.ais.enums.TurnoEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Registro")
@Getter
@Setter
@NoArgsConstructor

public class Registro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TurnoEnum turno;
	
	@Column(name = "data_hora_registro")
	private LocalDateTime dataRegistro;
	
	private Integer ano;
	private Integer mes;
	private Integer dia;
	private Integer horas;
	private Integer minutos;
	
	@Column(name = "registro_inicial")
	private boolean registroInicial;
	
	@Column(name = "registro_final")
	private boolean registroFinal;
	private Integer horaDeAlmoco;
	
}
