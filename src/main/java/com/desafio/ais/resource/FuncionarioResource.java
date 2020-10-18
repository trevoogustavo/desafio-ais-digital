package com.desafio.ais.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.ais.dto.FuncionarioDTO;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.model.RegistroPonto;
import com.desafio.ais.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

	@Autowired
	FuncionarioService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary  = "Registro de Funcionario")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201", 
				description = "Funcionário registrado com sucesso",
				content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FuncionarioDTO.class))}),
		@ApiResponse(responseCode = "500", 
		description = "Violação de Unique Constraint",  
		content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
	})
	public ResponseEntity<FuncionarioDTO> salvar(@RequestBody FuncionarioDTO funcDTO) throws ErroNegocioalException{
		return new ResponseEntity<FuncionarioDTO>(service.salvar(funcDTO), HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary  = "Lista  Funcionario")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", 
				description = "Sucesso ao consultar Funcionarios",
				content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FuncionarioDTO.class))}),
		@ApiResponse(responseCode = "500", 
		description = "Erro interno da aplicação",  
		content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
	})
	public ResponseEntity listarTodos() throws ErroNegocioalException{
		return new ResponseEntity(new ArrayList<FuncionarioDTO>(), HttpStatus.OK);
	}
	
}
