package com.desafio.ais.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.ais.dto.FuncionarioDTO;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.mappers.FuncionarioMapper;
import com.desafio.ais.model.Funcionario;
import com.desafio.ais.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioMapper mapper;
	
	@Autowired
	private FuncionarioRepository repository;
	
	@Transactional
	public FuncionarioDTO salvar(FuncionarioDTO dto) throws ErroNegocioalException{
		//Funcionario funcionario = repository.findByMatricula(dto.getMatricula());
//		if (Objects.nonNull(funcionario)) {
//			throw new ErroNegocioalException("Mátricula existente");
//		}
		Funcionario funcionario = mapper.toEntity(dto);
		repository.save(funcionario);
		return mapper.toDTO(funcionario);
	}
	

	
	protected Funcionario buscaFuncionarioPorMatricula(String matricula) throws ErroNegocioalException {
		//Funcionario funcionario =;
		return  repository.findByMatricula(matricula);
	}
}
