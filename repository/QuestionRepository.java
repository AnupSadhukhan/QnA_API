package com.app.qna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.qna.model.QuestionDAO;

@Component
@Repository
public interface QuestionRepository extends JpaRepository<QuestionDAO, Long> {

}
