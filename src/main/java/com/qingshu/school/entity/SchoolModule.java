package com.qingshu.school.entity;

public class SchoolModule {
	private Integer id;
	private Integer school_id;
	private Integer role_id;
	private Integer module_id;
	private Integer parent_module_id;
	private Integer order;
	private Boolean show_in_homepage;
	private Boolean show_in_nav;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSchool_id() {
		return school_id;
	}
	
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	
	public Integer getRole_id() {
		return role_id;
	}
	
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	public Integer getModule_id() {
		return module_id;
	}
	
	public void setModule_id(Integer module_id) {
		this.module_id = module_id;
	}
	
	public Integer getParent_module_id() {
		return parent_module_id;
	}
	
	public void setParent_module_id(Integer parent_module_id) {
		this.parent_module_id = parent_module_id;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public Boolean getShow_in_homepage() {
		return show_in_homepage;
	}
	
	public void setShow_in_homepage(Boolean show_in_homepage) {
		this.show_in_homepage = show_in_homepage;
	}
	
	public Boolean getShow_in_nav() {
		return show_in_nav;
	}
	
	public void setShow_in_nav(Boolean show_in_nav) {
		this.show_in_nav = show_in_nav;
	}
	
}
