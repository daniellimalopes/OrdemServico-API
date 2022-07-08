package com.daniel.os.entrypoint.httpmodel;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServicoHttpModel{
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataAbertura;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFechamento;
	private String observacao;
	private Integer statusId;
	private Integer prioridadeId;
	private Integer tecnicoId;
	private Integer clienteId;
	

}
