package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_affaire database table.
 * 
 */
@Entity
@Table(name="s_affaire")
@NamedQuery(name="SAffaire.findAll", query="SELECT s FROM SAffaire s")
public class SAffaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_affaire")
	private Integer idAffaire;

	@Column(name="intitule_affaire")
	private String intituleAffaire;

	//bi-directional many-to-one association to MEntetevente
	@OneToMany(mappedBy="SAffaire")
	private List<MEntetevente> MEnteteventes;

	public SAffaire() {
	}

	public Integer getIdAffaire() {
		return this.idAffaire;
	}

	public void setIdAffaire(Integer idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getIntituleAffaire() {
		return this.intituleAffaire;
	}

	public void setIntituleAffaire(String intituleAffaire) {
		this.intituleAffaire = intituleAffaire;
	}

	public List<MEntetevente> getMEnteteventes() {
		return this.MEnteteventes;
	}

	public void setMEnteteventes(List<MEntetevente> MEnteteventes) {
		this.MEnteteventes = MEnteteventes;
	}

	public MEntetevente addMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().add(MEntetevente);
		MEntetevente.setSAffaire(this);

		return MEntetevente;
	}

	public MEntetevente removeMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().remove(MEntetevente);
		MEntetevente.setSAffaire(null);

		return MEntetevente;
	}

}