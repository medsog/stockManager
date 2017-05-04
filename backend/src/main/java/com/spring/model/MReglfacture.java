package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the m_reglfacture database table.
 * 
 */
@Entity
@Table(name="m_reglfacture")
@NamedQuery(name="MReglfacture.findAll", query="SELECT m FROM MReglfacture m")
public class MReglfacture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="date_imputation")
	private String dateImputation;

	private float montant;

	@Column(name="num_facture")
	private String numFacture;

	//bi-directional many-to-one association to MReglement
	@ManyToOne
	@JoinColumn(name="id_reglement")
	private MReglement MReglement;

	public MReglfacture() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateImputation() {
		return this.dateImputation;
	}

	public void setDateImputation(String dateImputation) {
		this.dateImputation = dateImputation;
	}

	public float getMontant() {
		return this.montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getNumFacture() {
		return this.numFacture;
	}

	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}

	public MReglement getMReglement() {
		return this.MReglement;
	}

	public void setMReglement(MReglement MReglement) {
		this.MReglement = MReglement;
	}

}