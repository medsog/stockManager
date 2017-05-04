package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.MReglement;

@RepositoryRestResource(collectionResourceRel = "reglement", path = "reglement")
public interface ReglementRepository extends JpaRepository<MReglement, Long> {
	
}