package com.daniel.os.dataprovaider.mapper;

import java.util.Optional;

import com.daniel.os.core.domain.Endereco;
import com.daniel.os.dataprovaider.entity.EnderecoEntity;

public class EnderecoEntityMapper {
	
	public static final Endereco to(EnderecoEntity enderecoEntity) {
		return Optional.ofNullable(enderecoEntity).map(entity -> Endereco.builder()
				.id(entity.getId())
				.logradouro(entity.getLogradouro())
				.numero(entity.getNumero())
				.cep(entity.getCep())
				.complemento(entity.getComplemento())
				.estado(entity.getEstado())
				.cidade(entity.getCidade())
				.bairro(entity.getBairro())
				.build())
				.orElse(new Endereco());
	}
	
	public static final EnderecoEntity from(Endereco endereco) {
		return Optional.ofNullable(endereco).map(domain -> EnderecoEntity.builder()
				.id(domain.getId())
				.logradouro(domain.getLogradouro())
				.numero(domain.getNumero())
				.cep(domain.getCep())
				.complemento(domain.getComplemento())
				.estado(domain.getEstado())
				.cidade(domain.getCidade())
				.bairro(domain.getBairro())
				.build())
				.orElse(new EnderecoEntity());
	}
	
	
}
