package com.qingshu.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoaderListener;

import com.qingshu.school.entity.GlobalUser;
import com.qingshu.school.entity.Teacher;
import com.qingshu.school.entity.UserSchool;
import com.qingshu.school.home.DynicDataSource;
import com.qingshu.school.mapper.GlobalUserMapper;
import com.qingshu.school.schoolMapper.TeacherMapper;

@Service
public class TeacherService {
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private GlobalUserMapper globalUserMapper;
	
	public void addAdmin(String userName, Integer schoolId, Integer schoolType) {
		GlobalUser admin = new GlobalUser();
		admin.setUserName(userName);
		admin.setPassword("user@123");
		admin.setDisplayName("管理员");
		admin.setGender("男");
		admin.setUserType(0);
		
		int num = globalUserMapper.insertGlobalUser(admin);
		if (num == 1) {
			UserSchool userSchool = new UserSchool();
			userSchool.setSchoolId(schoolId);
			userSchool.setUserId(admin.getId());
			if (schoolType == 1) {
				userSchool.setUserRole(4);
			}
			if (schoolType == 0) {
				userSchool.setUserRole(2);
			}
			globalUserMapper.insertUserSchool(userSchool);
		}
		
		Teacher teacher = new Teacher();
		teacher.setGlobalUserId(admin.getId());
		
		int insertNum = teacherMapper.insertTeacher(teacher);
		if (insertNum == 1) {
			if (schoolType == 1) {
				teacherMapper.insertTeacherModule_degree(teacher);
			}
			if (schoolType == 0) {
				teacherMapper.insertTeacherModule_peixun(teacher);
			}
		}
	}
	
	public void switchDataSource(String schoolUrl) {
		DynicDataSource datasource = (DynicDataSource) ContextLoaderListener.getCurrentWebApplicationContext().getBean("dataSource-school");
		
		datasource.setUrl(schoolUrl);
		datasource.setReset(true);
	}
}
