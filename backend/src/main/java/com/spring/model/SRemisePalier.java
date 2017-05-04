package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the s_remise_palier database table.
 * 
 */
@Entity
@Table(name="s_remise_palier")
@NamedQuery(name="SRemisePalier.findAll", query="SELECT s FROM SRemisePalier s")
public class SRemisePalier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private double debut;

	private double fin;

	private float remise;

	public SRemisePalier() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getDebut() {
		return this.debut;
	}

	public void setDebut(double debut) {
		this.debut = debut;
	}

	public double getFin() {
		return this.fin;
	}

	public void setFin(double fin) {
		this.fin = fin;
	}

	public float getRemise() {
		return this.remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
	}

}