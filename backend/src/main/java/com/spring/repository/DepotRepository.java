package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SDepot;

@RepositoryRestResource(collectionResourceRel = "depot", path = "depot")
public interface DepotRepository extends JpaRepository<SDepot, Long> {
	
}