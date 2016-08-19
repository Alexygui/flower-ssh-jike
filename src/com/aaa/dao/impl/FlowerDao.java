package com.aaa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.aaa.dao.IFlowerDao;
import com.aaa.model.Flower;

/**
 * flower的Dao层的类
 */
public class FlowerDao implements IFlowerDao{
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 从数据库中取得最新上架的4款鲜花 
	 */
	@Override
	public List getNewFlowers() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Flower order by flowerid desc");
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<Flower> flowers = query.list();
		ts.commit();
		session.close();
		return flowers;
	}

}
