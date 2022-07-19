package com.daniel.os.dataprovaider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.os.dataprovaider.entity.DadosDeLoginEntity;

@Repository
public interface DadosDeLoginRepository extends JpaRepository<DadosDeLoginEntity, Integer> {
}
