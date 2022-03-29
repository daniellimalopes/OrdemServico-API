package com.daniel.os.dataprovaider.mapper;

import java.util.Optional;

import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.core.domain.enums.Prioridade;
import com.daniel.os.core.domain.enums.Status;
import com.daniel.os.dataprovaider.entity.OrdemServicoEntity;

public class OrdemServicoEntityMapper {
	
	public static final OrdemServico to(OrdemServicoEntity ordemServicoEntity) {
		return Optional.ofNullable(ordemServicoEntity).map(entity -> OrdemServico.builder()
				.id(entity.getId())
				.dataAbertura(entity.getDataAbertura())
				.dataFechamento(entity.getDataFechamento())
				.observacao(entity.getObservacao())
				.prioridade(Prioridade.toenum(entity.getPrioridadeId()))
				.status(Status.toenum(entity.getStatusId()))
				.clienteId(entity.getClienteId())
				.tecnicoId(entity.getTecnicoId())
				.build())
				.orElse(new OrdemServico());
	}
	
	

	public static final OrdemServicoEntity from(OrdemServico ordemServico) {
		return Optional.ofNullable(ordemServico).map(domain -> OrdemServicoEntity.builder()
				.id(domain.getId())
				.dataAbertura(domain.getDataAbertura())
				.dataFechamento(domain.getDataFechamento())
				.observacao(domain.getObservacao())
				.prioridadeId(domain.getPrioridade().getCod())
				.statusId(domain.getStatus().getCod())
				.tecnicoId(domain.getTecnicoId())
				.clienteId(domain.getClienteId())
				.build())
				.orElse(new OrdemServicoEntity());
	}

	
}
