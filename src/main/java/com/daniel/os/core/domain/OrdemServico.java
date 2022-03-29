package com.daniel.os.core.domain;

import java.util.Date;

import com.daniel.os.core.domain.enums.Prioridade;
import com.daniel.os.core.domain.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServico {

	private Integer id;
	private Date dataAbertura;
	private Date dataFechamento;
	private String observacao;
	private Status status;
	private Prioridade prioridade;
	private Integer tecnicoId;
	private Integer clienteId;
	
	
	

}
