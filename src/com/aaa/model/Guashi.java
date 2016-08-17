package com.aaa.model;

/**
 * Guashi entity. @author MyEclipse Persistence Tools
 */

public class Guashi implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;

	// Constructors

	/** default constructor */
	public Guashi() {
	}

	/** full constructor */
	public Guashi(User user) {
		this.user = user;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}