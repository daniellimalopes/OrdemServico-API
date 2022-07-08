package com.daniel.os.dataprovaider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.os.dataprovaider.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

	
	List<ClienteEntity> findByIdTipoCliente(Integer idTipoCliente);
	

}
