package com.app.qna.controllers;

import java.util.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.qna.model.Question;
import com.app.qna.model.QuestionResponseModel;
import com.app.qna.service.QuestionService;

@RestController(value="/")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public String test() {
		return "working";
	}
	@GetMapping(path="/question")
	public List<QuestionResponseModel> getAllQuestions() {
		List<QuestionResponseModel> li=new ArrayList<>();
		QuestionResponseModel question=new QuestionResponseModel(1,"I'm not able to fix this issues!!");
		li.add(question);
		return li;
	}
	@PostMapping("/question")
	public ResponseEntity<String> postQuestion(@RequestBody Question question){
		
		question=questionService.postQuestion(question);
		if(question==null) {
			return ResponseEntity.badRequest().body("Internal Server Error");
		}
		modelMapper.map(question, QuestionResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body("Posted Successfully");
	}
}
