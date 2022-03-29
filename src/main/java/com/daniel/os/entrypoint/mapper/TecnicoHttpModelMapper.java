package com.daniel.os.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.entity.OrdemServicoEntity;
import com.daniel.os.dataprovaider.mapper.OrdemServicoEntityMapper;
import com.daniel.os.entrypoint.httpmodel.TecnicoHttpModel;

public class TecnicoHttpModelMapper {
	public static final Tecnico to(TecnicoHttpModel tecnicoHttpModel) {
		return Optional.ofNullable(tecnicoHttpModel).map(httpModel -> Tecnico.builder()
				.id(httpModel.getId())
				.nome(httpModel.getNome())
				.cpf(httpModel.getCpf())
				.cargo(httpModel.getCargo())
				.ordemServicos(toOrdemServico(httpModel.getOrdemServicos()))
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
	public static final TecnicoHttpModel from(Tecnico tecnico) {
		return Optional.ofNullable(tecnico).map(domain -> TecnicoHttpModel.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cpf(domain.getCpf())
				.cargo(domain.getCargo())
				.ordemServicos(fromOrdemServico(domain.getOrdemServicos()))
				.build())
				.orElse(new TecnicoHttpModel());
	}
	private static List<OrdemServicoEntity> fromOrdemServico(List<OrdemServico> ordemServicos) {
		List<OrdemServicoEntity> ordemServicosEntity = new ArrayList<>();
		for(OrdemServico ordemServico : ordemServicos) {
			ordemServicosEntity.add(OrdemServicoEntityMapper.from(ordemServico));
		}
		return ordemServicosEntity;
	}
}
