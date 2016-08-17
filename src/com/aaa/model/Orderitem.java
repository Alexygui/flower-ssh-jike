package com.aaa.model;

/**
 * Orderitem entity. @author MyEclipse Persistence Tools
 */

public class Orderitem implements java.io.Serializable {

	// Fields

	private Integer orderitemid;
	private Flower flower;
	private Orders orders;
	private Integer quantity;

	// Constructors

	/** default constructor */
	public Orderitem() {
	}

	/** full constructor */
	public Orderitem(Flower flower, Orders orders, Integer quantity) {
		this.flower = flower;
		this.orders = orders;
		this.quantity = quantity;
	}

	// Property accessors

	public Integer getOrderitemid() {
		return this.orderitemid;
	}

	public void setOrderitemid(Integer orderitemid) {
		this.orderitemid = orderitemid;
	}

	public Flower getFlower() {
		return this.flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}