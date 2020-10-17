package com.desafio.ais.resource;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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

import com.desafio.ais.model.Funcionario;
import com.desafio.ais.model.RegistroPonto;
import com.desafio.ais.model.Teste;
import com.desafio.ais.repository.FuncionarioRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/registros")

public class PeriodoResource {

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Operation(summary  = "Registros de ponto")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Olá mundo", 
			content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RegistroPonto.class))})
	})
	@Transactional
	public ResponseEntity<String> teste(@RequestBody RegistroPonto registroPonto) {
		Funcionario f = new Funcionario();
		List<RegistroPonto> reg = new ArrayList<RegistroPonto>();
		reg.add(registroPonto);
		f.setNome("Funcionario2");
		f.setRegistrosDePonto(reg);
		funcionarioRepository.save(f);
		return new ResponseEntity<String>("Sucesso", HttpStatus.OK);
	}
}
