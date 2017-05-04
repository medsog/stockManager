package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_article_gamme database table.
 * 
 */
@Entity
@Table(name="s_article_gamme")
@NamedQuery(name="SArticleGamme.findAll", query="SELECT s FROM SArticleGamme s")
public class SArticleGamme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_article_gamme")
	private Integer idArticleGamme;

	private int cmup;

	private String image;

	@Column(name="prix_achat")
	private int prixAchat;

	@Column(name="prix_vente")
	private int prixVente;

	//bi-directional many-to-one association to MLignesvente
	@OneToMany(mappedBy="SArticleGamme")
	private List<MLignesvente> MLignesventes;

	//bi-directional many-to-one association to SArticle
	@ManyToOne
	@JoinColumn(name="article")
	private SArticle SArticle;

	//bi-directional many-to-one association to SGamme
	@ManyToOne
	@JoinColumn(name="gamme")
	private SGamme SGamme;

	public SArticleGamme() {
	}

	public Integer getIdArticleGamme() {
		return this.idArticleGamme;
	}

	public void setIdArticleGamme(Integer idArticleGamme) {
		this.idArticleGamme = idArticleGamme;
	}

	public int getCmup() {
		return this.cmup;
	}

	public void setCmup(int cmup) {
		this.cmup = cmup;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrixAchat() {
		return this.prixAchat;
	}

	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getPrixVente() {
		return this.prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public List<MLignesvente> getMLignesventes() {
		return this.MLignesventes;
	}

	public void setMLignesventes(List<MLignesvente> MLignesventes) {
		this.MLignesventes = MLignesventes;
	}

	public MLignesvente addMLignesvente(MLignesvente MLignesvente) {
		getMLignesventes().add(MLignesvente);
		MLignesvente.setSArticleGamme(this);

		return MLignesvente;
	}

	public MLignesvente removeMLignesvente(MLignesvente MLignesvente) {
		getMLignesventes().remove(MLignesvente);
		MLignesvente.setSArticleGamme(null);

		return MLignesvente;
	}

	public SArticle getSArticle() {
		return this.SArticle;
	}

	public void setSArticle(SArticle SArticle) {
		this.SArticle = SArticle;
	}

	public SGamme getSGamme() {
		return this.SGamme;
	}

	public void setSGamme(SGamme SGamme) {
		this.SGamme = SGamme;
	}

}