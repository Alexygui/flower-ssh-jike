package com.aaa.tool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.aaa.model.Flower;
import com.aaa.model.Orderitem;

/**
 * 购物车的类
 */
public class Cart {
	//用于保存购物车内的鲜花id号和该id号对应的鲜花orderitem的Map
	//Integer是鲜花flowerid的变量类型，Orderitem类
	private Map<Integer, Orderitem> items;

	public Map getItems() {
		return items;
	}

	public void setItems(Map items) {
		this.items = items;
	}

	public Cart() {
		if(items == null) {
			items = new HashMap<Integer, Orderitem>();
		}
	}

	//在购物车内添加鲜花的品类和相应的数量，已经有的鲜花则添加数量
	public void addFlower(int flowerid, Orderitem orderitem) {
		if(items.containsKey(flowerid)) {
			//Oderitem无法直接操作，需要取出来放到变量中操作
			Orderitem _orderitem = items.get(flowerid);
			orderitem.setQuantity(_orderitem.getQuantity() + orderitem.getQuantity());
			items.put(flowerid, orderitem);
		} else {
			items.put(flowerid, orderitem);
		}
	}
	
	//在购物车内修改鲜花数量的方法
	public void updateCart(int flowerid, int quantity) {
		Orderitem orderitem = items.get(flowerid);
		orderitem.setQuantity(quantity);
		items.put(flowerid, orderitem);
	}
	
	//计算总价
	public int getTotalPrice() {
		int totalPrice = 0;
		for(Iterator it = items.values().iterator(); it.hasNext();) {
			Orderitem orderitem = (Orderitem) it.next();
			Flower flower = orderitem.getFlower();
			totalPrice += flower.getPrice() * orderitem.getQuantity();
		}
		return totalPrice;
	}
}
