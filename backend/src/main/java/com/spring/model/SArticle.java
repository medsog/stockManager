package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_article database table.
 * 
 */
@Entity
@Table(name="s_article")
@NamedQuery(name="SArticle.findAll", query="SELECT s FROM SArticle s")
public class SArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_article")
	private Integer idArticle;

	private float cmup;

	private String code_Article;

	private String code_Barre;

	private String description;

	private String file;

	private String intitule_Article;

	private String prix_Achat;

	private String prix_Vente;

	private float qte;

	private float remise;

	private int unite;

	//bi-directional many-to-one association to PTva
	@ManyToOne
	@JoinColumn(name="Tva")
	private PTva PTva;

	//bi-directional many-to-one association to SFamille
	@ManyToOne
	@JoinColumn(name="Famille")
	private SFamille SFamille;

	//bi-directional many-to-one association to SArticleGamme
	@OneToMany(mappedBy="SArticle")
	private List<SArticleGamme> SArticleGammes;

	public SArticle() {
	}

	public Integer getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public float getCmup() {
		return this.cmup;
	}

	public void setCmup(float cmup) {
		this.cmup = cmup;
	}

	public String getCode_Article() {
		return this.code_Article;
	}

	public void setCode_Article(String code_Article) {
		this.code_Article = code_Article;
	}

	public String getCode_Barre() {
		return this.code_Barre;
	}

	public void setCode_Barre(String code_Barre) {
		this.code_Barre = code_Barre;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getIntitule_Article() {
		return this.intitule_Article;
	}

	public void setIntitule_Article(String intitule_Article) {
		this.intitule_Article = intitule_Article;
	}

	public String getPrix_Achat() {
		return this.prix_Achat;
	}

	public void setPrix_Achat(String prix_Achat) {
		this.prix_Achat = prix_Achat;
	}

	public String getPrix_Vente() {
		return this.prix_Vente;
	}

	public void setPrix_Vente(String prix_Vente) {
		this.prix_Vente = prix_Vente;
	}

	public float getQte() {
		return this.qte;
	}

	public void setQte(float qte) {
		this.qte = qte;
	}

	public float getRemise() {
		return this.remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
	}

	public int getUnite() {
		return this.unite;
	}

	public void setUnite(int unite) {
		this.unite = unite;
	}

	public PTva getPTva() {
		return this.PTva;
	}

	public void setPTva(PTva PTva) {
		this.PTva = PTva;
	}

	public SFamille getSFamille() {
		return this.SFamille;
	}

	public void setSFamille(SFamille SFamille) {
		this.SFamille = SFamille;
	}

	public List<SArticleGamme> getSArticleGammes() {
		return this.SArticleGammes;
	}

	public void setSArticleGammes(List<SArticleGamme> SArticleGammes) {
		this.SArticleGammes = SArticleGammes;
	}

	public SArticleGamme addSArticleGamme(SArticleGamme SArticleGamme) {
		getSArticleGammes().add(SArticleGamme);
		SArticleGamme.setSArticle(this);

		return SArticleGamme;
	}

	public SArticleGamme removeSArticleGamme(SArticleGamme SArticleGamme) {
		getSArticleGammes().remove(SArticleGamme);
		SArticleGamme.setSArticle(null);

		return SArticleGamme;
	}

}