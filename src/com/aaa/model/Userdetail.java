package com.aaa.model;

import java.util.Date;

/**
 * Userdetail entity. @author MyEclipse Persistence Tools
 */

public class Userdetail implements java.io.Serializable {

	// Fields

	private Integer userid;
	private User user;
	private Boolean xb;
	private String truename;
	private Date csrq;
	private String phone;
	private String email;
	private String address;

	// Constructors

	/** default constructor */
	public Userdetail() {
	}

	/** minimal constructor */
	public Userdetail(User user) {
		this.user = user;
	}

	/** full constructor */
	public Userdetail(User user, Boolean xb, String truename, Date csrq, String phone, String email, String address) {
		this.user = user;
		this.xb = xb;
		this.truename = truename;
		this.csrq = csrq;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getXb() {
		return this.xb;
	}

	public void setXb(Boolean xb) {
		this.xb = xb;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}