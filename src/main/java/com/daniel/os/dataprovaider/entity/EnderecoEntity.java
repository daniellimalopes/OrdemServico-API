package com.daniel.os.dataprovaider.entity;

import java.util.Objects;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_endereco")
public class EnderecoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nm_logradouro")
	private String logradouro;
	@Column(name = "nr_numero")
	private Integer numero;
	@Column(name = "nr_cep")
	private String cep;
	@Column(name = "ds_complemento")
	private String complemento;
	@Column(name = "sg_estado")
	private String estado;
	@Column(name = "nm_cidade")
	private String cidade;
	@Column(name = "nm_bairro")
	private String bairro;
	@Column(name = "cliente_id")
	private Integer clienteId;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoEntity other = (EnderecoEntity) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
}
