package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_lignesventes database table.
 * 
 */
@Entity
@Table(name="m_lignesventes")
@NamedQuery(name="MLignesvente.findAll", query="SELECT m FROM MLignesvente m")
public class MLignesvente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private float cmup;

	@Column(name="n_serie")
	private String nSerie;

	@Column(name="pt_ht")
	private float ptHt;

	@Column(name="pt_ttc")
	private float ptTtc;

	@Column(name="pu_ht")
	private String puHt;

	private String qte;

	private float remise;

	private String tva;

	private int type;

	//bi-directional many-to-one association to MEntetevente
	@ManyToOne
	@JoinColumn(name="id_entete")
	private MEntetevente MEntetevente;

	//bi-directional many-to-one association to SArticleGamme
	@ManyToOne
	@JoinColumn(name="id_aticle_gamme")
	private SArticleGamme SArticleGamme;

	public MLignesvente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getCmup() {
		return this.cmup;
	}

	public void setCmup(float cmup) {
		this.cmup = cmup;
	}

	public String getNSerie() {
		return this.nSerie;
	}

	public void setNSerie(String nSerie) {
		this.nSerie = nSerie;
	}

	public float getPtHt() {
		return this.ptHt;
	}

	public void setPtHt(float ptHt) {
		this.ptHt = ptHt;
	}

	public float getPtTtc() {
		return this.ptTtc;
	}

	public void setPtTtc(float ptTtc) {
		this.ptTtc = ptTtc;
	}

	public String getPuHt() {
		return this.puHt;
	}

	public void setPuHt(String puHt) {
		this.puHt = puHt;
	}

	public String getQte() {
		return this.qte;
	}

	public void setQte(String qte) {
		this.qte = qte;
	}

	public float getRemise() {
		return this.remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
	}

	public String getTva() {
		return this.tva;
	}

	public void setTva(String tva) {
		this.tva = tva;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public MEntetevente getMEntetevente() {
		return this.MEntetevente;
	}

	public void setMEntetevente(MEntetevente MEntetevente) {
		this.MEntetevente = MEntetevente;
	}

	public SArticleGamme getSArticleGamme() {
		return this.SArticleGamme;
	}

	public void setSArticleGamme(SArticleGamme SArticleGamme) {
		this.SArticleGamme = SArticleGamme;
	}

}