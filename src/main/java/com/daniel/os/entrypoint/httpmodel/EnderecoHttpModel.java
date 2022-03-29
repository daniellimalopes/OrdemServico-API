package com.daniel.os.entrypoint.httpmodel;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoHttpModel {
	private Integer id;
	@NotEmpty
	private String logradouro;
	@NotEmpty
	private Integer numero;
	@NotEmpty
	private String cep;
	@NotEmpty
	private String complemento;
	@NotEmpty
	private String estado;
	@NotEmpty
	private String cidade;
	@NotEmpty
	private String bairro;
}
