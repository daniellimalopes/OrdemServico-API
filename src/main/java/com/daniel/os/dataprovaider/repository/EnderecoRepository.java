package com.daniel.os.dataprovaider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.os.dataprovaider.entity.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

	List<EnderecoEntity> findByClienteId(Integer clienteId);

}
