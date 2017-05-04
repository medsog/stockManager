package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.PModePaiement;

@RepositoryRestResource(collectionResourceRel = "modePaiement", path = "modePaiement")
public interface ModePaiementRepository extends JpaRepository<PModePaiement, Long> {
	
}