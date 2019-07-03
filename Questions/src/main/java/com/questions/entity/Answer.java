package com.questions.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="answer",schema="questions")
public class Answer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
	private Integer answerNo;
	
	@Column(name = "answer_description")
	private String answerDesc;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="question_no",referencedColumnName="question_id")
	private Question question;
	
	@OneToOne(mappedBy="answer",cascade=CascadeType.ALL)
	private SubQuestion subQuestion;
	
	public Integer getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(Integer answerNo) {
		this.answerNo = answerNo;
	}

	public String getAnswerDesc() {
		return answerDesc;
	}

	public void setAnswerDesc(String answerDesc) {
		this.answerDesc = answerDesc;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public SubQuestion getSubQuestion() {
		return subQuestion;
	}

	public void setSubQuestion(SubQuestion subQuestion) {
		this.subQuestion = subQuestion;
	}
}
