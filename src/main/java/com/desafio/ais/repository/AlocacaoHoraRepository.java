package com.desafio.ais.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.ais.model.AlocacaoHora;

public interface AlocacaoHoraRepository  extends JpaRepository<AlocacaoHora, Long>{

	Optional<AlocacaoHora> findByDataRegistro(LocalDate dataRegistro);
}
