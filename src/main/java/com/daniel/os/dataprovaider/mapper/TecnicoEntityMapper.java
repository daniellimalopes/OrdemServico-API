package com.daniel.os.dataprovaider.mapper;

import java.util.Optional;

import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.entity.TecnicoEntity;

public class TecnicoEntityMapper {
	
	public static final Tecnico to(TecnicoEntity tecnicoEntity) {
		return Optional.ofNullable(tecnicoEntity).map(entity -> Tecnico.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.cargo(entity.getCargo())
				.cpf(entity.getCpf())
				.build())
				.orElse(new Tecnico());
	}

	public static final TecnicoEntity from(Tecnico tecnico) {
		return Optional.ofNullable(tecnico).map(domain -> TecnicoEntity.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cargo(domain.getCargo())
				.cpf(domain.getCpf())
				.build())
				.orElse(new TecnicoEntity());
	}
}
