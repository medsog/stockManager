package com.spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.Ville;

@RepositoryRestResource(collectionResourceRel = "ville", path = "ville")
public interface VilleRepository extends PagingAndSortingRepository<Ville, Long> {
	
}