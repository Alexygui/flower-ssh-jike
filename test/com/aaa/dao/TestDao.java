package com.aaa.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaa.dao.impl.CatalogDao;
import com.aaa.dao.impl.FlowerDao;
import com.aaa.dao.impl.UserDao;
import com.aaa.model.Catalog;
import com.aaa.model.Flower;
import com.aaa.model.User;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})  
public class TestDao {

	@Resource
	private CatalogDao catalogDao;

	@Resource
	private FlowerDao flowerDao;
	
	@Resource
	private UserDao userDao;
	
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
	
	@Test
	public void testCheckUser() {
		User user1 = new User();
		user1.setUsername("ty");
		user1.setPassword("56");
		user1.setRole("customer");
		//因为是对象类型，可能不能用断言，即使内容一样，也是不一样的对象
		Assert.assertEquals("ty", userDao.checkUser(user1).getUsername());
	}
}
