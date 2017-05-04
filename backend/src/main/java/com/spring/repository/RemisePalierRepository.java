package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SRemisePalier;

@RepositoryRestResource(collectionResourceRel = "remisePalier", path = "remisePalier")
public interface RemisePalierRepository extends JpaRepository<SRemisePalier, Long> {
	
}