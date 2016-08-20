package com.aaa.util;

/**
 * 保存分页数据的类
 */
public class Page {
	private int currentPage;
	private static final int PAGE_SIZE = 4;
	private int totalSize;
	private int totalPage;
	private boolean hasFirst;
	private boolean hasLast;
	private boolean hasPrevious;
	private boolean hasNext;

	public Page() {
	}

	public Page(int currentPage, int totalSize) {
		this.currentPage = currentPage;
		this.totalSize = totalSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public boolean isHasFirst() {
		if(currentPage <= 1) {
			return false;
		} else {
			
		return true;
		}
	}

	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	public boolean isHasLast() {
		if(currentPage >= getTotalPage()) {
			return false;
		} else {
		return true;
		}
	}

	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

	public boolean isHasPrevious() {
		if(isHasFirst()){
			return true;
		} else {
			return false;
		}
	}

	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}

	public boolean isHasNext() {
		if(isHasLast()) {
			return true;
		} else {
		return false;
		}
	}

	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	public static int getPageSize() {
		return PAGE_SIZE;
	}

	public int getTotalPage() {
		totalPage = totalSize / PAGE_SIZE;
		if (totalSize % PAGE_SIZE != 0) {
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}
