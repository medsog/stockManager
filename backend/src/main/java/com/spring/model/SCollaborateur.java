package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_collaborateur database table.
 * 
 */
@Entity
@Table(name="s_collaborateur")
@NamedQuery(name="SCollaborateur.findAll", query="SELECT s FROM SCollaborateur s")
public class SCollaborateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String adresse;

	private String code;

	private String e_Mail;

	private String fax;

	@Column(name="id_type")
	private int idType;

	private String nom_prenom;

	private String portable;

	private String tel;

	//bi-directional many-to-one association to MEntetevente
	@OneToMany(mappedBy="SCollaborateur")
	private List<MEntetevente> MEnteteventes;

	//bi-directional many-to-one association to PPay
	@ManyToOne
	@JoinColumn(name="Pays")
	private PPays PPay;

	//bi-directional many-to-one association to PVille
	@ManyToOne
	@JoinColumn(name="Ville")
	private Ville PVille;

	public SCollaborateur() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getIdType() {
		return this.idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getNom_prenom() {
		return this.nom_prenom;
	}

	public void setNom_prenom(String nom_prenom) {
		this.nom_prenom = nom_prenom;
	}

	public String getPortable() {
		return this.portable;
	}

	public void setPortable(String portable) {
		this.portable = portable;
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
		MEntetevente.setSCollaborateur(this);

		return MEntetevente;
	}

	public MEntetevente removeMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().remove(MEntetevente);
		MEntetevente.setSCollaborateur(null);

		return MEntetevente;
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