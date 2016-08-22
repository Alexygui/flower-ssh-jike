package com.aaa.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.aaa.model.Catalog;
import com.aaa.model.Flower;
import com.aaa.service.ICatalogService;
import com.aaa.service.IFlowerService;
import com.aaa.util.Page;
import com.aaa.util.UploadPhoto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 获取鲜花相应数据的action类
 */
public class FlowerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 相应的service对象，由spring注入
	 */
	private ICatalogService catalogService;
	private IFlowerService flowerService;

	/**
	 * 返回鲜花目录和相应的分页的当前页的变量
	 */
	private int catalogid;
	private int currentPage;
	
	/**
	 * 管理员添加和修改鲜花属性的时候返回的鲜花的id号和图片的File对象和名称
	 */
	private Flower flower;
	private File upload;
	private String uploadFileName;
	
	/**
	 * 保存修改图片时的图片和Flower对象的id号
	 */
	private String picture;
	private int flowerid;

	public Flower getFlower() {
		return flower;
	}

	public void setFlower(Flower flower) {
		this.flower = flower;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getFlowerid() {
		return flowerid;
	}

	public void setFlowerid(int flowerid) {
		this.flowerid = flowerid;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

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
	
	/**
	 * 管理员添加和修改鲜花属性的方法
	 */
	public String addOrUpdateFlower() {
		String path = ServletActionContext.getServletContext().getRealPath("/pic");
System.out.println(path);
		Flower flowerNewest = (Flower) flowerService.getNewFlowers().get(0);
		//将当前的鲜花的id值设置为最新上架的鲜花的id值加1，也就是自增的效果
		int currentFlowerid = flowerNewest.getFlowerid() + 1;
		path = path + "/" + currentFlowerid + this.getUploadFileName(); 
		new UploadPhoto().upload(upload, path);
		flower.setPicture(currentFlowerid + uploadFileName);
		//用于添加到数据库的Flower对象
		Flower flower2 = new Flower();
		Catalog catalog = flower.getCatalog();
System.out.println("flowername="+flower.getFlowername());
System.out.println("catalogname=" + catalog.getCatalogname());
		flower2.setCatalog(catalog);
		flower2.setFlowername(flower.getFlowername());
		if(flower.getPicture() == null) {
			flower2.setPicture(picture);
		} else {
			flower2.setPicture(flower.getPicture());
		}
		flower2.setPrice(flower.getPrice());
		if(flowerService.addOrUpdateFlower(flower2)){
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
