package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the p_tva database table.
 * 
 */
@Entity
@Table(name="p_tva")
@NamedQuery(name="PTva.findAll", query="SELECT p FROM PTva p")
public class PTva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_Tva;

	private String code_Tva;

	private String intitule_Tva;

	//bi-directional many-to-one association to SArticle
	@OneToMany(mappedBy="PTva")
	private List<SArticle> SArticles;

	public PTva() {
	}

	public Integer getId_Tva() {
		return this.id_Tva;
	}

	public void setId_Tva(Integer id_Tva) {
		this.id_Tva = id_Tva;
	}

	public String getCode_Tva() {
		return this.code_Tva;
	}

	public void setCode_Tva(String code_Tva) {
		this.code_Tva = code_Tva;
	}

	public String getIntitule_Tva() {
		return this.intitule_Tva;
	}

	public void setIntitule_Tva(String intitule_Tva) {
		this.intitule_Tva = intitule_Tva;
	}

	public List<SArticle> getSArticles() {
		return this.SArticles;
	}

	public void setSArticles(List<SArticle> SArticles) {
		this.SArticles = SArticles;
	}

	public SArticle addSArticle(SArticle SArticle) {
		getSArticles().add(SArticle);
		SArticle.setPTva(this);

		return SArticle;
	}

	public SArticle removeSArticle(SArticle SArticle) {
		getSArticles().remove(SArticle);
		SArticle.setPTva(null);

		return SArticle;
	}

}