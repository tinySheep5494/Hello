package com.chenyu.entity;

import javax.persistence.Entity;

@Entity
public class Food extends Item {
	private static final long serialVersionUID = 1L;

	private Integer calorie;

	private Integer hunger;

	private Integer happiness;

	public Food() {
		super();
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
}
