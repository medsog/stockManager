package com.spring.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the s_type_collab database table.
 * 
 */
@Entity
@Table(name="s_type_collab")
@NamedQuery(name="STypeCollab.findAll", query="SELECT s FROM STypeCollab s")
public class STypeCollab implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="intitule_type")
	private String intituleType;

	public STypeCollab() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntituleType() {
		return this.intituleType;
	}

	public void setIntituleType(String intituleType) {
		this.intituleType = intituleType;
	}

}