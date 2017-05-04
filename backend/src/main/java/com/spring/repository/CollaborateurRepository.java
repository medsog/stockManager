package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SCollaborateur;

@RepositoryRestResource(collectionResourceRel = "collaborateur", path = "collaborateur")
public interface CollaborateurRepository extends JpaRepository<SCollaborateur, Long> {
	
}