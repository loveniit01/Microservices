/**
 * 
 */
package com.question.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.question.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

	List<Question> findByQuizId(Long quizId);
	
}
