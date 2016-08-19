package com.aaa.service.impl;

import java.util.List;

import com.aaa.dao.ICatalogDao;
import com.aaa.dao.impl.CatalogDao;
import com.aaa.service.ICatalogService;


/**
 * 获取鲜花种类的service层的类
 */
public class CatalogService implements ICatalogService{
	/**
	 * 由spring注入Dao层的类 
	 */
	private ICatalogDao catalogDao = new CatalogDao();
	
	public ICatalogDao getCatalogDao() {
		return catalogDao;
	}

	public void setCatalogDao(ICatalogDao catalogDao) {
		this.catalogDao = catalogDao;
	}

	/**
	 * service层获取鲜花种类的方法
	 */
	@Override
	public List getAllCatalogs() {
//	System.out.println("service");	

	List catalogs = catalogDao.getAllCatalogs();
//	System.out.println("service2");
		return catalogs;
	}

}
