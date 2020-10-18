package com.desafio.ais.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafio.ais.enums.TurnoEnum;
import com.desafio.ais.model.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Long>{
	
	@Query("select r from Registro r where r.turno = :turno and r.dia = :dia and r.mes  =:mes")
	Registro findRegistroByParams(@Param("turno")TurnoEnum turno,
			@Param("dia")Integer diaMes,
			@Param("mes")Integer mes);
	
	@Query("select r from Registro r where r.mes = :mes and r.dia = :dia")
	List<Registro> findRegistroByMesAndDia(@Param("mes")Integer mes,
			@Param("dia")Integer diaMes);
	
	@Query("select r from Registro r where r.turno = :turno and r.dia = :dia and r.mes  =:mes and r.registroFinal = :registroFinal")
	Registro findRegistroByFinalTurno(@Param("turno")TurnoEnum turno,
			@Param("dia")Integer diaMes,
			@Param("mes")Integer mes, @Param("registroFinal")boolean registroFinal);
		
	List<Registro> findByMes(Integer mes);
	
	@Query("select r from Registro r where r.dataRegistro = :dataRegistro")
	Optional<Registro> findBydataRegistro(@Param("dataRegistro")LocalDateTime dataRegistro);
	
}
