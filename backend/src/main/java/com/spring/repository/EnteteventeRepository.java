package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.MEntetevente;

@RepositoryRestResource(collectionResourceRel = "enteteVente", path = "enteteVente")
public interface EnteteventeRepository extends JpaRepository<MEntetevente, Long> {
	
}