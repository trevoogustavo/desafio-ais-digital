package com.desafio.ais.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.desafio.ais.model.AlocacaoHora;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AlocacaoHoraRepositoryTest {

	final static String PROJETO_NOME = "Teste";
	final static Integer QTD_HORAS= 2;
	 @Autowired
	    private AlocacaoHoraRepository repository;
	 
	 @Test
	 @Order(1)
	 public void insertAlocacao() {
		 AlocacaoHora alocacao = buildAlocacao();
		 repository.save(alocacao);
		 Integer  count  = repository.findAll().size();
		 assertEquals(1, count);
		 Optional<AlocacaoHora> confere =  repository.findByDataRegistro(alocacao.getDataRegistro());
		 Assertions.assertTrue(confere.isPresent());
	 }
	 
		
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
}
