package com.daniel.os.entrypoint.mapper;

import java.util.Optional;

import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.core.domain.enums.Prioridade;
import com.daniel.os.core.domain.enums.Status;
import com.daniel.os.entrypoint.httpmodel.OrdemServicoHttpModel;

public class OrdemServicoHttpModelMapper {
	public static final OrdemServico to(OrdemServicoHttpModel ordemServicoHttpModel) {
		return Optional.ofNullable(ordemServicoHttpModel).map(httpModel -> OrdemServico.builder()
				.id(httpModel.getId())
				.dataAbertura(httpModel.getDataAbertura())
				.dataFechamento(httpModel.getDataFechamento())
				.observacao(httpModel.getObservacao())
				.prioridade(Prioridade.toenum(httpModel.getPrioridadeId()))
				.status(Status.toenum(httpModel.getStatusId()))
				.tecnicoId(httpModel.getTecnicoId())
				.clienteId(httpModel.getClienteId())
				.build())
				.orElse(new OrdemServico());
	}
	public static final OrdemServicoHttpModel from(OrdemServico ordemServico) {
		return Optional.ofNullable(ordemServico).map(domain -> OrdemServicoHttpModel.builder()
				.id(domain.getId())
				.dataAbertura(domain.getDataAbertura())
				.dataFechamento(domain.getDataAbertura())
				.observacao(domain.getObservacao())
				.prioridadeId(domain.getPrioridade().getCod())
				.statusId(domain.getStatus().getCod())
				.clienteId(domain.getClienteId())
				.tecnicoId(domain.getTecnicoId())
				.build())
				.orElse(new OrdemServicoHttpModel());
	}

	
	
}
