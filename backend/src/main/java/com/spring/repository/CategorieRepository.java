package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SCategorie;

@RepositoryRestResource(collectionResourceRel = "categorie", path = "categorie")
public interface CategorieRepository extends JpaRepository<SCategorie, Long> {
	
}