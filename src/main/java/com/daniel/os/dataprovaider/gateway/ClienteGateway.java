package com.daniel.os.dataprovaider.gateway;

import com.daniel.os.core.domain.Cliente;

public interface ClienteGateway {

	Cliente cadastrarCliente(Cliente cliente);
	
	Cliente buscarClientePorId(Integer id);
	
	
	
	


}
