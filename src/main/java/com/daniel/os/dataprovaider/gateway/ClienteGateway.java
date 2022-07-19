package com.daniel.os.dataprovaider.gateway;

import com.daniel.os.core.domain.Cliente;

public interface ClienteGateway {

	Cliente createCliente(Cliente cliente);
	Cliente atualizarCliente(Integer id, Cliente cliente);
	Cliente findById(Integer id);
	Cliente findAll();

}
