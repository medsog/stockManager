package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the m_enteteventes database table.
 * 
 */
@Entity
@Table(name="m_enteteventes")
@NamedQuery(name="MEntetevente.findAll", query="SELECT m FROM MEntetevente m")
public class MEntetevente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="date_livraison")
	private String dateLivraison;

	@Column(name="date_piece")
	private String datePiece;

	@Column(name="n_piece")
	private String nPiece;

	private String reference;

	private int type;

	//bi-directional many-to-one association to PModePaiement
	@ManyToOne
	@JoinColumn(name="mode_payement")
	private PModePaiement PModePaiement;

	//bi-directional many-to-one association to SAffaire
	@ManyToOne
	@JoinColumn(name="id_affaire")
	private SAffaire SAffaire;

	//bi-directional many-to-one association to SClient
	@ManyToOne
	@JoinColumn(name="id_client")
	private SClient SClient;

	//bi-directional many-to-one association to SCollaborateur
	@ManyToOne
	@JoinColumn(name="id_collaborateur")
	private SCollaborateur SCollaborateur;

	//bi-directional many-to-one association to SDepot
	@ManyToOne
	@JoinColumn(name="id_depot")
	private SDepot SDepot;

	//bi-directional many-to-one association to MLignesvente
	@OneToMany(mappedBy="MEntetevente")
	private List<MLignesvente> MLignesventes;

	public MEntetevente() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getDatePiece() {
		return this.datePiece;
	}

	public void setDatePiece(String datePiece) {
		this.datePiece = datePiece;
	}

	public String getNPiece() {
		return this.nPiece;
	}

	public void setNPiece(String nPiece) {
		this.nPiece = nPiece;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public PModePaiement getPModePaiement() {
		return this.PModePaiement;
	}

	public void setPModePaiement(PModePaiement PModePaiement) {
		this.PModePaiement = PModePaiement;
	}

	public SAffaire getSAffaire() {
		return this.SAffaire;
	}

	public void setSAffaire(SAffaire SAffaire) {
		this.SAffaire = SAffaire;
	}

	public SClient getSClient() {
		return this.SClient;
	}

	public void setSClient(SClient SClient) {
		this.SClient = SClient;
	}

	public SCollaborateur getSCollaborateur() {
		return this.SCollaborateur;
	}

	public void setSCollaborateur(SCollaborateur SCollaborateur) {
		this.SCollaborateur = SCollaborateur;
	}

	public SDepot getSDepot() {
		return this.SDepot;
	}

	public void setSDepot(SDepot SDepot) {
		this.SDepot = SDepot;
	}

	public List<MLignesvente> getMLignesventes() {
		return this.MLignesventes;
	}

	public void setMLignesventes(List<MLignesvente> MLignesventes) {
		this.MLignesventes = MLignesventes;
	}

	public MLignesvente addMLignesvente(MLignesvente MLignesvente) {
		getMLignesventes().add(MLignesvente);
		MLignesvente.setMEntetevente(this);

		return MLignesvente;
	}

	public MLignesvente removeMLignesvente(MLignesvente MLignesvente) {
		getMLignesventes().remove(MLignesvente);
		MLignesvente.setMEntetevente(null);

		return MLignesvente;
	}

}