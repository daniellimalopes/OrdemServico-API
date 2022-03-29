package com.daniel.os.dataprovaider.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.daniel.os.core.domain.Cliente;
import com.daniel.os.core.domain.Endereco;
import com.daniel.os.core.domain.OrdemServico;
import com.daniel.os.core.domain.enums.TipoCliente;
import com.daniel.os.dataprovaider.entity.ClienteEntity;
import com.daniel.os.dataprovaider.entity.EnderecoEntity;
import com.daniel.os.dataprovaider.entity.OrdemServicoEntity;

public class ClienteEntityMapper {
	
	public static final Cliente to(ClienteEntity clienteEntity) {
		return Optional.ofNullable(clienteEntity).map(entity -> Cliente.builder()
				.id(entity.getId())
				.nome(entity.getNome())
				.cpfcnpj(entity.getCpfcnpj())
				.email(entity.getEmail())
				.telefone(entity.getTelefone())
				.enderecos(toEnderecos(entity.getEnderecos()))
				.servicos(toOrdemSevico(entity.getOrdemServicos()))
				.tipoCliente(TipoCliente.toenum(entity.getIdTipoCliente()))
				.build())
				.orElse(new Cliente());
		
	}
	private static List<OrdemServico> toOrdemSevico(List<OrdemServicoEntity> ordemServicosEntity) {
		List<OrdemServico> ordemServicos = new ArrayList<>();
		for(OrdemServicoEntity ordemServicoEntity : ordemServicosEntity) {
			ordemServicos.add(OrdemServicoEntityMapper.to(ordemServicoEntity));
		}
		return ordemServicos;
	}

	private static List<Endereco> toEnderecos(List<EnderecoEntity> enderecosEntity) {
		List<Endereco> enderecos = new ArrayList<>();
		for(EnderecoEntity enderecoEntity : enderecosEntity) {
			enderecos.add(EnderecoEntityMapper.to(enderecoEntity));
		}
		return enderecos;
	}
	
	public static ClienteEntity from(Cliente cliente) {
		return Optional.ofNullable(cliente).map(domain -> ClienteEntity.builder()
				.id(domain.getId())
				.nome(domain.getNome())
				.cpfcnpj(domain.getCpfcnpj())
				.email(domain.getEmail())
				.telefone(domain.getTelefone())
				.enderecos(fromEnderecos(domain.getEnderecos()))
				.ordemServicos(fromOrdemSevico(domain.getServicos()))
				.idTipoCliente(domain.getTipoCliente().getCod())
				.build())
				.orElse(new ClienteEntity());
	}


	


	private static List<OrdemServicoEntity> fromOrdemSevico(List<OrdemServico> ordemServicos) {
		List<OrdemServicoEntity> ordemServicosEntity = new ArrayList<>();
		for(OrdemServico ordemServico : ordemServicos) {
			ordemServicosEntity.add(OrdemServicoEntityMapper.from(ordemServico));
		}
		return ordemServicosEntity;
	}
	private static List<EnderecoEntity> fromEnderecos(List<Endereco> enderecos) {
		List<EnderecoEntity> enderecosEntity = new ArrayList<>();
		for(Endereco endereco : enderecos) {
			enderecosEntity.add(EnderecoEntityMapper.from(endereco));
		}
		return enderecosEntity;
	}
	

}
