package com.aaa.service;

import java.util.List;

import com.aaa.model.Flower;

public interface IFlowerService {
	public List<Flower> getNewFlowers();
	public List<Flower> getFlowerByCatalogPaging(int catalogid, int currentPage, int pageSize);
	public int getTotalByCatalog(int catalogid);
	public Flower getFlowerById(int flowerid);
	public boolean addOrUpdateFlower(Flower flower2);
	public List<Flower> getAllFlowerPaging();
	public void deleteOneFlower(int flowerid);
}
