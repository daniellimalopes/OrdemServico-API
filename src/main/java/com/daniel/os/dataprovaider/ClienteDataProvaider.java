package com.daniel.os.dataprovaider;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.os.core.domain.Cliente;
import com.daniel.os.dataprovaider.entity.ClienteEntity;
import com.daniel.os.dataprovaider.entity.EnderecoEntity;
import com.daniel.os.dataprovaider.gateway.ClienteGateway;
import com.daniel.os.dataprovaider.mapper.ClienteEntityMapper;
import com.daniel.os.dataprovaider.repository.ClienteRepository;
import com.daniel.os.dataprovaider.repository.EnderecoRepository;

@Component
public class ClienteDataProvaider implements ClienteGateway {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {

		ClienteEntity clienteEntity = ClienteEntityMapper.from(cliente);
		ClienteEntity clienteEntityNovo = clienteRepository.save(clienteEntity);
		clienteEntity.setId(clienteEntityNovo.getId());

		for (EnderecoEntity enderecoEntity : clienteEntity.getEnderecos()) {
			enderecoEntity.setClienteId(clienteEntityNovo.getId());
			enderecoRepository.save(enderecoEntity);

		}

		return ClienteEntityMapper.to(clienteEntityNovo);
	}

	@Override
	public Cliente buscarClientePorId(Integer id) {
		Optional<ClienteEntity> clienteEntity = clienteRepository.findById(id);
		return ClienteEntityMapper.to(clienteEntity.get());
	}

	

}
