package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.PPays;

@RepositoryRestResource(collectionResourceRel = "pays", path = "pays")
public interface PPaysRepository extends JpaRepository<PPays, Long> {
	
}