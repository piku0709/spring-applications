package com.piku.code.quizapp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piku.code.quizapp.dao.QuestionDao;
import com.piku.code.quizapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		List<Question> allQuestion = questionDao.findAll();
		//System.out.println("all questions "+ allQuestion.toString());
		return allQuestion;
	}

	public List<Question> getQuestionsBycategory(String category) {
		// TODO Auto-generated method stub
		return questionDao.findByCategory(category);
	}


}
