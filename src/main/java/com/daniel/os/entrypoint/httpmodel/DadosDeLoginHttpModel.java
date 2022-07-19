package com.daniel.os.entrypoint.httpmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DadosDeLoginHttpModel {
	private Integer id;
	private String email;
	private String senha;
	private Integer tecnicoId;
}
