package com.daniel.os.core.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tecnico  {
	private Integer id;
	private String nome;
	private String telefone;
	private String cargo;
	private String cpf;
	private List<OrdemServico> ordemServicos;
}
