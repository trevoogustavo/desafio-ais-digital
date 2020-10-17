package com.desafio.ais.enums;

public enum TurnoEnum {

	MATUTINO("Manhã"), VESPERTINO("Tarde");
	private String descricao;
	
	private TurnoEnum(String descricao) {this.descricao = descricao; }
	
	public String getDescricao() {return descricao; }
}
