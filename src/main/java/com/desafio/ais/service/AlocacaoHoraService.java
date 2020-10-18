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
	
	private void validaTempoHoras(AlocacaoHora alocacao) throws ErroNegocioalException{
		// Lógica definia, só poderá salvar 4 registros por dia;
		LocalDateTime totalHoras;
		List<Registro> registrosManha = registroRepository.findByTurnoAndMesAndDiaOrderByDataRegistroDesc(TurnoEnum.MATUTINO ,alocacao.getMes(), alocacao.getDia());
		List<Registro> registrosTarde = registroRepository.findByTurnoAndMesAndDiaOrderByDataRegistroDesc(TurnoEnum.VESPERTINO ,alocacao.getMes(), alocacao.getDia());
		
		LocalDateTime horasManha = registrosManha.get(0).getDataRegistro();
		LocalDateTime horasTarde = registrosTarde.get(0).getDataRegistro();
		horasManha = horasManha.minusHours(registrosManha.get(1).getDataRegistro().getHour());
		horasTarde = horasTarde.minusHours(registrosTarde.get(1).getDataRegistro().getHour());
		horasManha = horasManha.plusHours(horasTarde.getHour() - 1);
		if(horasManha.getHour() + alocacao.getQtdHoraTrabalho() > 8) {
			 throw new ErroNegocioalException("Você já completou ás 8 horas de trabalho");
		}
		
		System.out.println(horasManha);
//		LocalDateTime minutosTrabalhados = registroDoDia.get(0).getDataRegistro();
//		
//		LocalDateTime totalHorasMatutino = horarioFinalMatutino.minusHours(horarioInicialMatutino.getHour());
//		LocalDateTime totalHorasVespertino = horarioFinalMatutino.minusHours(horarioInicialMatutino.getHour());
	}
}
