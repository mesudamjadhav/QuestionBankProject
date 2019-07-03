package com.questions.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subquestion",schema="questions")
public class SubQuestion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_question_id")
	private Integer subQuestionNo;
	
	@Column(name = "sub_question_desc")
	private String subQuestionDesc;
	
	@Column(name = "sub_question_choice")
	private String subQuestionChoice;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="sub_question_id",referencedColumnName="sub_question_no")
	private Answer answer;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="subQuestion")
	private Set<SubAnswer> subAnswers;

	public Integer getSubQuestionNo() {
		return subQuestionNo;
	}

	public void setSubQuestionNo(Integer subQuestionNo) {
		this.subQuestionNo = subQuestionNo;
	}

	public String getSubQuestionDesc() {
		return subQuestionDesc;
	}

	public void setSubQuestionDesc(String subQuestionDesc) {
		this.subQuestionDesc = subQuestionDesc;
	}

	public String getSubQuestionChoice() {
		return subQuestionChoice;
	}

	public void setSubQuestionChoice(String subQuestionChoice) {
		this.subQuestionChoice = subQuestionChoice;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Set<SubAnswer> getSubAnswers() {
		return subAnswers;
	}

	public void setSubAnswers(Set<SubAnswer> subAnswers) {
		this.subAnswers = subAnswers;
	}
}
