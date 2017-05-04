package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the s_categorie database table.
 * 
 */
@Entity
@Table(name="s_categorie")
@NamedQuery(name="SCategorie.findAll", query="SELECT s FROM SCategorie s")
public class SCategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private float coefficient;

	@Column(name="intitule_categorie")
	private String intituleCategorie;

	//bi-directional many-to-one association to SClient
	@OneToMany(mappedBy="SCategorie")
	private List<SClient> SClients;

	public SCategorie() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getCoefficient() {
		return this.coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

	public String getIntituleCategorie() {
		return this.intituleCategorie;
	}

	public void setIntituleCategorie(String intituleCategorie) {
		this.intituleCategorie = intituleCategorie;
	}

	public List<SClient> getSClients() {
		return this.SClients;
	}

	public void setSClients(List<SClient> SClients) {
		this.SClients = SClients;
	}

	public SClient addSClient(SClient SClient) {
		getSClients().add(SClient);
		SClient.setSCategorie(this);

		return SClient;
	}

	public SClient removeSClient(SClient SClient) {
		getSClients().remove(SClient);
		SClient.setSCategorie(null);

		return SClient;
	}

}