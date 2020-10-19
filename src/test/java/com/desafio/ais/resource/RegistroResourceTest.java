package com.desafio.ais.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.enums.TurnoEnum;
import com.desafio.ais.service.RegistroPontoServiceImpl;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@WebMvcTest(PeriodoResource.class)
class RegistroResourceTest {

	@MockBean
	private RegistroPontoServiceImpl service;
	 
    @Autowired
	private MockMvc mvc;

	@Test 
	@Order(1)
	public void deveRetornarBadRequest() throws Exception {
		RegistroDTO dto = new RegistroDTO();
		//dto.setDataRegistro(LocalDateTime.of(2020, 10, 21, 10, 10, 10));		
		//dto.setTurno(TurnoEnum.MATUTINO);
		
	  // 	Mockito.when(service.salvaRegistro(dto)).thenReturn(dto);
    	Gson gson = new Gson();
    	String json = gson.toJson(dto);
    	mvc.perform(
    			post("/registros")
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(json))
    			.andExpect(status().isCreated())
    			.andReturn();
	}
	@Test 
	@Order(2)
	public void deveRetornarStatusCreated() throws Exception {
		RegistroDTO dto = new RegistroDTO();;
    	Gson gson = new Gson();
    	String json = gson.toJson(dto);
    	
    	mvc.perform(
    			post("/registros")
    			.contentType(MediaType.APPLICATION_JSON_VALUE))
    			.andExpect(status().isBadRequest())
    			.andReturn();
	}
	
	
//
//	
//	public static  Registro buildRegistro() {
//		Registro r = new Registro();
//		LocalDateTime horario = LocalDateTime.of(2020, 10, 21, 10, 10);
//		r.setDataRegistro(horario);
//		r.setAno(horario.getYear());
//		r.setMes(horario.getMonthValue());
//		r.setDia(horario.getDayOfMonth());
//		r.setMinutos(horario.getMinute());
//		r.setTurno(TurnoEnum.MATUTINO);
//		r.setHoras(horario.getHour());
//		r.setRegistroInicial(true);
//		return r;
//	}
//	
//	public static List<Registro>  buildListVazia(){
//		return new ArrayList<>();
//	}
}
