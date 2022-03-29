package com.daniel.os.entrypoint.httpmodel;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

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
	@NotEmpty
	private String nome;
	@NotEmpty
	private String telefone;
	@NotEmpty
	private String cargo;
	@NotEmpty
	@CPF
	private String cpf;
	private List<OrdemServicoEntity> ordemServicos;
}
