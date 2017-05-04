package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SClient;

@RepositoryRestResource(collectionResourceRel = "client", path = "client")
public interface ClientRepository extends JpaRepository<SClient, Long> {
	
}