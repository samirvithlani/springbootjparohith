package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bean.Tutorial;

@Service
public interface TutorialService {

	public int save(Tutorial tutorial);

	public List<Tutorial> getAllTutorials();

	public Optional<Tutorial> getTutorialById(int id);
	
	public int deleteTutorial(int id);
	
	public int updateTutorial(int id,Tutorial tutorial);
	
	public List<Tutorial> getAllTutorialByPusblished(boolean published);
	public List<Tutorial> getAllTutorialByTitle(String title);
	public List<Tutorial> getAllTutorialByBetwwenFees(int f1,int f2);
	public List<Tutorial> getAllTutorailSotrtedByFees();
}
