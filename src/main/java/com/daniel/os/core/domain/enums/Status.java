package com.daniel.os.core.domain.enums;

public enum Status {
	ABERTA(1,"ABERTA"), 
	CONCLUIDA(2,"CONCLUIDA"), 
	EXECUTANDO(3,"EXECUTANDO");

	private Integer cod;
	private String descricao;

	private Status(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	public static Status toenum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Prioridade Invalida!!!");
		
	}
}


