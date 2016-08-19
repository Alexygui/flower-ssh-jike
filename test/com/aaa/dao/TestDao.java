package com.aaa.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaa.dao.impl.CatalogDao;
import com.aaa.dao.impl.FlowerDao;
import com.aaa.model.Catalog;
import com.aaa.model.Flower;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class TestDao {

	@Resource
	private CatalogDao catalogDao;

	@Resource
	private FlowerDao flowerDao;
	
	@Test
	public void testCatalogDao() {
		List<Catalog> catalogList = catalogDao.getAllCatalogs();
		for(int i=0; i < catalogList.size(); i++) {
			System.out.println(catalogList.get(i));
		}
	}

	@Test
	public void testFlowerDao() {
		List<Flower> flowerList = flowerDao.getNewFlowers();
		for(Flower f : flowerList) {
			System.out.println(f);
		}
	}
	
}
