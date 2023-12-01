package com.piku.code.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Question> getAllQuestions() {
		List<Question> allQuestion = questionService.getAllQuestions();
		System.out.println("all questions: "+ allQuestion.toString());
		return allQuestion;
	}
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category) {
		List<Question> questionsByCategory = questionService.getQuestionsBycategory(category);
		System.out.println("questions by category: "+ questionsByCategory.toString());
		return questionsByCategory;
	}

}
