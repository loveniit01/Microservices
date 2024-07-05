package com.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Question;

@FeignClient(url = "http://localhost:8083", value = "QuistionClient")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
List<Question> getQuestionsForQuiz(@PathVariable Long quizId);
}
