package com.daniel.os.dataprovaider;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.entity.TecnicoEntity;
import com.daniel.os.dataprovaider.gateway.TecnicoGateway;
import com.daniel.os.dataprovaider.mapper.TecnicoEntityMapper;
import com.daniel.os.dataprovaider.repository.TecnicoRepository;

@Component
public class TecnicoDataProvaider implements TecnicoGateway {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Override
	public Tecnico cadastrarTecnico(Tecnico tecnico) {
		TecnicoEntity tecnicoEntity = TecnicoEntityMapper.from(tecnico);
		TecnicoEntity tecnicoEntityNovo = tecnicoRepository.save(tecnicoEntity);
		tecnicoEntity.setId(tecnicoEntityNovo.getId());
		
		return TecnicoEntityMapper.to(tecnicoEntityNovo);
	}



}
