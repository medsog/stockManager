package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.MReglfacture;

@RepositoryRestResource(collectionResourceRel = "reglementFacture", path = "reglementFacture")
public interface ReglfactureRepository extends JpaRepository<MReglfacture, Long> {
	
}