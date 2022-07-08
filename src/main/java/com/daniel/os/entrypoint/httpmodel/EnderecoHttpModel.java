package com.daniel.os.entrypoint.httpmodel;

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
	private String logradouro;
	private Integer numero;
	private String cep;
	private String complemento;
	private String estado;
	private String cidade;
	private String bairro;
}
