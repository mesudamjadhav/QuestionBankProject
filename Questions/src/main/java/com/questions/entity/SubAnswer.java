package com.questions.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sub_answer",schema="questions")
public class SubAnswer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_answer_id")
	private Integer subAnswerNo;
	
	@Column(name = "sub_answer_desc")
	private String subAnswerDesc;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="sub_answer_que_id",referencedColumnName="sub_question_id")
	private SubQuestion subQuestion;

	public Integer getSubAnswerNo() {
		return subAnswerNo;
	}

	public void setSubAnswerNo(Integer subAnswerNo) {
		this.subAnswerNo = subAnswerNo;
	}

	public String getSubAnswerDesc() {
		return subAnswerDesc;
	}

	public void setSubAnswerDesc(String subAnswerDesc) {
		this.subAnswerDesc = subAnswerDesc;
	}

	public SubQuestion getSubQuestion() {
		return subQuestion;
	}

	public void setSubQuestion(SubQuestion subQuestion) {
		this.subQuestion = subQuestion;
	}
}
