package com.daniel.os.entrypoint.httpmodel;

import java.util.List;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import com.daniel.os.dataprovaider.entity.DadosDeLoginEntity;
import com.daniel.os.dataprovaider.entity.OrdemServicoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoHttpModel {
	private Integer id;
	private String nome;
	private String telefone;
	private String cargo;
	@CPF
	private String cpf;
	private List<DadosDeLoginEntity> dadosDeLogins;
	private List<OrdemServicoEntity> ordemServicos;
}
