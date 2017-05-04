package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the p_mode_paiement database table.
 * 
 */
@Entity
@Table(name="p_mode_paiement")
@NamedQuery(name="PModePaiement.findAll", query="SELECT p FROM PModePaiement p")
public class PModePaiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mode")
	private Integer idMode;

	@Column(name="intitule_mode")
	private String intituleMode;

	//bi-directional many-to-one association to MEntetevente
	@OneToMany(mappedBy="PModePaiement")
	private List<MEntetevente> MEnteteventes;

	//bi-directional many-to-one association to MReglement
	@OneToMany(mappedBy="PModePaiement")
	private List<MReglement> MReglements;

	public PModePaiement() {
	}

	public Integer getIdMode() {
		return this.idMode;
	}

	public void setIdMode(Integer idMode) {
		this.idMode = idMode;
	}

	public String getIntituleMode() {
		return this.intituleMode;
	}

	public void setIntituleMode(String intituleMode) {
		this.intituleMode = intituleMode;
	}

	public List<MEntetevente> getMEnteteventes() {
		return this.MEnteteventes;
	}

	public void setMEnteteventes(List<MEntetevente> MEnteteventes) {
		this.MEnteteventes = MEnteteventes;
	}

	public MEntetevente addMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().add(MEntetevente);
		MEntetevente.setPModePaiement(this);

		return MEntetevente;
	}

	public MEntetevente removeMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().remove(MEntetevente);
		MEntetevente.setPModePaiement(null);

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
		MReglement.setPModePaiement(this);

		return MReglement;
	}

	public MReglement removeMReglement(MReglement MReglement) {
		getMReglements().remove(MReglement);
		MReglement.setPModePaiement(null);

		return MReglement;
	}

}