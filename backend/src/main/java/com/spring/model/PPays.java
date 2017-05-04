package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the p_pays database table.
 * 
 */
@Entity
@Table(name="p_pays")
@NamedQuery(name="PPay.findAll", query="SELECT p FROM PPays p")
public class PPays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pays")
	private Integer idPays;

	private String intitule_Pays;

	//bi-directional many-to-one association to SClient
	@OneToMany(mappedBy="PPay")
	private List<SClient> SClients;

	//bi-directional many-to-one association to SCollaborateur
	@OneToMany(mappedBy="PPay")
	private List<SCollaborateur> SCollaborateurs;

	//bi-directional many-to-one association to SDepot
	@OneToMany(mappedBy="PPay")
	private List<SDepot> SDepots;

	//bi-directional many-to-one association to SFournisseur
	@OneToMany(mappedBy="PPay")
	private List<SFournisseur> SFournisseurs;

	public PPays() {
	}

	public Integer getIdPays() {
		return this.idPays;
	}

	public void setIdPays(Integer idPays) {
		this.idPays = idPays;
	}

	public String getIntitule_Pays() {
		return this.intitule_Pays;
	}

	public void setIntitule_Pays(String intitule_Pays) {
		this.intitule_Pays = intitule_Pays;
	}

	public List<SClient> getSClients() {
		return this.SClients;
	}

	public void setSClients(List<SClient> SClients) {
		this.SClients = SClients;
	}

	public SClient addSClient(SClient SClient) {
		getSClients().add(SClient);
		SClient.setPPay(this);

		return SClient;
	}

	public SClient removeSClient(SClient SClient) {
		getSClients().remove(SClient);
		SClient.setPPay(null);

		return SClient;
	}

	public List<SCollaborateur> getSCollaborateurs() {
		return this.SCollaborateurs;
	}

	public void setSCollaborateurs(List<SCollaborateur> SCollaborateurs) {
		this.SCollaborateurs = SCollaborateurs;
	}

	public SCollaborateur addSCollaborateur(SCollaborateur SCollaborateur) {
		getSCollaborateurs().add(SCollaborateur);
		SCollaborateur.setPPay(this);

		return SCollaborateur;
	}

	public SCollaborateur removeSCollaborateur(SCollaborateur SCollaborateur) {
		getSCollaborateurs().remove(SCollaborateur);
		SCollaborateur.setPPay(null);

		return SCollaborateur;
	}

	public List<SDepot> getSDepots() {
		return this.SDepots;
	}

	public void setSDepots(List<SDepot> SDepots) {
		this.SDepots = SDepots;
	}

	public SDepot addSDepot(SDepot SDepot) {
		getSDepots().add(SDepot);
		SDepot.setPPay(this);

		return SDepot;
	}

	public SDepot removeSDepot(SDepot SDepot) {
		getSDepots().remove(SDepot);
		SDepot.setPPay(null);

		return SDepot;
	}

	public List<SFournisseur> getSFournisseurs() {
		return this.SFournisseurs;
	}

	public void setSFournisseurs(List<SFournisseur> SFournisseurs) {
		this.SFournisseurs = SFournisseurs;
	}

	public SFournisseur addSFournisseur(SFournisseur SFournisseur) {
		getSFournisseurs().add(SFournisseur);
		SFournisseur.setPPay(this);

		return SFournisseur;
	}

	public SFournisseur removeSFournisseur(SFournisseur SFournisseur) {
		getSFournisseurs().remove(SFournisseur);
		SFournisseur.setPPay(null);

		return SFournisseur;
	}

}