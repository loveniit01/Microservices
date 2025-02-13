package com.quiz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private final QuizService quizService;

    QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
	
	@PostMapping()
	public ResponseEntity<Quiz> save(@RequestBody Quiz quiz) {
		return ResponseEntity.status(HttpStatus.CREATED).body(quizService.add(quiz));
	}
	
	@GetMapping()
	public ResponseEntity<List<Quiz>> allQuiz() {
		return ResponseEntity.status(HttpStatus.OK).body(quizService.getAll());	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> quiz(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(quizService.get(id));	
	}
}
