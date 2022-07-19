package com.daniel.os.dataprovaider.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_login")
public class DadosDeLoginEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nm_email")
	private String email;
	@Column(name = "nm_senha")
	private String senha;
	@Column(name = "tecnico_id")
	private Integer tecnicoId;
}
