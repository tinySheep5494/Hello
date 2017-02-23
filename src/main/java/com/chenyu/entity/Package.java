package com.chenyu.entity;

import java.io.Serializable;

public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private Integer size;

	private Double price;

	public Package() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}