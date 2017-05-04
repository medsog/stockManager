package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SArticle;

@RepositoryRestResource(collectionResourceRel = "article", path = "article")
public interface ArticleRepository extends JpaRepository<SArticle, Long> {
	
}