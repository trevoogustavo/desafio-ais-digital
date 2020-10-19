package com.desafio.ais.resource;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.desafio.ais.dto.AlocacaoHoraDTO;
import com.desafio.ais.exceptions.ErroNegocioalException;
import com.desafio.ais.service.AlocacaoHoraService;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@WebMvcTest(AlocacaoHorasResource.class)
public class AlocacaoHoraResourceTest {
	
	@MockBean
	private AlocacaoHoraService service;
	 
    @Autowired
	private MockMvc mvc;

    @Test
    @Order(1)
    public void deveRetornarStatusCreated()  throws Exception {
    	//Mockito.when(service.salvar(buildDTO())).thenReturn(buildDTO());
    	Gson gson = new Gson();
    	String json = gson.toJson(buildDTO());
    	mvc.perform(
    			post("/alocacoes")
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(json))
    			.andExpect(status().isCreated())
    			.andReturn();
    }
    
    @Test
    @Order(2)
    public void deveRetornarBadRequest()  throws Exception {
    	AlocacaoHoraDTO dto = new AlocacaoHoraDTO();
    	Gson gson = new Gson();
    	String json = gson.toJson(dto);
    	
    	mvc.perform(post("/alocacoes")
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.content(json))
    			.andExpect(status().isBadRequest())
    			.andReturn();
    }
    
	public AlocacaoHoraDTO buildDTO() {
		AlocacaoHoraDTO  dto = new AlocacaoHoraDTO();
		dto.setDataRegistro(LocalDate.now());
		dto.setProjeto("ProjetoTeste");
		dto.setQtdHoraTrabalho(2);
		return dto;
	}
}
