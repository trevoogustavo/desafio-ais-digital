package com.desafio.ais.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.dto.RegistroPontoDTO;
import com.desafio.ais.dto.RegistroUpdateDTO;
import com.desafio.ais.enums.TurnoEnum;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.mappers.RegistroMapper;
import com.desafio.ais.model.Funcionario;
import com.desafio.ais.model.Registro;
import com.desafio.ais.repository.RegistroRepository;
import com.desafio.ais.util.ValidacaoDataUtil;


@Service
public class RegistroPontoServiceImpl{
	
	
	@Autowired
	RegistroMapper mapper;

	@Autowired
	RegistroRepository repository;
	
//	RegistroPontoDTO registraEntradaMatutino(RegistroPontoDTO dto) throws ErroNegocioalException {
//		//RegistroPonto registro = mapper.toEntity(dto);
//		//ValidacaoDataUtil.
//		//repository.save(registro);
//		return dto;
//	}
//	
	@Transactional
	public RegistroDTO salvaRegistro(RegistroDTO dto) throws ErroNegocioalException {
		Registro registro = mapper.toEntity(dto);
		verificaQuantidadeRegistrosNoDia(registro);
		verificaBatida(registro);
		repository.save(registro);
		return dto;
	}
	
	@Transactional
	public void alteraRegistro(RegistroUpdateDTO dto, Long  id) throws ErroNegocioalException {
		Optional<Registro> optional =  repository.findById(id);
		if(optional.isPresent()) {
			Registro registro = optional.get();
			registro = mapper.RegitroUpdateDTOtoEntity(dto);
			registro.setId(id);
			registro.setRegistroFinal(optional.get().isRegistroFinal());
			registro.setRegistroInicial(optional.get().isRegistroInicial());
			validaAlteracaoRegistro(registro, optional.get());		
			repository.save(registro);
		}else  {
			throw new ErroNegocioalException("Registro não encontrado na Base de dados");			
		}
//		verificaBatida(registro);
	}
	
//	public List<RegistroDTO> listaRegistrosDoDiaAtual(){
//		LocalDate.now();
//		
//	}
	
	public List<RegistroDTO> listaRegistrosDoMes(Integer mes){
		List<Registro> list =  repository.findByMes(mes);
		return  null;
	}
	
		private void  validaAlteracaoRegistro(Registro registro,  Registro bd ) throws ErroNegocioalException {
		validaSobrePosicaoPeriodoManha(registro.getTurno(), registro.getHoras());
		validaSobrePosicaoPeriodoTarde(registro.getTurno(), registro.getHoras());
		 if(bd.isRegistroFinal()) {
			 Registro bdAnterior = repository.findRegistroByInicialTurno(bd.getTurno(), bd.getDia(), bd.getMes(), true);
			 ValidacaoDataUtil.validaDataFinalMaiorQueInicial(bdAnterior.getDataRegistro(), registro.getDataRegistro());
		 } else {
			 Registro bdPosterior =  repository.findRegistroByFinalTurno(bd.getTurno(), bd.getDia(), bd.getMes(), true);
			 ValidacaoDataUtil.validaDataFinalMaiorQueInicial(registro.getDataRegistro(), bdPosterior.getDataRegistro());
		 }
	}
	
	private void verificaBatida(Registro registro) throws ErroNegocioalException {
		validaFimDeSemana(registro);
		verificaTurnoEnum(registro);
		// Registro registroBd = repository.findRegistroByParams(registro.getTurno(), registro.getDia(),  registro.getMes());
	}
	
	private void verificaQuantidadeRegistrosNoDia(Registro registro) throws ErroNegocioalException {
		List<Registro> registros = repository.findRegistroByMesAndDia(registro.getMes(), registro.getDia());
		if(registros.size() >= 4) {
			throw new ErroNegocioalException("O número máximo de registros por dia é 4");
			}		
	}
	
