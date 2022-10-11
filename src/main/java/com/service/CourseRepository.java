package com.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.CourseBean;

@Repository
public interface CourseRepository extends JpaRepository<CourseBean, Integer> {

}
