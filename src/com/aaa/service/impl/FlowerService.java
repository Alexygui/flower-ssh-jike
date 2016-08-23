package com.aaa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.aaa.dao.IFlowerDao;
import com.aaa.model.Flower;
import com.aaa.service.IFlowerService;

/**
 * flower的service层实现类
 */
public class FlowerService implements IFlowerService{

	private IFlowerDao flowerDao;
	
	public IFlowerDao getFlowerDao() {
		return flowerDao;
	}

	public void setFlowerDao(IFlowerDao flowerDao) {
		this.flowerDao = flowerDao;
	}

	/**
	 * 获取最新上架的四款鲜花
	 */
	@Override
	public List<Flower> getNewFlowers() {
		return flowerDao.getNewFlowers();
	}

	/**
	 * 获取分页后的对应的页面的鲜花的List
	 */
	@Override
	public List<Flower> getFlowerByCatalogPaging(int catalogid, int currentPage, int pageSize) {
		return flowerDao.getFlowerByCatalogPaging(catalogid, currentPage, pageSize);
	}

	/**
	 * 获取总共的鲜花的款式的数量
	 */
	@Override
	public int getTotalByCatalog(int catalogid) {
		return flowerDao.getTotalByCatalog(catalogid);
	}

	/**
	 * 通过鲜花的id号获取鲜花的对象
	 */
	@Override
	public Flower getFlowerById(int flowerid) {
		return flowerDao.getFlowerById(flowerid);
	}

	/**
	 * 将新添加的鲜花或修改后的鲜花的的数据保存到数据库，并返回保存结果
	 */
	@Override
	public boolean addOrUpdateFlower(Flower flower) {
		return flowerDao.addOrUpdateFlower(flower);
	}

	/**
	 * 从数据库获取所有的鲜花的数据
	 */
	@Override
	public List<Flower> getAllFlowerPaging() {
		return flowerDao.getAllFlowerPaging();
	}

	/**
	 * 删除某一款的鲜花
	 */
	@Override
	public void deleteOneFlower(int flowerid) {
		flowerDao.deleteOneFlower(flowerid);
	}

}
