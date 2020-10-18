package com.desafio.ais.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.dto.RegistroUpdateDTO;
import com.desafio.ais.model.Registro;

@Component
@Scope("singleton")
public class RegistroMapper {



//    public RegistroPontoDTO toDTO(RegistroPonto entity) {
//        if ( entity == null ) {
//            return null;
//        }
//        RegistroPontoDTO registroPontoDTO = new RegistroPontoDTO();
//
//        registroPontoDTO.setTurno(entity.getTurnoEnum());
//        registroPontoDTO.setFuncionarioDTO(funcionarioMapper.toDTO(entity.getFuncionario()));
//        registroPontoDTO.setHorarioEntrada( entity.getHorarioEntrada() );
//        registroPontoDTO.setHorarioSaida( entity.getHorarioSaida() );
//
//        return registroPontoDTO;
//    }


    public Registro toEntity(RegistroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Registro registro = new Registro();
        registro.setAno(dto.getDataRegistro().getYear());
        registro.setMes( dto.getDataRegistro().getMonthValue());
        registro.setDia(dto.getDataRegistro().getDayOfMonth()) ;
        registro.setHoras(dto.getDataRegistro().getHour());
        registro.setMinutos(dto.getDataRegistro().getMinute());
        registro.setDataRegistro(dto.getDataRegistro());
        registro.setTurno(dto.getTurno());
        return registro;
    }
    
    public Registro RegitroUpdateDTOtoEntity(RegistroUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Registro registro = new Registro();
        registro.setAno(dto.getDataRegistroUpdate().getYear());
        registro.setMes( dto.getDataRegistroUpdate().getMonthValue());
        registro.setDia(dto.getDataRegistroUpdate().getDayOfMonth()) ;
        registro.setHoras(dto.getDataRegistroUpdate().getHour());
        registro.setMinutos(dto.getDataRegistroUpdate().getMinute());
        registro.setDataRegistro(dto.getDataRegistroUpdate());
        registro.setTurno(dto.getTurno());
        return registro;
    }
    
    
}
