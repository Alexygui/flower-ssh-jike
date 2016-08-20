package com.aaa.action;

import java.util.List;
import java.util.Map;

import com.aaa.model.Flower;
import com.aaa.service.ICatalogService;
import com.aaa.service.IFlowerService;
import com.aaa.util.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取鲜花相应数据的action类
 */
public class FlowerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ICatalogService catalogService;

	private IFlowerService flowerService;

	private int catalogid;
	private int currentPage;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCatalogid() {
		return catalogid;
	}

	public void setCatalogid(int catalogid) {
		this.catalogid = catalogid;
	}

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
		// System.out.println("action");
		List catalogs = catalogService.getAllCatalogs();
		// System.out.println("action2");
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

	/**
	 * 实现获取对应类别的鲜花的分页显示功能
	 */
	public String browseFlowerPaging() {
		int totalSize = flowerService.getTotalByCatalog(catalogid);
		Page page = new Page(currentPage, totalSize);
		List<Flower> flowers = flowerService.getFlowerByCatalogPaging(catalogid, currentPage, page.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("flowers", flowers);
		request.put("page", page);
		return SUCCESS;
	}
}
