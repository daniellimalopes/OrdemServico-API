package com.daniel.os.dataprovaider.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.daniel.os.core.domain.Cliente;
import com.daniel.os.core.domain.Endereco;
import com.daniel.os.core.domain.enums.TipoCliente;
import com.daniel.os.dataprovaider.entity.ClienteEntity;
import com.daniel.os.dataprovaider.entity.EnderecoEntity;

public class ClienteEntityMapper {

	public static final Cliente to(ClienteEntity clienteEntity) {
		return Optional.ofNullable(clienteEntity)
				.map(entity -> Cliente.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.cpfCnpj(entity.getCpfCnpj())
				.email(entity.getEmail())
				.telefone(entity.getTelefone())
				.enderecos(toEnderecos(entity.getEnderecos()))
				.tipoCliente(TipoCliente.toenum(entity.getIdTipoCliente())).build())
				.orElse(new Cliente());

	}

	private static List<Endereco> toEnderecos(List<EnderecoEntity> enderecosEntity) {
		List<Endereco> enderecos = new ArrayList<>();
		for (EnderecoEntity enderecoEntity : enderecosEntity) {
			enderecos.add(EnderecoEntityMapper.to(enderecoEntity));
		}
		return enderecos;
	}

	public static ClienteEntity from(Cliente cliente) {
		return Optional.ofNullable(cliente)
				.map(domain -> ClienteEntity.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cpfCnpj(domain.getCpfCnpj())
				.email(domain.getEmail())
				.telefone(domain.getTelefone())
				.enderecos(fromEnderecos(domain.getEnderecos()))
				.idTipoCliente(domain.getTipoCliente().getCod())
				.build())
				.orElse(new ClienteEntity());
	}

	private static List<EnderecoEntity> fromEnderecos(List<Endereco> enderecos) {
		List<EnderecoEntity> enderecosEntity = new ArrayList<>();
		for (Endereco endereco : enderecos) {
			enderecosEntity.add(EnderecoEntityMapper.from(endereco));
		}
		return enderecosEntity;
	}

}
