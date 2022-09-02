package com.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.bean.Tutorial;
import com.service.TutorialRepository;
import com.service.TutorialService;

@Repository
public class TutorialDao implements TutorialService {

	@Autowired
	TutorialRepository tutorialRepository;

	@Override
	public int save(Tutorial tutorial) {

		int x = 0;
		// session,mange transtion
		try {
			tutorialRepository.save(tutorial);
			x = 1;

		} catch (Exception e) {
			x = 0;
		}
		return x;
	}

	@Override
	public List<Tutorial> getAllTutorials() {

		return tutorialRepository.findAll();

	}

	@Override
	public Optional<Tutorial> getTutorialById(int id) {
		// TODO Auto-generated method stub
		Optional<Tutorial> tutorial = tutorialRepository.findById(id);
		return tutorial;
	}

	@Override
	public int deleteTutorial(int id) {
		int res = 0;
		try {
			tutorialRepository.deleteById(id);
			res = 1;
		} catch (Exception e) {

			res = 0;
		}
		return res;
	}

	@Override
	public int updateTutorial(int id, Tutorial tutorial) {

		// findby id and save..
		Optional<Tutorial> dataById = tutorialRepository.findById(id);
		int res = 0;
		if (dataById.isPresent()) {

			Tutorial tutorial2 = dataById.get();
			tutorial2.setTitle(tutorial.getTitle());
			tutorial2.setDescription(tutorial.getDescription());
			tutorial2.setPublished(tutorial.isPublished());

			try {
				tutorialRepository.save(tutorial2);
				res = 1;

			} catch (Exception e) {
				res = -1;
			}

		}
		return res;

	}

	@Override
	public List<Tutorial> getAllTutorialByPusblished(boolean published) {

		return tutorialRepository.findByPublished(published);
	}

	@Override
	public List<Tutorial> getAllTutorialByTitle(String title) {
		// TODO Auto-generated method stub
		return tutorialRepository.findByTitleContaining(title);
	}

	@Override
	public List<Tutorial> getAllTutorialByBetwwenFees(int f1, int f2) {
		// TODO Auto-generated method stub
		return tutorialRepository.findByFeesBetween(f1, f2);
	}

	@Override
	public List<Tutorial> getAllTutorailSotrtedByFees() {
		// TODO Auto-generated method stub
		return tutorialRepository.findAllByOrderByFeesDesc();
	}

}
