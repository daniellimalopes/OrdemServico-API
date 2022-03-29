package com.daniel.os.entrypoint.httpmodel;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty
	private String nome;
	@NotEmpty
	private String telefone;
	@NotEmpty
	private String cpfcnpj;
	@NotEmpty
	@Email
	private String email;
	private Integer tipoCliente;
	private List<EnderecoEntity> enderecos;
	private List<OrdemServicoEntity> ordemServicos;
	
}
