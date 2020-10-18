package com.desafio.ais.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlocacaoHoraDTO {
	private Long id;

	@NotNull
	private LocalDate dataRegistro;
	
	@NotNull
	private Integer qtdHoraTrabalho;
	
	@NotBlank
	private String projeto;
}
