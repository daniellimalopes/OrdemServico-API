package com.daniel.os.core.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.dataprovaider.gateway.OrdemServicoGateway;

@Service
public class OrdemServicoBusiness {

	@Autowired
	private OrdemServicoGateway ordemServicoGateway;
	
	
	@Transactional
	public OrdemServico cadastrarOrdemServico( OrdemServico ordemServico) {	
		ordemServico.setId(null);
		ordemServico= ordemServicoGateway.cadastrarOrdemServico(ordemServico);
		
		return ordemServico;
	}	
		
}
