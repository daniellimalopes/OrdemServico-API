package com.daniel.os.entrypoint.mapper;

import java.util.Optional;

import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.entrypoint.httpmodel.TecnicoHttpModel;

public class TecnicoHttpModelMapper {
	public static final Tecnico to(TecnicoHttpModel tecnicoHttpModel) {
		return Optional.ofNullable(tecnicoHttpModel).map(httpModel -> Tecnico.builder()
				.id(httpModel.getId())
				.nome(httpModel.getNome())
				.cpf(httpModel.getCpf())
				.cargo(httpModel.getCargo())
				.build())
				.orElse(new Tecnico());
	}

	public static final TecnicoHttpModel from(Tecnico tecnico) {
		return Optional.ofNullable(tecnico).map(domain -> TecnicoHttpModel.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cpf(domain.getCpf())
				.cargo(domain.getCargo())
				.build())
				.orElse(new TecnicoHttpModel());
	}
	
}
