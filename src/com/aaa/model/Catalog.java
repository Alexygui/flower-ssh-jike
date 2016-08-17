package com.aaa.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Catalog entity. @author MyEclipse Persistence Tools
 */

public class Catalog implements java.io.Serializable {

	// Fields

	private Integer catalogid;
	private String catalogname;
	private Set flowers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Catalog() {
	}

	/** full constructor */
	public Catalog(String catalogname, Set flowers) {
		this.catalogname = catalogname;
		this.flowers = flowers;
	}

	// Property accessors

	public Integer getCatalogid() {
		return this.catalogid;
	}

	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public String getCatalogname() {
		return this.catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public Set getFlowers() {
		return this.flowers;
	}

	public void setFlowers(Set flowers) {
		this.flowers = flowers;
	}

}