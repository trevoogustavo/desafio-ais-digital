package com.desafio.ais.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.ais.dto.RegistroDTO;
import com.desafio.ais.dto.RegistroUpdateDTO;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.service.RegistroPontoServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/registros")
@CrossOrigin
public class PeriodoResource {

	@Autowired
	RegistroPontoServiceImpl service;


	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
		@Operation(summary = "Cria um Registro de ponto ")  
	   			@ApiResponses(value = {	  
			   @ApiResponse(responseCode = "201", description =
			   "Registro criado com sucesso !!", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
			   		RegistroDTO.class))}),
			   @ApiResponse(responseCode = "500", description = "Erro Interno",  content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
	   			})
	public ResponseEntity<RegistroDTO> salvaRegistro(@RequestBody @Valid RegistroDTO registroDTO) throws ErroNegocioalException {
		return new ResponseEntity<RegistroDTO>(service.salvaRegistro(registroDTO), HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
		@Operation(summary = "Altera um Registro de ponto ")  
	   			@ApiResponses(value = {	  
			   @ApiResponse(responseCode = "204", description =
			   "Registro Alterado com sucesso!!", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
			   		RegistroUpdateDTO.class))}),
			   @ApiResponse(responseCode = "500", description = "Erro Interno",  content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
	   			})
	public ResponseEntity alteraRegistro(@RequestBody @Valid RegistroUpdateDTO registroUpdateDTO, @PathVariable("id") Long id) throws ErroNegocioalException {
		service.alteraRegistro(registroUpdateDTO, id);
		return new ResponseEntity( HttpStatus.NO_CONTENT);
	}


}
