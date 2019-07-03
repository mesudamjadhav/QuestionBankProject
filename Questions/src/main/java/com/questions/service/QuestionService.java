package com.questions.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.questions.dao.QuestionDaoImpl;
import com.questions.dto.AnswerDTO;
import com.questions.dto.QuestionDTO;
import com.questions.entity.Answer;
import com.questions.entity.Question;
import com.questions.entity.SubAnswer;
import com.questions.entity.SubQuestion;

@Service("questionService")
public class QuestionService implements QuestionServiceImpl {

	@Autowired
	private QuestionDaoImpl questionDAO;
	
	@Override
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void saveQuestions(List<QuestionDTO> questionDTOs) {

		for (QuestionDTO questionDTO : questionDTOs) {
			Question question = new Question();
			question.setQuestionName(questionDTO.getQuestionName());
			question.setAnswerChoice(questionDTO.getChoice());
			Set<Answer> answers = new HashSet<>();
			for (AnswerDTO answerDto : questionDTO.getAnswers()) {
				Answer answer = new Answer();
				answer.setAnswerDesc(answerDto.getAnswerDesc());
				answer.setQuestion(question);
				SubQuestion subQuestion = new SubQuestion();
				subQuestion.setSubQuestionDesc(answerDto.getSubQuestion().getQuestionName());
				subQuestion.setSubQuestionChoice(answerDto.getSubQuestion().getChoice());
				Set<SubAnswer> subAnswers = new HashSet<>();
				for (AnswerDTO subAnswerDto : answerDto.getSubQuestion().getAnswers()) {
					SubAnswer subAnswer = new SubAnswer();
					subAnswer.setSubAnswerDesc(subAnswerDto.getAnswerDesc());
					subAnswer.setSubQuestion(subQuestion);
					subAnswers.add(subAnswer);
				} 
				subQuestion.setSubAnswers(subAnswers);
				answer.setSubQuestion(subQuestion);
				answers.add(answer);
			}
			question.setAnswers(answers);
			questionDAO.saveQuestion(question);
		}
	}
}
