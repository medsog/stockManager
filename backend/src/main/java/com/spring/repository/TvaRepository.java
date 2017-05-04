package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.PTva;

@RepositoryRestResource(collectionResourceRel = "tva", path = "tva")
public interface TvaRepository extends JpaRepository<PTva, Long> {
	
}