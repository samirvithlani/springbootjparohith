package com.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Tutorial;
import com.service.TutorialService;

@RestController
@CrossOrigin
public class TutorialController {

	@Autowired
	TutorialService tutorialService;

	@PostMapping(value = "/tutorial")
	public ResponseEntity<Tutorial> saveTutorial(@RequestBody Tutorial tutorial) {

		int res = tutorialService.save(tutorial);
		if (res > 0) {

			return new ResponseEntity<Tutorial>(tutorial, HttpStatus.OK);
		}
		return new ResponseEntity<Tutorial>(HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/tutorial")
	public ResponseEntity<List<Tutorial>> getAllTutorial() {

		List<Tutorial> tutorials = tutorialService.getAllTutorials();
		if (tutorials.size() > 0) {

			return new ResponseEntity<List<Tutorial>>(tutorials, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tutorial>>(HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/tutorial/{id}")
	public ResponseEntity<Tutorial> gettutorial(@PathVariable("id") int id) {

		Optional<Tutorial> tut = tutorialService.getTutorialById(id);

		if (tut.isPresent()) {
			Tutorial tutorial = tut.get();
			tutorial.setId(tutorial.getId());
			tutorial.setTitle(tutorial.getTitle());
			tutorial.setDescription(tutorial.getDescription());
			tutorial.setPublished(tutorial.isPublished());
			return new ResponseEntity<Tutorial>(tutorial, HttpStatus.OK);
		}

		return new ResponseEntity<Tutorial>(HttpStatus.EXPECTATION_FAILED);
	}

	@DeleteMapping(value = "/tutorial/{id}")
	public ResponseEntity<String> deleteTutorail(@PathVariable("id") int id) {

		int res = tutorialService.deleteTutorial(id);
		String message = "";
		if (res > 0) {

			message = id + " record is deleted..";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		message = id + " record is not deleted..";
		return new ResponseEntity<String>(message, HttpStatus.EXPECTATION_FAILED);

	}

	@PutMapping(value = "/tutorial1/{id}")
	public ResponseEntity<String> updateTutorial(@PathVariable("id") int id, @RequestBody Tutorial tutorial) {

		int res = tutorialService.updateTutorial(id, tutorial);
		String message = "";
		if (res > 0) {

			message = id + " record is deleted..";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
		message = id + " record is not deleted..";
		return new ResponseEntity<String>(message, HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/tutorial1/{published}")
	public ResponseEntity<List<Tutorial>> getTutorialByPublished(@PathVariable("published") boolean published) {

		List<Tutorial> list = tutorialService.getAllTutorialByPusblished(published);
		if (list.size() > 0) {
			return new ResponseEntity<List<Tutorial>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tutorial>>(HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/tutorial2/{title}")
	public ResponseEntity<List<Tutorial>> getTutorialByTitle(@PathVariable("title") String title) {

		List<Tutorial> list = tutorialService.getAllTutorialByTitle(title);
		if (list.size() > 0) {
			return new ResponseEntity<List<Tutorial>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tutorial>>(HttpStatus.EXPECTATION_FAILED);

	}

	@GetMapping(value = "/tutorial3/{f1}/{f2}")
	public ResponseEntity<List<Tutorial>> getTutorialByFees(@PathVariable("f1") int f1, @PathVariable("f2") int f2) {

		List<Tutorial> list = tutorialService.getAllTutorialByBetwwenFees(f1, f2);
		if (list.size() > 0) {
			return new ResponseEntity<List<Tutorial>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tutorial>>(HttpStatus.EXPECTATION_FAILED);

	}
	@GetMapping(value = "/tutorial4")
	public ResponseEntity<List<Tutorial>> getTutorialByFeesSorted() {

		List<Tutorial> list = tutorialService.getAllTutorailSotrtedByFees();
		if (list.size() > 0) {
			return new ResponseEntity<List<Tutorial>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<Tutorial>>(HttpStatus.EXPECTATION_FAILED);

	}
	

}
