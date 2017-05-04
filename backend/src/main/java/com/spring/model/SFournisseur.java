package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the s_fournisseur database table.
 * 
 */
@Entity
@Table(name="s_fournisseur")
@NamedQuery(name="SFournisseur.findAll", query="SELECT s FROM SFournisseur s")
public class SFournisseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fournisseur")
	private Integer idFournisseur;

	private String adresse;

	private String code;

	private String e_Mail;

	private String fax;

	private String identite;

	private String portable;

	private String raison_Sociale;

	private String site_Web;

	private String tel;

	//bi-directional many-to-one association to PPay
	@ManyToOne
	@JoinColumn(name="Pays")
	private PPays PPay;

	//bi-directional many-to-one association to PVille
	@ManyToOne
	@JoinColumn(name="Ville")
	private Ville PVille;

	public SFournisseur() {
	}

	public Integer getIdFournisseur() {
		return this.idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getE_Mail() {
		return this.e_Mail;
	}

	public void setE_Mail(String e_Mail) {
		this.e_Mail = e_Mail;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIdentite() {
		return this.identite;
	}

	public void setIdentite(String identite) {
		this.identite = identite;
	}

	public String getPortable() {
		return this.portable;
	}

	public void setPortable(String portable) {
		this.portable = portable;
	}

	public String getRaison_Sociale() {
		return this.raison_Sociale;
	}

	public void setRaison_Sociale(String raison_Sociale) {
		this.raison_Sociale = raison_Sociale;
	}

	public String getSite_Web() {
		return this.site_Web;
	}

	public void setSite_Web(String site_Web) {
		this.site_Web = site_Web;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public PPays getPPay() {
		return this.PPay;
	}

	public void setPPay(PPays PPay) {
		this.PPay = PPay;
	}

	public Ville getPVille() {
		return this.PVille;
	}

	public void setPVille(Ville PVille) {
		this.PVille = PVille;
	}

}