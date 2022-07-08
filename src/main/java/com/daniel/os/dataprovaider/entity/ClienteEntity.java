package com.daniel.os.dataprovaider.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_cliente")
public class ClienteEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nm_nome")
	private String nome;
	@Column(name = "nr_telefone")
	private String telefone;
	@Column(name = "nr_cpf_cnpj",unique = true)
	private String cpfCnpj;
	@Column(name = "nm_email")
	private String email;
	@Column(name = "nm_tipo_cliente_id")
	private Integer idTipoCliente;
	@Transient
	private List<EnderecoEntity> enderecos;
	@Transient
	private List<OrdemServicoEntity> ordemServicos;

}
