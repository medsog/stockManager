package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SGamme;

@RepositoryRestResource(collectionResourceRel = "gamme", path = "gamme")
public interface GammeRepository extends JpaRepository<SGamme, Long> {
	
}