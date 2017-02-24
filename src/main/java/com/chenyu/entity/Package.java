package com.chenyu.entity;

import javax.persistence.Entity;

@Entity
public class Package extends Item {
	private static final long serialVersionUID = 1L;

	private Integer size;

	public Package() {
		super();
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

}