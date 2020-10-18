package com.desafio.ais.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.desafio.ais.enums.TurnoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// @NamedQuery(name = "RegistroPonto.findByIdFuncionarioAndDataAtual", query = "select r from RegistroPonto r where r.")
@Table(name = "Registro_ponto",  uniqueConstraints={@UniqueConstraint(columnNames = "dataRegistro")})
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegistroPonto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	
//	@Enumerated(EnumType.STRING)
//	@Column(name = "turno")
//	private TurnoEnum turnoEnum;
	
	private LocalDate dataRegistro = LocalDate.now();
	@OneToOne(mappedBy = "registro")
	private TurnoMatutino matutino;
	
	@OneToOne(mappedBy = "registroPonto" )
	private TurnoVespertino vespertino;

}
