package com.chenyu.util;

import java.io.Serializable;
import java.util.List;

public class PageResult<T extends Serializable> {
	private Long size;

	private List<T> page;

	public PageResult() {
		super();
	}

	public PageResult(Long size, List<T> page) {
		super();
		this.size = size;
		this.page = page;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public List<T> getPage() {
		return page;
	}

	public void setPage(List<T> page) {
		this.page = page;
	}
}
