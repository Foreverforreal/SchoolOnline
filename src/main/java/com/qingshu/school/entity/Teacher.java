package com.qingshu.school.entity;

import java.util.Date;

public class Teacher {
	private Integer id;
	private Integer globalUserId;
	private Integer centerId;
	private Date createdTime;
	private Date updatedTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getGlobalUserId() {
		return globalUserId;
	}
	
	public void setGlobalUserId(Integer globalUserId) {
		this.globalUserId = globalUserId;
	}
	
	public Integer getCenterId() {
		return centerId;
	}
	
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
}
