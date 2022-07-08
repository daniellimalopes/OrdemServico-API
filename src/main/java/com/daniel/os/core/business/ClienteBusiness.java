package com.daniel.os.core.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.os.core.domain.Cliente;
import com.daniel.os.dataprovaider.gateway.ClienteGateway;

@Service
public class ClienteBusiness {

	@Autowired
	private ClienteGateway clienteGateway;

	@Transactional
	public Cliente cadastrarCliente(Cliente cliente) {
		cliente.setId(null);
		cliente = clienteGateway.createCliente(cliente);

		return cliente;
	}
	
	@Transactional
	public Cliente findById(Integer id) {
		Optional<Cliente> clientes = Optional.ofNullable(clienteGateway.findById(id));
		return clientes.orElse(null);
	}
	
	@Transactional
	public Cliente findAll() {
		return clienteGateway.findAll();
		
	}
	
	@Transactional
	public Cliente atualizarCliente(Integer id,Cliente cliente) {
			clienteGateway.findById(id);
			cliente.setId(id);
			cliente = clienteGateway.createCliente(cliente);
		return cliente;
	}
	
}
