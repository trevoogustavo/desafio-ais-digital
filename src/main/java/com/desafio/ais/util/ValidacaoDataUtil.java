package com.desafio.ais.util;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.desafio.ais.exceptions.ErroNegocioalException;

public class ValidacaoDataUtil {

	private ValidacaoDataUtil() {}
	
	public static boolean validaDataInicialMenorQueFinal(final LocalDateTime dataHoraInicio, final LocalDateTime dataHoraFim) {
		return dataHoraInicio.isBefore(dataHoraFim);
	}
	
	public static void validaDataFinalMaiorQueInicial(final LocalDateTime dataHoraInicio, final LocalDateTime dataHoraFim) throws  ErroNegocioalException{		
		if(dataHoraFim.isBefore(dataHoraInicio)) { ;
		throw new ErroNegocioalException("Hora final  menor que hora inicial");
		}
	}
	

	public static boolean validaDataInicialMenorQueAtual( final LocalDateTime dataHoraFim) {
		return dataHoraFim.isBefore(LocalDateTime.now());
	}
	
	public static boolean fimDeSemana(final LocalDateTime datahora) {
		DayOfWeek d = datahora.getDayOfWeek();
		return d.equals(DayOfWeek.SATURDAY) || d.equals(DayOfWeek.SUNDAY);
	}
	
//	public static boolean horarioAlmoco(RegistroPonto manha, RegistroPonto tarde) {
//		
//		return (tarde.getHorarioEntrada().getHour() - manha.getHorarioSaida().getHour() >= 1);
//	}
	
	// falta implementar
	public static boolean turnoManha(LocalDateTime localDateTime) {
		return localDateTime.getHour() < 12 ;
	}
	
	public boolean  turnoTarde(LocalDateTime localDateTime) {
		return localDateTime.getHour() > 12 && localDateTime.getMinute() >= 1;		
	}
}
