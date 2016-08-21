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
public class FlowerDao implements IFlowerDao {

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
	public List<Flower> getNewFlowers() {
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Flower order by flowerid desc");
		query.setFirstResult(0);
		query.setMaxResults(4);
		List<Flower> newFlowers = query.list();
		ts.commit();
		session.close();
		return newFlowers;
	}

	/**
	 * 获取分页后的对应的页面的鲜花的List
	 */
	@Override
	public List<Flower> getFlowerByCatalogPaging(int catalogid, int currentPage, int pageSize) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Flower where catalogid=" + catalogid);
		int startRow = (currentPage - 1) * pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List<Flower> flowers = query.list();
		transaction.commit();
		session.close();
		return flowers;
	}

	/**
	 * 获取总共的鲜花的款式的数量
	 */
	@Override
	public int getTotalByCatalog(int catalogid) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Flower where catalogid=" + catalogid);
		List<Flower> flowers = query.list();
		transaction.commit();
		session.close();
		return flowers.size();
	}

	/**
	 * 通过鲜花的id获得鲜花的数据
	 */
	@Override
	public Flower getFlowerById(int flowerid) {
//System.out.println(flowerid);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Flower where flowerid=" + flowerid);
		List flowers = query.list();
		transaction.commit();
		session.close();
		return (Flower) flowers.get(0);
	}

}
