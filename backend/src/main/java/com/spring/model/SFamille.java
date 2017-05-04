package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_famille database table.
 * 
 */
@Entity
@Table(name="s_famille")
@NamedQuery(name="SFamille.findAll", query="SELECT s FROM SFamille s")
public class SFamille implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_famille")
	private Integer idFamille;

	private String code_Famille;

	private String image;

	private String intitule_Famille;

	//bi-directional many-to-one association to SArticle
	@OneToMany(mappedBy="SFamille")
	private List<SArticle> SArticles;

	public SFamille() {
	}

	public Integer getIdFamille() {
		return this.idFamille;
	}

	public void setIdFamille(Integer idFamille) {
		this.idFamille = idFamille;
	}

	public String getCode_Famille() {
		return this.code_Famille;
	}

	public void setCode_Famille(String code_Famille) {
		this.code_Famille = code_Famille;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntitule_Famille() {
		return this.intitule_Famille;
	}

	public void setIntitule_Famille(String intitule_Famille) {
		this.intitule_Famille = intitule_Famille;
	}

	public List<SArticle> getSArticles() {
		return this.SArticles;
	}

	public void setSArticles(List<SArticle> SArticles) {
		this.SArticles = SArticles;
	}

	public SArticle addSArticle(SArticle SArticle) {
		getSArticles().add(SArticle);
		SArticle.setSFamille(this);

		return SArticle;
	}

	public SArticle removeSArticle(SArticle SArticle) {
		getSArticles().remove(SArticle);
		SArticle.setSFamille(null);

		return SArticle;
	}

}