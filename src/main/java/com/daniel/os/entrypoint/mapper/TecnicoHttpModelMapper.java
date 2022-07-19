package com.daniel.os.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.daniel.os.core.domain.DadosDeLogin;
import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.entity.DadosDeLoginEntity;
import com.daniel.os.dataprovaider.mapper.DadosDeLoginEntityMapper;
import com.daniel.os.entrypoint.httpmodel.TecnicoHttpModel;

public class TecnicoHttpModelMapper {
	public static final Tecnico to(TecnicoHttpModel tecnicoHttpModel) {
		return Optional.ofNullable(tecnicoHttpModel).map(httpModel -> Tecnico.builder()
				.id(httpModel.getId())
				.nome(httpModel.getNome())
				.cpf(httpModel.getCpf())
				.cargo(httpModel.getCargo())
				.telefone(httpModel.getTelefone())
				.dadosDeLogins(toDadosDeLogins(httpModel.getDadosDeLogins()))
				.build())
				.orElse(new Tecnico());
	}

	private static List<DadosDeLogin> toDadosDeLogins(List<DadosDeLoginEntity> dadosDeLoginsEntity) {
		List<DadosDeLogin> dadosDeLogin = new ArrayList<>();
		for(DadosDeLoginEntity dadosDeLoginEntity :dadosDeLoginsEntity ) {
			dadosDeLogin.add(DadosDeLoginEntityMapper.to(dadosDeLoginEntity));
		}
		return dadosDeLogin;
	}

	public static final TecnicoHttpModel from(Tecnico tecnico) {
		return Optional.ofNullable(tecnico).map(domain -> TecnicoHttpModel.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cpf(domain.getCpf())
				.cargo(domain.getCargo())
				.telefone(domain.getTelefone())
				.dadosDeLogins(fromDadosDeLogin(domain.getDadosDeLogins()))
				.build())
				.orElse(new TecnicoHttpModel());
	}

	private static List<DadosDeLoginEntity> fromDadosDeLogin(List<DadosDeLogin> dadosDeLogins) {
		 List<DadosDeLoginEntity> dadosDeLoginEntity = new ArrayList<>();
		 for(DadosDeLogin dadosDeLogin : dadosDeLogins) {
			 dadosDeLoginEntity.add(DadosDeLoginEntityMapper.from(dadosDeLogin));
		 }
		return dadosDeLoginEntity;
	}
	
}
