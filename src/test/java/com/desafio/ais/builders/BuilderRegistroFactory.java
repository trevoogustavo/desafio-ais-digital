package com.desafio.ais.builders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.enums.TurnoEnum;
import com.desafio.ais.model.Registro;

public class BuilderRegistroFactory {
	
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
