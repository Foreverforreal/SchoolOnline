package com.qingshu.school.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshu.school.entity.School;
import com.qingshu.school.service.SchoolService;
import com.qingshu.school.service.TeacherService;

@Controller
public class HomeController {
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/Home")
	public String goHome() {
		return "home";
	}
	
	@RequestMapping("/AuthenticateSymbol")
	public @ResponseBody boolean findSymbol(String schoolSymbol) {
		School school = new School();
		school.setSymbol(schoolSymbol);
		List<School> result = schoolService.getSchoolByCondition(school);
		
		return result.size() > 0 ? true : false;
	}
	
	@RequestMapping("/addSchool")
	public @ResponseBody String addSchool(String schoolName, String schoolSymbol, Integer category, Integer database) {
		School school = new School();
		school.setName(schoolName);
		school.setSymbol(schoolSymbol);
		school.setCategoryId(category);
		school.setStatus(1);
		school.setApplerId(1);
		school.setBannerImageIds("1024");
		
		String formatUrl = "jdbc:mysql://qingshuproduct-instance-%d.chlhkgnyqqkn.rds.cn-north-1.amazonaws.com.cn:3306/%s?autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
		String url = null;
		if (category == 1) {
			url = String.format(formatUrl, database, "qingshu_" + schoolSymbol);
		}
		if (category == 0) {
			url = String.format(formatUrl, database, "px_" + schoolSymbol);
		}
		
		Integer schoolId = schoolService.addSchool(school, url);
		teacherService.switchDataSource(url);
		teacherService.addAdmin(schoolSymbol + "_admin", schoolId, category);
		return "success";
	}
}
