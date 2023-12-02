package com.piku.code.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piku.code.quizapp.dao.QuestionDao;
import com.piku.code.quizapp.dao.QuizDao;
import com.piku.code.quizapp.model.Question;
import com.piku.code.quizapp.model.QuestionWrapper;
import com.piku.code.quizapp.model.Quiz;
import com.piku.code.quizapp.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDb = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q : questionsFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		
		return new ResponseEntity<List<QuestionWrapper>>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questions = quiz.get().getQuestions();
		
		int rightAnswer = 0;
		int questionIndex = 0;
		for(Response response: responses) {
			if(response.getResponse().equalsIgnoreCase(questions.get(questionIndex).getRightAnswer()))
				rightAnswer++;
			
			questionIndex++;
		}
		
		return new ResponseEntity<Integer>(rightAnswer, HttpStatus.OK);
	}


}
