package com.daniel.os.dataprovaider.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_ordem_servico")
public class OrdemServicoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "dt_data_abertura")
	private Date dataAbertura;
	@Column(name = "dt_data_fechamento")
	private Date dataFechamento;
	@Column(name = "ds_observacao")
	private String observacao;
	@Column(name = "status_id")
	private Integer statusId;
	@Column(name = "prioridade_id")
	private Integer prioridadeId;
	@Column(name = "cliente_id")
	private Integer clienteId;
	@Column(name = "tecnico_id")
	private Integer tecnicoId;

}
