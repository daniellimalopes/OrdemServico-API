package com.daniel.os.entrypoint.mapper;

import java.util.Optional;

import com.daniel.os.core.domain.Endereco;
import com.daniel.os.entrypoint.httpmodel.EnderecoHttpModel;

public class EnderecoHttpModelMapper {
	public static final Endereco to(EnderecoHttpModel enderecoHttpModel) {
		return Optional.ofNullable(enderecoHttpModel).map(httpModel -> Endereco.builder()
				.id(httpModel.getId())
				.bairro(httpModel.getBairro())
				.cep(httpModel.getCep())
				.cidade(httpModel.getCidade())
				.complemento(httpModel.getComplemento())
				.numero(httpModel.getNumero())
				.estado(httpModel.getEstado())
				.logradouro(httpModel.getLogradouro())
				.build())
				.orElse(new Endereco());
	}
	public static final EnderecoHttpModel from(Endereco endereco) {
		return Optional.ofNullable(endereco).map(domain -> EnderecoHttpModel.builder()
				.id(domain.getId())
				.bairro(domain.getBairro())
				.cep(domain.getCep())
				.cidade(domain.getCidade())
				.complemento(domain.getComplemento())
				.numero(domain.getNumero())
				.estado(domain.getEstado())
				.logradouro(domain.getLogradouro())
				.build())
				.orElse(new EnderecoHttpModel());
	}
}
