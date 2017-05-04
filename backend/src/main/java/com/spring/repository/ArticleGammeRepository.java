package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.model.SArticleGamme;

@RepositoryRestResource(collectionResourceRel = "articleGammes", path = "articleGammes")
public interface ArticleGammeRepository extends JpaRepository<SArticleGamme, Long> {
	
}