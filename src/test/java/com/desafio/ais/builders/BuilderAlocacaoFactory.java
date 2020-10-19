package com.desafio.ais.builders;

import java.time.LocalDate;

import com.desafio.ais.dto.AlocacaoHoraDTO;
import com.desafio.ais.model.AlocacaoHora;

public class BuilderAlocacaoFactory {
	final static String PROJETO_NOME = "Teste";
	final static Integer QTD_HORAS= 2;
	
	public static AlocacaoHora buildAlocacao() {
		AlocacaoHora hora = new AlocacaoHora();
		hora.setDataRegistro(LocalDate.now());
		hora.setAno(hora.getDataRegistro().getYear());
		hora.setMes(hora.getDataRegistro().getMonthValue());
		hora.setDia(hora.getDataRegistro().getDayOfMonth());
		hora.setProjeto(PROJETO_NOME);
		hora.setQtdHoraTrabalho(QTD_HORAS);
		return hora;
	}
	
	public AlocacaoHoraDTO buildDTO() {
		AlocacaoHoraDTO  dto = new AlocacaoHoraDTO();
		dto.setDataRegistro(LocalDate.now());
		dto.setProjeto("ProjetoTeste");
		dto.setQtdHoraTrabalho(2);
		return dto;
	}
}
