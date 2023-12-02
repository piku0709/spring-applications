package com.piku.code.quizapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.piku.code.quizapp.model.Question;
import com.piku.code.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			List<Question> allQuestion = questionService.getAllQuestions();
			System.out.println("all questions: "+ allQuestion.toString());
			return new ResponseEntity<List<Question>>(allQuestion, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		try {
			List<Question> questionsByCategory = questionService.getQuestionsBycategory(category);
			System.out.println("questions by category: "+ questionsByCategory.toString());
			return new ResponseEntity<List<Question>>(questionsByCategory, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Question>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}
	
	@PostMapping
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {	
		try {
			String result = questionService.addQuestion(question);
			return new ResponseEntity<String>(result, HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("ERROR", HttpStatus.BAD_REQUEST);
	}

}
