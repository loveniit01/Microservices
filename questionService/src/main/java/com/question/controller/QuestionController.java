package com.question.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.Question;
import com.question.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	private final QuestionService questionService;

    QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

	@GetMapping
	public ResponseEntity<List<Question>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(questionService.findAll());
	}

	@PostMapping
	public ResponseEntity<Question> save(@RequestBody Question question) {
		return ResponseEntity.status(HttpStatus.CREATED).body(questionService.add(question));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> find(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(questionService.getById(id));
	}

	@GetMapping("/quiz/{id}")
	public ResponseEntity<List<Question>> findByQuizId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(questionService.getByQuizId(id));
	}	
}
