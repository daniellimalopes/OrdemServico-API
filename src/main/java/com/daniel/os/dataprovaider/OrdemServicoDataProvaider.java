package com.daniel.os.dataprovaider;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.dataprovaider.entity.OrdemServicoEntity;
import com.daniel.os.dataprovaider.gateway.OrdemServicoGateway;
import com.daniel.os.dataprovaider.mapper.OrdemServicoEntityMapper;
import com.daniel.os.dataprovaider.repository.OrdemServicoRepository;

@Component
public class OrdemServicoDataProvaider implements OrdemServicoGateway {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	


	@Override
	public OrdemServico cadastrarOrdemServico(OrdemServico ordemServico) {
		OrdemServicoEntity ordemServicoEntity = OrdemServicoEntityMapper.from(ordemServico);
		OrdemServicoEntity ordemServicoEntityNovo = ordemServicoRepository.save(ordemServicoEntity);
		ordemServicoEntity.setId(ordemServicoEntityNovo.getId());
		
		

		return OrdemServicoEntityMapper.to(ordemServicoEntityNovo);
	
	}

	@Override
	public OrdemServico buscarUsuarioPorId(Integer id) {
		Optional<OrdemServicoEntity> ordemServicoEntity = ordemServicoRepository.findById(id);
		return OrdemServicoEntityMapper.to(ordemServicoEntity.get());
	}
}
