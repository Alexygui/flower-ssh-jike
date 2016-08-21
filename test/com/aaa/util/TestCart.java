package com.aaa.util;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aaa.model.Flower;
import com.aaa.model.Orderitem;
import com.aaa.tool.Cart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestCart {
	@Resource
	private Cart cart;
	
	@Test
	public void testTotalPrice() {
		
	}
}
