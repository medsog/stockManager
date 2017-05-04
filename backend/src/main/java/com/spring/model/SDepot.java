package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_depot database table.
 * 
 */
@Entity
@Table(name="s_depot")
@NamedQuery(name="SDepot.findAll", query="SELECT s FROM SDepot s")
public class SDepot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_Depot;

	private String adresse;

	private String code_Depot;

	private String fax;

	private String portable;

	private String raison_Sociale;

	private String tel;

	//bi-directional many-to-one association to MEntetevente
	@OneToMany(mappedBy="SDepot")
	private List<MEntetevente> MEnteteventes;

	//bi-directional many-to-one association to PPay
	@ManyToOne
	@JoinColumn(name="Pays")
	private PPays PPay;

	//bi-directional many-to-one association to PVille
	@ManyToOne
	@JoinColumn(name="Ville")
	private Ville PVille;

	public SDepot() {
	}

	public Integer getId_Depot() {
		return this.id_Depot;
	}

	public void setId_Depot(Integer id_Depot) {
		this.id_Depot = id_Depot;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCode_Depot() {
		return this.code_Depot;
	}

	public void setCode_Depot(String code_Depot) {
		this.code_Depot = code_Depot;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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
		MEntetevente.setSDepot(this);

		return MEntetevente;
	}

	public MEntetevente removeMEntetevente(MEntetevente MEntetevente) {
		getMEnteteventes().remove(MEntetevente);
		MEntetevente.setSDepot(null);

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