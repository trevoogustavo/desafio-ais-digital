package com.desafio.ais.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.enums.TurnoEnum;
import com.desafio.ais.model.Registro;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RegistroRepositoryTest {

	 @Autowired
	    private RegistroRepository repository;
	 
	 @Test
	 @Order(1)
	 public void insertRegistro() {
		 Registro registro = criaRegistro();
		 repository.save(registro);
		 Integer  count  = repository.findAll().size();
		 assertEquals(1, count);
		 Optional<Registro> confere =  repository.findBydataRegistro(registro.getDataRegistro());
		 Assertions.assertTrue(confere.isPresent());
	 }
//	 
	 
		public static Registro criaRegistro() {
			Registro r = new Registro();
			LocalDateTime horario = LocalDateTime.of(2020, 10, 21, 10, 10);
			r.setDataRegistro(horario);
			r.setAno(horario.getYear());
			r.setMes(horario.getMonthValue());
			r.setDia(horario.getDayOfMonth());
			r.setMinutos(horario.getMinute());
			r.setTurno(TurnoEnum.MATUTINO);
			r.setHoras(horario.getHour());
			r.setRegistroInicial(true);
			return r;
		}
		
		public static RegistroDTO criaRegistroDTO() {
			RegistroDTO dto = new RegistroDTO();
			dto.setDataRegistro(LocalDateTime.of(2020, 10, 21, 10, 10));
			dto.setTurno(TurnoEnum.MATUTINO);
			return dto;
		}
		
		public static List<Registro>  buildListVazia(){
			return new ArrayList<>();
		}

}
