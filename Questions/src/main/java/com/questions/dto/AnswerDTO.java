package com.questions.dto;

public class AnswerDTO {
	
	private Integer answerNo;
	
	private String answerDesc;
	
	private QuestionDTO subQuestion;

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

	public QuestionDTO getSubQuestion() {
		return subQuestion;
	}

	public void setSubQuestion(QuestionDTO subQuestion) {
		this.subQuestion = subQuestion;
	}
	
	
}
