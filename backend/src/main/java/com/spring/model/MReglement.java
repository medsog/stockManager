package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the m_reglement database table.
 * 
 */
@Entity
@Table(name="m_reglement")
@NamedQuery(name="MReglement.findAll", query="SELECT m FROM MReglement m")
public class MReglement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String date;

	private float montant;

	private float solde;

	//bi-directional many-to-one association to PModePaiement
	@ManyToOne
	@JoinColumn(name="mode_paiement")
	private PModePaiement PModePaiement;

	//bi-directional many-to-one association to SClient
	@ManyToOne
	@JoinColumn(name="id_client")
	private SClient SClient;

	//bi-directional many-to-one association to MReglfacture
	@OneToMany(mappedBy="MReglement")
	private List<MReglfacture> MReglfactures;

	public MReglement() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getMontant() {
		return this.montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public float getSolde() {
		return this.solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public PModePaiement getPModePaiement() {
		return this.PModePaiement;
	}

	public void setPModePaiement(PModePaiement PModePaiement) {
		this.PModePaiement = PModePaiement;
	}

	public SClient getSClient() {
		return this.SClient;
	}

	public void setSClient(SClient SClient) {
		this.SClient = SClient;
	}

	public List<MReglfacture> getMReglfactures() {
		return this.MReglfactures;
	}

	public void setMReglfactures(List<MReglfacture> MReglfactures) {
		this.MReglfactures = MReglfactures;
	}

	public MReglfacture addMReglfacture(MReglfacture MReglfacture) {
		getMReglfactures().add(MReglfacture);
		MReglfacture.setMReglement(this);

		return MReglfacture;
	}

	public MReglfacture removeMReglfacture(MReglfacture MReglfacture) {
		getMReglfactures().remove(MReglfacture);
		MReglfacture.setMReglement(null);

		return MReglfacture;
	}

}