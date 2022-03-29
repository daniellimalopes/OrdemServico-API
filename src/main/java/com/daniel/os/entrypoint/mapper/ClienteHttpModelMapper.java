package com.daniel.os.entrypoint.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.daniel.os.core.domain.Cliente;
import com.daniel.os.core.domain.Endereco;
import com.daniel.os.core.domain.enums.TipoCliente;
import com.daniel.os.dataprovaider.entity.EnderecoEntity;
import com.daniel.os.dataprovaider.mapper.EnderecoEntityMapper;
import com.daniel.os.entrypoint.httpmodel.ClienteHttpModel;

public class ClienteHttpModelMapper {
	public static final Cliente to(ClienteHttpModel clienteHttpModel) {
		return Optional.ofNullable(clienteHttpModel).map(httpModel -> Cliente.builder()
				.id(httpModel.getId())
				.nome(httpModel
				.getNome())
				.cpfcnpj(httpModel.getCpfcnpj())
				.email(httpModel.getEmail())
				.telefone(httpModel.getTelefone())
				.tipoCliente(TipoCliente.toenum(httpModel.getTipoCliente()))
				.enderecos(toEndereco(httpModel.getEnderecos()))
				.build())
				.orElse(new Cliente());
	}
	private static List<Endereco> toEndereco(List<EnderecoEntity> enderecosEntity) {
		List<Endereco> enderecos = new ArrayList<>();
		for (EnderecoEntity enderecoEntity : enderecosEntity) {
			enderecos.add(EnderecoEntityMapper.to(enderecoEntity));
		}
		return enderecos;
	}
	public static final ClienteHttpModel from(Cliente cliente) {
		return Optional.ofNullable(cliente).map(domain -> ClienteHttpModel.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cpfcnpj(domain.getCpfcnpj())
				.email(domain.getEmail())
				.telefone(domain.getTelefone())
				.tipoCliente(domain.getTipoCliente().getCod())
				.enderecos(fromEndereco(domain.getEnderecos()))
				.build())
				.orElse(new ClienteHttpModel());
	}
	private static List<EnderecoEntity> fromEndereco(List<Endereco> enderecos) {
		List<EnderecoEntity> enderecosEntity = new ArrayList<>();
		for (EnderecoEntity enderecoEntity : enderecosEntity) {
			enderecos.add(EnderecoEntityMapper.to(enderecoEntity));
		}
		return enderecosEntity;
	}
}
