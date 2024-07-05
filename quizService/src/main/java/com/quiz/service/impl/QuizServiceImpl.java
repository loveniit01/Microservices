package com.quiz.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repo.QuizRepository;
import com.quiz.service.QuestionClient;
import com.quiz.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	private final QuizRepository quizRepository;
	private final QuestionClient questionClient;

	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAll() {
		List<Quiz> allQuiz = quizRepository.findAll();
		return allQuiz.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionsForQuiz(quiz.getQuizId()));
			return quiz;
		}).collect(Collectors.toList());
	}

	@Override
	public Quiz get(Long id) {
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		quiz.setQuestions(questionClient.getQuestionsForQuiz(quiz.getQuizId()));

		return quiz;
	}

}
