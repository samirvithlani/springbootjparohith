package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Tutorial;

//save,delete,find,findbuId
//public interface TutorialRepository extends JpaRepository<Tutorial, Integer>
//Tutorial is your model / bean class
//Integer is your primary key data type..
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	// return type --> lIst
	List<Tutorial> findByPublished(boolean published);

	List<Tutorial> findByTitleContaining(String str);

	List<Tutorial> findByFeesLessThan(int fees);
	
	List<Tutorial> findByTitleOrderByTitle(String title);
	
	List<Tutorial> findByFeesBetween(int f1,int f2);
	
	List<Tutorial> findAllByOrderByFeesDesc();
	
	
	

}
