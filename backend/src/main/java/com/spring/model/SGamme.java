package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_gamme database table.
 * 
 */
@Entity
@Table(name="s_gamme")
@NamedQuery(name="SGamme.findAll", query="SELECT s FROM SGamme s")
public class SGamme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_gamme")
	private Integer idGamme;

	private String couleur;

	private String taille;

	//bi-directional many-to-one association to SArticleGamme
	@OneToMany(mappedBy="SGamme")
	private List<SArticleGamme> SArticleGammes;

	public SGamme() {
	}

	public Integer getIdGamme() {
		return this.idGamme;
	}

	public void setIdGamme(Integer idGamme) {
		this.idGamme = idGamme;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getTaille() {
		return this.taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public List<SArticleGamme> getSArticleGammes() {
		return this.SArticleGammes;
	}

	public void setSArticleGammes(List<SArticleGamme> SArticleGammes) {
		this.SArticleGammes = SArticleGammes;
	}

	public SArticleGamme addSArticleGamme(SArticleGamme SArticleGamme) {
		getSArticleGammes().add(SArticleGamme);
		SArticleGamme.setSGamme(this);

		return SArticleGamme;
	}

	public SArticleGamme removeSArticleGamme(SArticleGamme SArticleGamme) {
		getSArticleGammes().remove(SArticleGamme);
		SArticleGamme.setSGamme(null);

		return SArticleGamme;
	}

}