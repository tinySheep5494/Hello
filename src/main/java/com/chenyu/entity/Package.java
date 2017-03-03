package com.chenyu.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String icon;

	private Double price;

	private Integer size;

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("{\"id\":\"");
		sBuffer.append(id);
		sBuffer.append("\",\"name\":\"");
		sBuffer.append(name);
		sBuffer.append("\",\"icon\":\"");
		sBuffer.append(icon);
		sBuffer.append("\",\"price\":\"");
		sBuffer.append(price);
		sBuffer.append("\",\"size\":\"");
		sBuffer.append(size);
		sBuffer.append("\"}");
		return sBuffer.toString();
	}

}