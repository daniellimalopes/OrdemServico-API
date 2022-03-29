package com.daniel.os.dataprovaider.gateway;

import com.daniel.os.core.domain.OrdemServico;

public interface OrdemServicoGateway {
	
	OrdemServico cadastrarOrdemServico(OrdemServico ordemServico);


	OrdemServico buscarUsuarioPorId(Integer id);

}
