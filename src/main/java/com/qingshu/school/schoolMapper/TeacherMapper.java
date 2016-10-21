package com.qingshu.school.schoolMapper;

import com.qingshu.school.entity.Teacher;

public interface TeacherMapper {
	int insertTeacher(Teacher teacher);
	
	int insertTeacherModule_degree(Teacher teacher);
	
	int insertTeacherModule_peixun(Teacher teacher);
}
