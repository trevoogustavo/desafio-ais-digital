package com.desafio.ais.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;

public interface AbstractMapper<T, D> {

	T toEntity(D dto);
	
	// @InheritInverseConfiguration(name = "toEntity")
	D toDto(D entity);
	
	@IterableMapping(qualifiedByName = "toDto")
	List<D> toDtoList(List<T> entities);
	
	@IterableMapping(qualifiedByName = "toEntity")
	List<T> toEntityList(List<D> dtos);
}
