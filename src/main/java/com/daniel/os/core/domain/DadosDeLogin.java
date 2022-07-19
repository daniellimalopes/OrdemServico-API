package com.daniel.os.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosDeLogin {
	
	private Integer id;
	private String Email;
	private String senha;
	private Integer tecnicoId;
	
}
