package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SFournisseur;

@RepositoryRestResource(collectionResourceRel = "fournisseur", path = "fournisseur")
public interface FournisseurRepository extends JpaRepository<SFournisseur, Long> {
	
}