package com.daniel.os.dataprovaider.mapper;

import java.util.Optional;

import com.daniel.os.core.domain.DadosDeLogin;
import com.daniel.os.dataprovaider.entity.DadosDeLoginEntity;

public class DadosDeLoginEntityMapper {
	
	public static final DadosDeLogin to(DadosDeLoginEntity dadosDeLoginEntity) {
		return Optional.ofNullable(dadosDeLoginEntity).map(entity -> DadosDeLogin.builder()
				.id(entity.getId())
				.Email(entity.getEmail())
				.senha(entity.getSenha())
				.tecnicoId(entity.getTecnicoId())
				.build())
				.orElse(new DadosDeLogin());
	}

	public static final DadosDeLoginEntity from(DadosDeLogin  dadosDeLogin ) {
		return Optional.ofNullable(dadosDeLogin).map(domain -> DadosDeLoginEntity.builder()
				.id(domain.getId())
				.email(domain.getEmail())
				.senha(domain.getSenha())
				.tecnicoId(domain.getTecnicoId())
				.build())
				.orElse(new DadosDeLoginEntity());
	}
}
