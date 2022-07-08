package com.daniel.os.entrypoint.httpmodel;

import java.util.List;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.daniel.os.dataprovaider.entity.EnderecoEntity;
import com.daniel.os.dataprovaider.entity.OrdemServicoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteHttpModel {
	private Integer id;
	
	private String nome;
	private String telefone;
	@CPF
	private String cpfCnpj;
	@Email
	private String email;
	private Integer tipoCliente;
	private List<EnderecoEntity> enderecos;
	private List<OrdemServicoEntity> ordemServicos;
	
}
