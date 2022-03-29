package com.daniel.os.core.domain;

import java.util.List;

import com.daniel.os.core.domain.enums.TipoCliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	private Integer id;
	private String nome;
	private String telefone;
	private String cpfcnpj;
	private String email;
	private TipoCliente tipoCliente;
	private List<Endereco> enderecos;
	private List<OrdemServico> servicos;
	
}
