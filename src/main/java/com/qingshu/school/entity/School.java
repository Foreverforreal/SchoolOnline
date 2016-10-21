package com.qingshu.school.entity;

import java.util.Date;

public class School {
	private Integer id;
	
	private String name;
	
	private String symbol;
	
	private Integer categoryId;
	
	private Integer categoryType;
	
	private String phone;
	
	private String email;
	
	private String alipayEmail;
	
	private String address;
	
	private String logoUrl;
	
	private String certiInfoUrl;
	
	private String bannerImageIds;
	
	private Integer status;
	
	private Integer applerId;
	
	private Date applyTime;
	
	private Integer updaterId;
	
	private Date updateTime;
	
	private String introduction;
	
	private String introductionDetail;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol == null ? null : symbol.trim();
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public Integer getCategoryType() {
		return categoryType;
	}
	
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
	
	public String getAlipayEmail() {
		return alipayEmail;
	}
	
	public void setAlipayEmail(String alipayEmail) {
		this.alipayEmail = alipayEmail == null ? null : alipayEmail.trim();
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}
	
	public String getLogoUrl() {
		return logoUrl;
	}
	
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl == null ? null : logoUrl.trim();
	}
	
	public String getCertiInfoUrl() {
		return certiInfoUrl;
	}
	
	public void setCertiInfoUrl(String certiInfoUrl) {
		this.certiInfoUrl = certiInfoUrl == null ? null : certiInfoUrl.trim();
	}
	
	public String getBannerImageIds() {
		return bannerImageIds;
	}
	
	public void setBannerImageIds(String bannerImageIds) {
		this.bannerImageIds = bannerImageIds == null ? null : bannerImageIds.trim();
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getApplerId() {
		return applerId;
	}
	
	public void setApplerId(Integer applerId) {
		this.applerId = applerId;
	}
	
	public Date getApplyTime() {
		return applyTime;
	}
	
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	public Integer getUpdaterId() {
		return updaterId;
	}
	
	public void setUpdaterId(Integer updaterId) {
		this.updaterId = updaterId;
	}
	
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}
	
	public String getIntroductionDetail() {
		return introductionDetail;
	}
	
	public void setIntroductionDetail(String introductionDetail) {
		this.introductionDetail = introductionDetail == null ? null : introductionDetail.trim();
	}
	
}