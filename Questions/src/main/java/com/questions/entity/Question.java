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



/**
 * @author sudam.jadhav
 *
 */
@Entity
@Table(name="question",schema="questions")
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
	private Integer questionNo;
	
	@Column(name = "question_name")
	private String questionName;
	
	@Column(name = "ans_choice")
	private String answerChoice;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="question")
	private Set<Answer> answers;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "question_id",referencedColumnName="sub_question_no")
	private Answer answer;

	public Integer getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getAnswerChoice() {
		return answerChoice;
	}

	public void setAnswerChoice(String answerChoice) {
		this.answerChoice = answerChoice;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
}
