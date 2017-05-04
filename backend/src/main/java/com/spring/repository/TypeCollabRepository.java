package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.STypeCollab;

@RepositoryRestResource(collectionResourceRel = "typeCollaborateur", path = "typeCollaborateur")
public interface TypeCollabRepository extends JpaRepository<STypeCollab, Long> {
	
}