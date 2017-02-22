package com.chenyu.enums;

public enum Week {
	Sunday(Integer.valueOf(0), "周日"), Monday(Integer.valueOf(1), "周一"), Tuesday(Integer.valueOf(2), "周二"), Wednesday(
			Integer.valueOf(3), "周三"), Thursday(Integer.valueOf(4),
					"周四"), Firday(Integer.valueOf(5), "周五"), Saturday(Integer.valueOf(6), "周六");

	private Integer value;
	private String name;

	private Week(Integer value, String name) {
		this.value = value;
		this.name = name;
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

	public static Week fromValue(Integer value) {
		if (value != null) {
			for (Week week : values()) {
				if (value.equals(week.value)) {
					return week;
				}
			}
		}
		return null;
	}
}
