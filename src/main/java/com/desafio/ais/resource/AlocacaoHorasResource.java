package com.desafio.ais.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.ais.dto.AlocacaoHoraDTO;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.service.AlocacaoHoraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/alocacoes")
//@CrossOrigin("*")
public class AlocacaoHorasResource {

	@Autowired
	AlocacaoHoraService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	
		@Operation(summary = "Cria um Registro de alocação de horas trabalhadas em um determinado projeto ")  
	   			@ApiResponses(value = {	  
			   @ApiResponse(responseCode = "201", description =
			   "Registro criado com sucesso !!", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation =
					   AlocacaoHoraDTO.class))}),
			   @ApiResponse(responseCode = "500", description = "Erro Interno",  content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
	   			})
	public ResponseEntity<AlocacaoHoraDTO> salvar(@RequestBody @Valid AlocacaoHoraDTO dto) throws ErroNegocioalException {
		return new ResponseEntity<AlocacaoHoraDTO>(service.salvar(dto), HttpStatus.CREATED);
	}
}
