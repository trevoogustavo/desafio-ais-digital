package com.desafio.ais.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

//@Table(name = "Funcionario", uniqueConstraints={@UniqueConstraint(columnNames = "matricula")} )
//@Entity
@Getter
@Setter
public class Funcionario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String matricula;
	
	private String nome;

	
	@OneToMany(mappedBy = "funcionario",  orphanRemoval = true)
	private List<RegistroPonto> registrosDePonto =  new ArrayList<>();
	
}
