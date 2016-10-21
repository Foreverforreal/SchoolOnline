package com.qingshu.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qingshu.school.entity.School;
import com.qingshu.school.entity.SchoolDbSetting;
import com.qingshu.school.mapper.SchoolMapper;

@Service
public class SchoolService {
	@Autowired
	private SchoolMapper schoolMapper;

	
	public List<School> getSchoolByCondition(School school) {
		return schoolMapper.selectSchoolByCondition(school);
	}
	
	public Integer addSchool(School school, String dbUrl) {
		schoolMapper.insertSchool(school);
		insertDbSetting(school, dbUrl);
		
		if (school.getCategoryId() == 1) {
			schoolMapper.insertSchoolModule_degree(school.getId());
		} else if (school.getCategoryId() == 0) {
			schoolMapper.insertSchoolModule_peixun(school.getId());
		}
		
		return school.getId();
	}
	
	private void insertDbSetting(School school, String dbUrl) {
		SchoolDbSetting schoolDbSetting = new SchoolDbSetting();
		schoolDbSetting.setSchoolId(school.getId());
		schoolDbSetting.setUrl(dbUrl);
		schoolDbSetting.setDriverClassName("com.mysql.jdbc.Driver");
		schoolDbSetting.setUserName("feifanuniv");
		schoolDbSetting.setPassword("qyffRocks!9");
		schoolDbSetting.setInitialSize(1);
		schoolDbSetting.setMaxActive(20);
		schoolDbSetting.setMaxIdle(1);
		schoolDbSetting.setValidationQuery("SELECT 1 FROM DUAL;");
		schoolDbSetting.setStatus(true);
		schoolMapper.insertSchoolDbSetting(schoolDbSetting);
	}
	

}
