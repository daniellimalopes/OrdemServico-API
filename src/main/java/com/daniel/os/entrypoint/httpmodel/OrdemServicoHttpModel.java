package com.daniel.os.entrypoint.httpmodel;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

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
	@NotEmpty
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataAbertura;
	@NotEmpty
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFechamento;
	@NotEmpty
	private String observacao;
	private Integer statusId;
	private Integer prioridadeId;
	@NotEmpty
	private Integer tecnicoId;
	@NotEmpty
	private Integer clienteId;
	

}
