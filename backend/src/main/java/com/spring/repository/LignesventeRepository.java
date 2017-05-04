package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.MLignesvente;

@RepositoryRestResource(collectionResourceRel = "lignesVente", path = "lignesVente")
public interface LignesventeRepository extends JpaRepository<MLignesvente, Long> {
	
}