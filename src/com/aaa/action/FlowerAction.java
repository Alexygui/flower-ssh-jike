package com.aaa.action;

import java.io.File;
import java.util.List;
import java.util.Map;

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
	 * 管理员保存修改图片时的图片和Flower对象的id号
	 */
	private String picture;

	/**
	 * 用于实现删除功能的flowerid
	 */
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
	 * 获取鲜花所有catalog分类的action
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
		// System.out.println(path);
		Flower flowerNewest = (Flower) flowerService.getNewFlowers().get(0);
		// 将当前的鲜花的id值设置为最新上架的鲜花的id值加1，也就是自增的效果
		int currentFlowerid = flowerNewest.getFlowerid() + 1;
		path = path + "/" + currentFlowerid + this.getUploadFileName();
		// System.out.println("uploadfilename="+getUpload().getName());//测试代码
		// 将图片上传到服务器的/pic目录下
		// 此处的判空没有用，仍然会出错，因为本地缓存中是有文件的，不是null，目前这是个小bug，不过不影响网页的使用，先不管了
		// if (this.getUpload() != null) {
		// new UploadPhoto().upload(this.getUpload(), path);
		// }
		// 这种方法的代码修改鲜花的属性的时候不会报错，不过却不能添加鲜花了，所以也不行
		// flower.setPicture(currentFlowerid + this.getUploadFileName());
		// if(flower.getPicture() == null) {
		// new UploadPhoto().upload(this.getUpload(), path);
		// }
		new UploadPhoto().upload(this.getUpload(), path);
		// 用于添加到数据库的Flower对象
		Flower flower2 = new Flower();
		Catalog catalog = flower.getCatalog();
		// System.out.println("flowername="+flower.getFlowername());//测试代码
		// System.out.println("catalogname=" + catalog.getCatalogname());//测试代码
		flower2.setCatalog(catalog);
		flower2.setFlowername(flower.getFlowername());
		// 此语句用于将修改花品属性jsp页面中的flowerid传到本方法中，添加花品中不需要此变量，为null
		// flower2.setFlowerid(flowerid);
		flower2.setPicture(currentFlowerid + this.getUploadFileName());
		flower2.setPrice(flower.getPrice());
		if (flowerService.addOrUpdateFlower(flower2)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 查询所有的鲜花的方法
	 */
	public String browseAllFlowerPaging() {
		List<Flower> flowers = flowerService.getAllFlowerPaging();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("flowers", flowers);
		return SUCCESS;
	}

	/**
	 * 管理员页面中修改花品功能，根据flowerid显示某一款鲜花的信息
	 */
	public String displayOneFlower() {
		Flower modifyFlower = flowerService.getFlowerById(flowerid);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("flower", modifyFlower);
		return SUCCESS;
	}

	/**
	 * addOrUpdateFlower有bug，用这个方法更新一个鲜花品类的属性
	 */
	public String updateOneFlower() {
		// 获取保存照片的绝对路径
		String path = ServletActionContext.getServletContext().getRealPath("/pic");
		List list = flowerService.getNewFlowers();
		Flower tempFlower = (Flower) list.get(0);
		int currentFlowerid = tempFlower.getFlowerid() + 1;
		flower.setPicture(currentFlowerid + this.getUploadFileName());

		Flower flowerData = new Flower();
		flowerData.setFlowerid(flower.getFlowerid());
		flowerData.setCatalog(flower.getCatalog());
		flowerData.setFlowername(flower.getFlowername());
		flowerData.setPrice(flower.getPrice());
		System.out.println("flower.getPicture=" + flower.getPicture());
		if (flower.getPicture() == null) {
			flowerData.setPicture(picture);
		} else {
			// 将照片重命名，防止重名覆盖
			path = path + "/" + currentFlowerid + this.getUploadFileName();
			System.out.println("path=" + path); // 测试代码
			// 将照片对象传输到服务器端的path路径
			new UploadPhoto().upload(this.getUpload(), path);
			flowerData.setPicture(currentFlowerid + this.getUploadFileName());
		}
		if (flowerService.addOrUpdateFlower(flowerData)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 删除某一款鲜花
	 */
	public String deleteOneFlower() {
		flowerService.deleteOneFlower(flowerid);
		return SUCCESS;
	}
}
