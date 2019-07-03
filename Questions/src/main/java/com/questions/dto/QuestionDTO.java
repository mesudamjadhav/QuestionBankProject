package com.questions.dto;

import java.util.List;

public class QuestionDTO {
	
	private Integer questionNo;
	
	private Integer subQuestionNo;
	
	private String questionName;
	
	private List<AnswerDTO> answers;
	
	private String choice;

	
	
	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

	public Integer getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(Integer questionNo) {
		this.questionNo = questionNo;
	}

	public Integer getSubQuestionNo() {
		return subQuestionNo;
	}

	public void setSubQuestionNo(Integer subQuestionNo) {
		this.subQuestionNo = subQuestionNo;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

}
