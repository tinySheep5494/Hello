package com.chenyu.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String icon;

	private Double price;

	private Integer calorie;

	private Integer hunger;

	private Integer happiness;

	public Food() {
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

	public Integer getCalorie() {
		return calorie;
	}

	public void setCalorie(Integer calorie) {
		this.calorie = calorie;
	}

	public Integer getHunger() {
		return hunger;
	}

	public void setHunger(Integer hunger) {
		this.hunger = hunger;
	}

	public Integer getHappiness() {
		return happiness;
	}

	public void setHappiness(Integer happiness) {
		this.happiness = happiness;
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
		sBuffer.append("\",\"calorie\":\"");
		sBuffer.append(calorie);
		sBuffer.append("\",\"hunger\":\"");
		sBuffer.append(hunger);
		sBuffer.append("\",\"happiness\":\"");
		sBuffer.append(happiness);
		sBuffer.append("\"}");
		return sBuffer.toString();
	}
}
