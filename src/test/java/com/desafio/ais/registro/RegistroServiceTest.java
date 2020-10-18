package com.desafio.ais.registro;

import java.util.ArrayList;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.web.WebAppConfiguration;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.model.Registro;
import com.desafio.ais.repository.RegistroRepository;
import com.desafio.ais.service.RegistroPontoServiceImpl;

@SpringBootTest
@WebAppConfiguration
public class RegistroServiceTest {

	private Registro registro;
	private RegistroDTO dto;
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
	
	@MockBean
	private RegistroRepository repository;
	
	
//	@Test
//	@Order(1)
	public void deveSalvarRegistro() throws ErroNegocioalException {
		
		
		Mockito.when(repository.findRegistroByMesAndDia(registro.getMes(),registro.getMes())).thenReturn(new ArrayList<Registro>());
		Mockito.when(repository.findRegistroByParams(registro.getTurno(), registro.getDia(), registro.getMes())).thenReturn(null);
		
		RegistroDTO result = service.salvaRegistro(dto);
		//assertNotNull(result);
		//assertEquals(expected, actual);
	}
}
