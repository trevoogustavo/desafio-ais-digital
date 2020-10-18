package com.desafio.ais.registro;

import static org.hamcrest.CoreMatchers.any;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.enums.TurnoEnum;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.model.Registro;
import com.desafio.ais.repository.RegistroRepository;
import com.desafio.ais.resource.PeriodoResource;
import com.desafio.ais.service.RegistroPontoServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


//@ExtendWith(SpringExtension.class)
//@WebMvcTest(controllers = PeriodoResource.class)
class RegistroResourceTest {

//	@Autowired
//    private MockMvc mockMvc;
//	
//	@MockBean
//	private RegistroPontoServiceImpl service;
//	
//	@MockBean
//	private RegistroRepository repository;
//	
//	//@Test  
//	public void deveRetornarStatusOkSalvarRegistro() throws Exception {
//		RegistroDTO dto = new RegistroDTO();
//		dto.setDataRegistro(LocalDateTime.of(2020, 10, 21, 10, 10));
//		dto.setTurno(TurnoEnum.MATUTINO);
//		Mockito.when(service.salvaRegistro(dto)).thenReturn(dto);
//		Mockito.when(repository.findRegistroByMesAndDia(buildRegistro().getMes(),buildRegistro().getMes())).thenReturn(buildListVazia());
//		Mockito.when(repository.findRegistroByParams(buildRegistro().getTurno(), buildRegistro().getDia(), buildRegistro().getMes())).thenReturn(null);
//		this.mockMvc.perform(post("/registros"))
//		.andExpect(status().isOk());
//	}
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
