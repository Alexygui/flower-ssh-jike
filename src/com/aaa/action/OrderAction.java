package com.aaa.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.aaa.model.Orderitem;
import com.aaa.model.Orders;
import com.aaa.model.User;
import com.aaa.service.IOrderService;
import com.aaa.tool.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 处理订单信息的action类
 */
public class OrderAction extends ActionSupport{
	private IOrderService orderService;
	private int flowerid;
	private int quantity;
	
	
	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
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
	 * 检查用户是否已经登录，并且把订单保存到数据库
	 */
	public String checkOut() {
		Map session = ActionContext.getContext().getSession();
		User user = (User) session.get("user");
		if(user == null) {
			return ERROR;
		}
		Cart cart = (Cart)session.get("cart");
		Orders orders = new Orders();
		orders.setUser(user);
		orders.setOrderdate(new Timestamp(new Date().getTime()));
		for(Iterator it = cart.getItems().values().iterator(); it.hasNext();) {
			//获取orderitem对象
			Orderitem orderitem = (Orderitem) it.next();
			//将orderitem对象添加到对应的Order对象中
			orders.getOrderitems().add(orderitem);
			//将Order对象添加到Orderitem对象中
			orderitem.setOrders(orders);
		}
		orderService.saveOrders(orders);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("order", orders);
		session.remove("cart");
		return SUCCESS;
	}
}
