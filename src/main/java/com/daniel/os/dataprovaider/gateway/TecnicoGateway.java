package com.daniel.os.dataprovaider.gateway;

import com.daniel.os.core.domain.Tecnico;

public interface TecnicoGateway {

	Tecnico cadastrarTecnico(Tecnico tecnico);
	Tecnico atualizarTecnico(Integer id, Tecnico tecnico);
	Tecnico findById(Integer id);
	Tecnico findAll();

	

}