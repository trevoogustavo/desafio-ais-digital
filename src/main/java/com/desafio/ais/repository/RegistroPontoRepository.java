package com.desafio.ais.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.ais.model.RegistroPonto;

public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {

//	@Query("select r from RegistroPonto r where r.funcionario.matricula = :idFuncionario and r. = :data")
//	RegistroPonto findByIdFuncionarioAndDataAtual(@Param("matriculaUsuario")String matriculaUsuario, @Param("data")LocalDateTime localDate);
}
