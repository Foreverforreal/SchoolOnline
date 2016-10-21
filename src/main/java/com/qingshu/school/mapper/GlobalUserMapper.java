package com.qingshu.school.mapper;

import com.qingshu.school.entity.GlobalUser;
import com.qingshu.school.entity.UserSchool;

public interface GlobalUserMapper {
	int insertGlobalUser(GlobalUser globalUser);
	
	int insertUserSchool(UserSchool userSchool);
}
