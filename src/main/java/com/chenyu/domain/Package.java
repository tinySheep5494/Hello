package com.chenyu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IT_PACKAGE")
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false, precision = 8)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "ICON", nullable = false)
	private String icon;

	@Column(name = "PRICE", nullable = false)
	private Double price;

	@Column(name = "SIZE", nullable = false)
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