package com.chenyu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IT_FOOD")
public class Food implements Serializable {
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

	@Column(name = "CALORIE", nullable = false)
	private Integer calorie;

	@Column(name = "HUNGER", nullable = false)
	private Integer hunger;

	@Column(name = "HAPPINESS", nullable = false)
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
