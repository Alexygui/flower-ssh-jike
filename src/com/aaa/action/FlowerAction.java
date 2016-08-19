package com.aaa.action;

import java.util.List;
import java.util.Map;

import com.aaa.model.Flower;
import com.aaa.service.ICatalogService;
import com.aaa.service.IFlowerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取鲜花相应数据的action类
 */
public class FlowerAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private ICatalogService catalogService;

	private IFlowerService flowerService;
	
	public IFlowerService getFlowerService() {
		return flowerService;
	}

	public void setFlowerService(IFlowerService flowerService) {
		this.flowerService = flowerService;
	}

	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}
	
	/**
	 * 获取鲜花分类的action
	 */
	public String browseCatalog() {
//		System.out.println("action");
		List catalogs = catalogService.getAllCatalogs();
//		System.out.println("action2");
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("catalogs", catalogs);
		return SUCCESS;
	}
	
	/**
	 * 获取最新上架的四款鲜花
	 */
	public String browseNewFlower() {
		List<Flower> newFlowers = flowerService.getNewFlowers();
		Map requestMap = (Map) ActionContext.getContext().get("request");
		requestMap.put("newFlowers", newFlowers);
		return SUCCESS;
	}
}
