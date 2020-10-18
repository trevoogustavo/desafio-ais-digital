package com.desafio.ais.registro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.desafio.ais.builders.BuilderRegistroFactory;
import com.desafio.ais.model.Registro;
import com.desafio.ais.repository.RegistroRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RegistroRepositoryTest {

	 @Autowired
	    private RegistroRepository repository;
	 
	 @Test
	 @Order(1)
	 public void insertRegistro() {
		 Registro registro = BuilderRegistroFactory.criaRegistro();
		 repository.save(registro);
		 Integer  count  = repository.findAll().size();
		 assertEquals(1, count);
		 Optional<Registro> confere =  repository.findBydataRegistro(registro.getDataRegistro());
		 assertNotNull(confere.isPresent());
	 }
	 

}
