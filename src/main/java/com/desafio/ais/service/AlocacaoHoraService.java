package com.desafio.ais.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.ais.dto.AlocacaoHoraDTO;
import com.desafio.ais.enums.TurnoEnum;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.mappers.AlocacaoHoraMapper;
import com.desafio.ais.model.AlocacaoHora;
import com.desafio.ais.model.Registro;
import com.desafio.ais.repository.AlocacaoHoraRepository;
import com.desafio.ais.repository.RegistroRepository;

@Service
public class AlocacaoHoraService {

	@Autowired
	AlocacaoHoraMapper mapper;
	
	@Autowired
	AlocacaoHoraRepository repository;
	
	@Autowired
	RegistroRepository registroRepository;
	

	public AlocacaoHoraDTO salvar(AlocacaoHoraDTO dto) throws ErroNegocioalException{
		
		AlocacaoHora alocacao = mapper.toEntity(dto);
		validaTempoHoras(alocacao);
		repository.save(alocacao);
		return mapper.toDTO(alocacao);
	}
	
	private void validaTempoHoras(AlocacaoHora alocacao) {
		// Lógica definia, só poderá salvar 4 registros por dia;
		List<Registro> registrosManha = registroRepository.findByParams(TurnoEnum.MATUTINO ,alocacao.getMes(), alocacao.getDia());
		List<Registro> registrosTarde = registroRepository.findByParams(TurnoEnum.VESPERTINO ,alocacao.getMes(), alocacao.getDia());
		System.out.println(registrosManha.get(0).getDataRegistro());
		
//		LocalDateTime horarioInicialVespertino = registroDoDia.get(2).getDataRegistro();
//		LocalDateTime horarioFinalVespertino = registroDoDia.get(3).getDataRegistro();
//		LocalDateTime minutosTrabalhados = registroDoDia.get(0).getDataRegistro();
//		
//		LocalDateTime totalHorasMatutino = horarioFinalMatutino.minusHours(horarioInicialMatutino.getHour());
//		LocalDateTime totalHorasVespertino = horarioFinalMatutino.minusHours(horarioInicialMatutino.getHour());
	}
}
