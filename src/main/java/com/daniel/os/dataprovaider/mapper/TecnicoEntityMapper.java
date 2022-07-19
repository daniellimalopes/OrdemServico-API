package com.daniel.os.dataprovaider.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.daniel.os.core.domain.DadosDeLogin;
import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.entity.DadosDeLoginEntity;
import com.daniel.os.dataprovaider.entity.TecnicoEntity;

public class TecnicoEntityMapper {
	
	public static final Tecnico to(TecnicoEntity tecnicoEntity) {
		return Optional.ofNullable(tecnicoEntity).map(entity -> Tecnico.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.cargo(entity.getCargo())
				.cpf(entity.getCpf())
				.telefone(entity.getTelefone())
				.dadosDeLogins(toDadosDeLogins(entity.getDadosDeLogins()))
				.build())
				.orElse(new Tecnico());
	}

	private static List<DadosDeLogin> toDadosDeLogins(List<DadosDeLoginEntity> dadosDeLoginsEntity) {
		List<DadosDeLogin> dadosDeLogin = new ArrayList<>();
		for(DadosDeLoginEntity dadosDeLoginEntity : dadosDeLoginsEntity) {
			dadosDeLogin.add(DadosDeLoginEntityMapper.to(dadosDeLoginEntity));
		}
		return dadosDeLogin;
	}

	public static final TecnicoEntity from(Tecnico tecnico) {
		return Optional.ofNullable(tecnico).map(domain -> TecnicoEntity.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cargo(domain.getCargo())
				.cpf(domain.getCpf())
				.telefone(domain.getTelefone())
				.dadosDeLogins(fromDadosDeLogins(domain.getDadosDeLogins()))
				.build())
				.orElse(new TecnicoEntity());
	}
	
	private static List<DadosDeLoginEntity> fromDadosDeLogins(List<DadosDeLogin> dadosDeLogins) {
		List<DadosDeLoginEntity> dadosDeLoginEntitys = new ArrayList<>();
		for(DadosDeLogin dadosDeLogin : dadosDeLogins) {
			dadosDeLoginEntitys.add(DadosDeLoginEntityMapper.from(dadosDeLogin));
			
		}
		return dadosDeLoginEntitys;
	}
}
