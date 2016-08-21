package com.aaa.action;

import java.util.Map;

import com.aaa.model.Flower;
import com.aaa.model.Orderitem;
import com.aaa.service.IFlowerService;
import com.aaa.tool.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 实现商品加购物车的功能
 */
public class ShoppingAction extends ActionSupport{
	//由spring注入FlowerService对象，传入flowerid和quantity的值
	private IFlowerService flowerService;
	private int flowerid;
	private int quantity;
	public IFlowerService getFlowerService() {
		return flowerService;
	}
	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}
	public int getFlowerid() {
		return flowerid;
	}
	public void setFlowerid(int flowerid) {
		this.flowerid = flowerid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 将商品添加到购物车
	 */
	public String addToCart() {
		Flower flower = flowerService.getFlowerById(flowerid);
		Orderitem orderitem = new Orderitem();
		orderitem.setFlower(flower);
		orderitem.setQuantity(quantity);
		
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		if(cart == null) {
			cart = new Cart();
		}
			cart.addFlower(flowerid, orderitem);
//System.out.println(cart.getItems().size());
			return SUCCESS;
	}
}
