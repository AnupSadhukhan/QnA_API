package com.app.qna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionDAO {
	@Id
	@Column
	private int id;
	@Column
	private String text;
	public QuestionDAO(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
