package com.daniel.os.core.business;

import java.util.Optional;

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

	@Transactional
	public Tecnico findById(Integer id) {
		Optional<Tecnico> tecnicos = Optional.ofNullable(tecnicoGateway.findById(id));
		return tecnicos.orElse(null);
	}

	@Transactional
	public Tecnico findAll() {
		return tecnicoGateway.findAll();
	}

	@Transactional
	public Tecnico atualizarTecnico(Integer id, Tecnico tecnico) {
		tecnicoGateway.findById(id);
		tecnico.setId(id);
		tecnico = tecnicoGateway.cadastrarTecnico(tecnico);
		return tecnico;
	}

}
