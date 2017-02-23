package com.chenyu.util;

import java.io.Serializable;
import java.util.List;

public class Page<T extends Serializable> {
	private Integer total;

	private List<T> content;

	public Page() {
		super();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
}
