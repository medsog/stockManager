package com.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the p_ville database table.
 * 
 */
@Entity
@Table(name="p_ville")
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ville")
	private Integer idVille;

	private String intitule_Ville;

	private int pays;

	/*
	//bi-directional many-to-one association to SClient
	@OneToMany(mappedBy="PVille")
	private List<SClient> SClients;

	//bi-directional many-to-one association to SCollaborateur
	@OneToMany(mappedBy="PVille")
	private List<SCollaborateur> SCollaborateurs;

	//bi-directional many-to-one association to SDepot
	@OneToMany(mappedBy="PVille")
	private List<SDepot> SDepots;

	//bi-directional many-to-one association to SFournisseur
	@OneToMany(mappedBy="PVille")
	private List<SFournisseur> SFournisseurs;
	 */
	public Ville() {
	}

	public Integer getIdVille() {
		return this.idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public String getIntitule_Ville() {
		return this.intitule_Ville;
	}

	public void setIntitule_Ville(String intitule_Ville) {
		this.intitule_Ville = intitule_Ville;
	}

	public int getPays() {
		return this.pays;
	}

	public void setPays(int pays) {
		this.pays = pays;
	}

	/*
	public List<SClient> getSClients() {
		return this.SClients;
	}

	public void setSClients(List<SClient> SClients) {
		this.SClients = SClients;
	}

	public SClient addSClient(SClient SClient) {
		getSClients().add(SClient);
		SClient.setPVille(this);

		return SClient;
	}

	public SClient removeSClient(SClient SClient) {
		getSClients().remove(SClient);
		SClient.setPVille(null);

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
		SCollaborateur.setPVille(this);

		return SCollaborateur;
	}

	public SCollaborateur removeSCollaborateur(SCollaborateur SCollaborateur) {
		getSCollaborateurs().remove(SCollaborateur);
		SCollaborateur.setPVille(null);

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
		SDepot.setPVille(this);

		return SDepot;
	}

	public SDepot removeSDepot(SDepot SDepot) {
		getSDepots().remove(SDepot);
		SDepot.setPVille(null);

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
		SFournisseur.setPVille(this);

		return SFournisseur;
	}

	public SFournisseur removeSFournisseur(SFournisseur SFournisseur) {
		getSFournisseurs().remove(SFournisseur);
		SFournisseur.setPVille(null);

		return SFournisseur;
	}
 */
}