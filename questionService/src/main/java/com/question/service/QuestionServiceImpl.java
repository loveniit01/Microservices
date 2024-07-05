package com.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entity.Question;
import com.question.repo.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	private final QuestionRepo questionRepo;

    QuestionServiceImpl(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

	@Override
	public Question add(Question question) {

		return questionRepo.save(question);
	}

	@Override
	public List<Question> findAll() {
		return questionRepo.findAll();
	}

	@Override
	public Question getById(Long questionId) {
		return questionRepo.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getByQuizId(Long quizId) {
		List<Question> byQuizId = questionRepo.findByQuizId(quizId);
		if (!byQuizId.isEmpty()) {
			return byQuizId;
		} else {
			throw new UnsupportedOperationException("Unimplemented method 'getByQuizId'");
		}
	}

}
