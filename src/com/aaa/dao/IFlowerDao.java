package com.aaa.dao;

import java.util.List;

import com.aaa.model.Flower;

public interface IFlowerDao {
	public List<Flower> getNewFlowers();
	public List<Flower> getFlowerByCatalogPaging(int catalogid, int currentPage, int pageSize);
	public int getTotalByCatalog(int catalogid);
	public Flower getFlowerById(int flowerid);
	public boolean addOrUpdateFlower(Flower flower);
	public List<Flower> getAllFlowerPaging();
}
