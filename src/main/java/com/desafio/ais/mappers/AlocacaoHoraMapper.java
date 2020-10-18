package com.desafio.ais.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.desafio.ais.dto.AlocacaoHoraDTO;
import com.desafio.ais.model.AlocacaoHora;

@Component
@Scope("singleton")
public class AlocacaoHoraMapper {

    public AlocacaoHora toEntity(AlocacaoHoraDTO dto) {
        if ( Objects.isNull(dto) ) {
            return null;
        }
        
        AlocacaoHora alocacaoHora = new AlocacaoHora();
        alocacaoHora.setId(dto.getId());
        alocacaoHora.setAno(dto.getDataRegistro().getYear());
        alocacaoHora.setMes(dto.getDataRegistro().getMonthValue());
        alocacaoHora.setDia(dto.getDataRegistro().getDayOfMonth());
        alocacaoHora.setDataRegistro(dto.getDataRegistro());
        alocacaoHora.setProjeto(dto.getProjeto());
        alocacaoHora.setQtdHoraTrabalho(dto.getQtdHoraTrabalho());
        return alocacaoHora;
    }
    
    public AlocacaoHoraDTO toDTO(AlocacaoHora alocacaoHora) {
        if ( Objects.isNull(alocacaoHora) ) {
            return null;
        }
        
        AlocacaoHoraDTO dto = new AlocacaoHoraDTO();
        dto.setId(alocacaoHora.getId());
        dto.setDataRegistro(alocacaoHora.getDataRegistro());
        dto.setProjeto(alocacaoHora.getProjeto());
        dto.setQtdHoraTrabalho(alocacaoHora.getQtdHoraTrabalho());
        return dto;
    }
    
    public List<AlocacaoHoraDTO> toDtoList(List<AlocacaoHora>  entities){
    	List<AlocacaoHoraDTO> dtos = new ArrayList<AlocacaoHoraDTO>();
    	entities.forEach(a -> {
    		dtos.add(toDTO(a));
    	});
    	return dtos;
    }	
}
