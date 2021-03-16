package com.app.qna.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.app.qna.model.Question;
import com.app.qna.model.QuestionDAO;
import com.app.qna.model.QuestionResponseModel;
import com.app.qna.repository.QuestionRepository;
@Component
@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepository) {
		// TODO Auto-generated constructor stub
		this.questionRepository=questionRepository;
	}
	@Autowired
	ModelMapper modelMapper;
	
	public Question postQuestion(Question question) {
		QuestionDAO questionDAO=modelMapper.map(question, QuestionDAO.class);
		questionDAO = questionRepository.save(questionDAO);
		question=modelMapper.map(questionDAO, Question.class);
		return question;
	}
}
