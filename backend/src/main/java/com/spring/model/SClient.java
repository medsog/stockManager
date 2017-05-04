package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_client database table.
 * 
 */
@Entity
@Table(name="s_client")
@NamedQuery(name="SClient.findAll", query="SELECT s FROM SClient s")
public class SClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private Integer idClient;

	private String adresse;

	private String code;

	private String date_Annivairsaire;

	private String e_Mail;

	private String fax;

	private String identite;

	private String nom;

	private String portable;

	private String prenom;

	private float remise;

	private String site_Web;

	private String tel;

	//bi-directional many-to-one association to MEntetevente
	@OneToMany(mappedBy="SClient")
	private List<MEntetevente> MEnteteventes;

	//bi-directional many-to-one association to MReglement
	@OneToMany(mappedBy="SClient")
	private List<MReglement> MReglements;

	//bi-directional many-to-one association to PPay
	@ManyToOne
	@JoinColumn(name="Pays")
	private PPays PPay;

	//bi-directional many-to-one association to PVille
	@ManyToOne
	@JoinColumn(name="Ville")
	private Ville PVille;

	//bi-directional many-to-one association to SCategorie
	@ManyToOne
	@JoinColumn(name="categorie")
	private SCategorie SCategorie;

	public SClient() {
	}

	public Integer getIdClient() {
		return this.idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
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

	public String getDate_Annivairsaire() {
		return this.date_Annivairsaire;
	}

	public void setDate_Annivairsaire(String date_Annivairsaire) {
		this.date_Annivairsaire = date_Annivairsaire;
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

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPortable() {
		return this.portable;
	}

	public void setPortable(String portable) {
		this.portable = portable;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public float getRemise() {
		return this.remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
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

	public List<MEntetevente> getMEnteteventes() {
		return this.MEnteteventes;
	}

	public void setMEnteteventes(List<MEntetevente> MEnteteventes) {
		this.MEnteteventes = MEnteteventes;
	}

	public MEntetevente addMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().add(MEntetevente);
		MEntetevente.setSClient(this);

		return MEntetevente;
	}

	public MEntetevente removeMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().remove(MEntetevente);
		MEntetevente.setSClient(null);

		return MEntetevente;
	}

	public List<MReglement> getMReglements() {
		return this.MReglements;
	}

	public void setMReglements(List<MReglement> MReglements) {
		this.MReglements = MReglements;
	}

	public MReglement addMReglement(MReglement MReglement) {
		getMReglements().add(MReglement);
		MReglement.setSClient(this);

		return MReglement;
	}

	public MReglement removeMReglement(MReglement MReglement) {
		getMReglements().remove(MReglement);
		MReglement.setSClient(null);

		return MReglement;
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

	public SCategorie getSCategorie() {
		return this.SCategorie;
	}

	public void setSCategorie(SCategorie SCategorie) {
		this.SCategorie = SCategorie;
	}

}