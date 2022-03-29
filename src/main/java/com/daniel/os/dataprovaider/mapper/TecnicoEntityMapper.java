package com.daniel.os.dataprovaider.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.entity.OrdemServicoEntity;
import com.daniel.os.dataprovaider.entity.TecnicoEntity;

public class TecnicoEntityMapper {
	
	public static final Tecnico to(TecnicoEntity tecnicoEntity) {
		return Optional.ofNullable(tecnicoEntity).map(entity -> Tecnico.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.cargo(entity.getCargo())
				.cpf(entity.getCpf())
				.ordemServicos(toOrdemServico(entity.getOrdemServicos()))
				.build())
				.orElse(new Tecnico());
	}

	private static List<OrdemServico> toOrdemServico(List<OrdemServicoEntity> ordemServicosEntity) {
		List<OrdemServico> ordemServicos = new ArrayList<>();
		for(OrdemServicoEntity ordemServicoEntity : ordemServicosEntity) {
			ordemServicos.add(OrdemServicoEntityMapper.to(ordemServicoEntity));
		}
		return ordemServicos;
	}

	
	
	public static final TecnicoEntity from(Tecnico tecnico) {
		return Optional.ofNullable(tecnico).map(domain -> TecnicoEntity.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cargo(domain.getCargo())
				.cpf(domain.getCpf())
				.ordemServicos(fromOrdemServico(domain.getOrdemServicos()))
				.build())
				.orElse(new TecnicoEntity());
	}

	private static List<OrdemServicoEntity> fromOrdemServico(List<OrdemServico> ordemServicos) {
		List<OrdemServicoEntity> ordemServicosEntity = new ArrayList<>();
		for(OrdemServico ordemServico : ordemServicos) {
			ordemServicosEntity.add(OrdemServicoEntityMapper.from(ordemServico));
		}
		return ordemServicosEntity;
	}
}
