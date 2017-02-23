package com.chenyu.enums;

public enum Meal {
	Breakfast(Integer.valueOf(0), "早餐"),
	Leach(Integer.valueOf(1), "午餐"),
	DInner(Integer.valueOf(2), "晚餐");
	
	private Integer value;
	private String name;
	
	private Meal(Integer value, String name) {
		this.value = value;
		this.name = name;
	}
	
	public static Meal fromValue(Integer value) {
		if (value != null) {
			for (Meal meal : values()) {
				if (value.equals(meal.value)) {
					return meal;
				}
			}
		}
		return null;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
