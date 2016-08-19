package com.aaa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.aaa.dao.ICatalogDao;

/**
 * 获取鲜花种类的类
 */
public class CatalogDao  implements ICatalogDao{
//	@Autowired
	private SessionFactory sessionFactory; 
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取鲜花种类的方法
	 */
	@Override
//	@Transactional
	public List getAllCatalogs() {
//		System.out.println("dao");
//		不太明白的地方，此处用getCurrentSession()就不用起作用
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Catalog");
		List catalogList = query.list();
//		System.out.println("dao2");

		transaction.commit();
		session.close();
		return catalogList;
	}

}
