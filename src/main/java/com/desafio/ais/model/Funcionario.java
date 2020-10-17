package com.desafio.ais.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Funcionario")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@EqualsAndHashCode
public class Funcionario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String matricula;
	
	private String nome;
	
	
	@OneToMany(mappedBy = "funcionario", cascade = CascadeType.PERSIST,  orphanRemoval = true)
	private List<RegistroPonto> registrosDePonto =  new ArrayList<>();
}
