package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SFamille;

@RepositoryRestResource(collectionResourceRel = "famille", path = "famille")
public interface FamilleRepository extends JpaRepository<SFamille, Long> {
	
}