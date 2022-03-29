package com.daniel.os.dataprovaider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.os.dataprovaider.entity.TecnicoEntity;

@Repository
public interface TecnicoRepository extends JpaRepository<TecnicoEntity, Integer> {

}
