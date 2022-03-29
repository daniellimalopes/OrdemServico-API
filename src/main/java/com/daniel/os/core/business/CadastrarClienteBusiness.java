package com.daniel.os.core.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.os.core.domain.Cliente;
import com.daniel.os.dataprovaider.gateway.ClienteGateway;

@Service
public class CadastrarClienteBusiness {

	@Autowired
	private ClienteGateway clienteGateway;
	
	
	@Transactional
	public Cliente cadastrarCliente( Cliente cliente) {	
		cliente.setId(null);
		cliente = clienteGateway.cadastrarCliente(cliente);
		
		return cliente;
	}
	
	


}
