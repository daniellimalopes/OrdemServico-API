package com.daniel.os.core.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.os.core.domain.Tecnico;
import com.daniel.os.dataprovaider.gateway.TecnicoGateway;

@Service
public class TecnicoBusiness {

	@Autowired
	private TecnicoGateway tecnicoGateway;

	@Transactional
	public Tecnico cadastrarTecnico(Tecnico tecnico) {
		tecnico.setId(null);
		tecnico = tecnicoGateway.cadastrarTecnico(tecnico);

		return tecnico;
	}

	



}
