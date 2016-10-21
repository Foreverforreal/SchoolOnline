package com.qingshu.school.mapper;

import java.util.List;

import com.qingshu.school.entity.School;
import com.qingshu.school.entity.SchoolDbSetting;

public interface SchoolMapper {
	List<School> selectAllSchool();
	
	List<School> selectSchoolByCondition(School school);
	
	int insertSchool(School school);
	
	int insertSchoolDbSetting(SchoolDbSetting schoolDbSetting);
	
	int insertSchoolModule_degree(Integer schoolId);
	
	int insertSchoolModule_peixun(Integer schoolId);
}
