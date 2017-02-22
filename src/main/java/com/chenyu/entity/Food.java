package com.chenyu.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String state;
	
	private Timestamp createTime;
	
	private Timestamp updateTime;

	public Food() {
		super();
	}

	public Food(String name, String state, Timestamp createTime, Timestamp updateTime) {
		super();
		this.name = name;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Food(Long id, String name, String state, Timestamp createTime, Timestamp updateTime) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.createTime = createTime;
		this.updateTime = updateTime;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
