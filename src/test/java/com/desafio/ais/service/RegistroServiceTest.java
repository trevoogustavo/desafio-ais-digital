package com.desafio.ais.service;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.desafio.ais.builders.BuilderRegistroFactory;
import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.mappers.RegistroMapper;
import com.desafio.ais.model.Registro;
import com.desafio.ais.repository.RegistroRepository;
import com.desafio.ais.service.RegistroPontoServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class RegistroServiceTest {


//	@Before
//	public void setup() {
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
//		
//		RegistroDTO dto = new RegistroDTO();
//		dto.setDataRegistro(LocalDateTime.of(2020, 10, 21, 10, 10));
//		dto.setTurno(TurnoEnum.MATUTINO);
//	
//	}
	
	@Autowired
	private RegistroPontoServiceImpl service;
	
	@Autowired
	private RegistroMapper mapper;
	
	@MockBean
	private RegistroRepository repository;
	

	
//	@Test
//	@Order(1)
//	public void deveSalvarRegistro() throws ErroNegocioalException {	
//		Registro registro = BuilderRegistroFactory.criaRegistro();
//		RegistroDTO dto = BuilderRegistroFactory.criaRegistroDTO();
//		Mockito.when(repository.findRegistroByMesAndDia(registro.getMes(),registro.getMes())).thenReturn(new ArrayList<Registro>());
//		Mockito.when(repository.findRegistroByParams(registro.getTurno(), registro.getDia(), registro.getMes())).thenReturn(null);
//		
//		RegistroDTO result = service.salvaRegistro(dto);
//		Assertions.assertNotNull(result);
//		Assertions.assertEquals(dto.getDataRegistro(), result.getDataRegistro());
//		//assertEquals(expected, actual);
//	}
}
