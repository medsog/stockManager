package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SAffaire;

@RepositoryRestResource(collectionResourceRel = "affaire", path = "affaire")
public interface AffaireRepository extends JpaRepository<SAffaire, Long> {
	
}