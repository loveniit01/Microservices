package com.question.service;

import java.util.List;

import com.question.entity.Question;

public interface QuestionService {
	
	Question add(Question question);
	
	List<Question> findAll();
	
	Question getById (Long questionId);
	
	List<Question> getByQuizId(Long quizId);
}
