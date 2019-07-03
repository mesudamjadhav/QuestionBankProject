package com.questions.service;

import java.util.List;

import com.questions.dto.QuestionDTO;

public interface QuestionServiceImpl {

	void saveQuestions(List<QuestionDTO> questionDTOs);

}