	private void  verificaTurnoEnum(Registro registro) throws ErroNegocioalException {
		if(registro.getTurno().equals(TurnoEnum.MATUTINO)){
			validaSobrePosicaoPeriodoManha(registro.getTurno(), registro.getHoras());
			Registro  bd = repository.findRegistroByParams(registro.getTurno(), registro.getDia(), registro.getMes());
			if(Objects.isNull(bd)) {
				registro.setRegistroInicial(true);
			} else {
				ValidacaoDataUtil.validaDataFinalMaiorQueInicial(bd.getDataRegistro(), registro.getDataRegistro());
				registro.setRegistroFinal(true);
			}
		}else {
			// turno vespertino 
			validaSobrePosicaoPeriodoTarde(registro.getTurno(), registro.getHoras());
			Registro  bd = repository.findRegistroByParams(registro.getTurno(), registro.getDia(), registro.getMes());
			if(Objects.isNull(bd)) {
				calculaHoraDeAlmoco(registro);
				registro.setRegistroInicial(true);
			} else {
				ValidacaoDataUtil.validaDataFinalMaiorQueInicial(bd.getDataRegistro(), registro.getDataRegistro());				
				registro.setRegistroFinal(true);
			}
		}
	}
	
//	private void validaTurno(Registro registro, Registro bd) throws ErroNegocioalException {
//		if(registro.getTurno().equals(bd.getTurno())) {
//			validaHoraFinalMaiorQueInicial(bd.getData_registro(), registro.getData_registro());
//		}else {
//			
//		}
//		
//	}
	
	private void validaFimDeSemana(Registro registro) throws  ErroNegocioalException{
		if(ValidacaoDataUtil.fimDeSemana(registro.getDataRegistro())) {
			throw new ErroNegocioalException("Não pode realizar registro nos finais de semana");
		}
	}
	
	
//	private void validaHoraFinalMaiorQueInicial(LocalDateTime horaInicio, LocalDateTime horaFim) throws ErroNegocioalException {
//		if (!ValidacaoDataUtil.validaDataFinalMaiorQueInicial(horaInicio, horaFim)) {
//			throw new ErroNegocioalException("Hora final do turno menor que hora inicial do turno");			
//		}		
//	}
	
//	private void validaHoraFinalMenorQueInicial(LocalDateTime horaInicio, LocalDateTime horaFim) throws ErroNegocioalException {
//		if (!ValidacaoDataUtil.validaDataFinalMaiorQueInicial(horaInicio, horaFim)) {
//			throw new ErroNegocioalException("Hora final do turno menor que hora inicial do turno");			
//		}		
//	}
	
	private void calculaHoraDeAlmoco(Registro registro) throws  ErroNegocioalException {
		Registro registroBd = repository.findRegistroByFinalTurno(TurnoEnum.MATUTINO, registro.getDia(), registro.getMes(), true);
		LocalDateTime horarioAlmoco = registro.getDataRegistro().minusHours(registroBd.getDataRegistro().getHour());
		horarioAlmoco = horarioAlmoco.minusMinutes(registro.getDataRegistro().getMinute());
		if(horarioAlmoco.getHour() > 1)  {
			throw new ErroNegocioalException("Você ainda não terminou o seu horário de almoço, volte mais tarde");
		}
		registro.setHoraDeAlmoco(horarioAlmoco.getHour());
	}
	
	private void validaSobrePosicaoPeriodoManha(TurnoEnum turno, Integer horario) throws ErroNegocioalException {
		if(turno.equals(TurnoEnum.MATUTINO) && horario >= 12 ) {
			throw new ErroNegocioalException("O horário está sobrepondo o periodo MANHÃ");
		}		
	}
	
	private void validaSobrePosicaoPeriodoTarde(TurnoEnum turno, Integer horario) throws ErroNegocioalException {
		if(turno.equals(TurnoEnum.VESPERTINO) && horario < 12) {
			throw new ErroNegocioalException("O Periodo TARDE está sobrepondo o horário ");
		}
	}
	
	
//	
//	RegistroPontoDTO registraSaida(RegistroPontoDTO dto) throws ErroNegocioalException {
//	
//		//RegistroPonto  registro = repository.findByIdFuncionarioAndDataAtual(funcionario.getId(), LocalDateTime.now());
//		//repository.save(registro);
//		return null;
//	}
	
	
}
