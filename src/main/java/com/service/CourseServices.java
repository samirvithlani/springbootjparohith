package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bean.CourseBean;

@Service
public interface CourseServices {

	public int addCourse(CourseBean courseBean);
	public int deleteCourse(int cId);
	public List<CourseBean> getAllCourse();

}
