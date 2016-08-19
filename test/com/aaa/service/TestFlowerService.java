package com.aaa.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaa.dao.impl.CatalogDao;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class TestFlowerService {
//	@Resource
//	CatalogDao catalogDao;
	
//	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");  
//	  
//    context.start();
	@Resource
	private CatalogDao catalogDao;
	
//	@BeforeClass 
//	 public static void init() { 
//		 ApplicationContext 
//context = new ClassPathXmlApplicationContext("config/Spring-db-old.xml"); 
//		 catalogDao = (catalogDao)context.getBean("catalogDao"); 
//	 } 	
	
	@Test
	public void testCatalog() {
//		CatalogDao catalogDao = new CatalogDao();
		List catalogList = catalogDao.getAllCatalogs();
//		for(int i=0; i < catalogList.size(); i++) {
//			System.out.println(catalogList.get(i));
//		}
	}
	
}
