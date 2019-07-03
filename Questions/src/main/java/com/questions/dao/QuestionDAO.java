package com.questions.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.questions.entity.Question;

@Repository("questionDAO")
public class QuestionDAO implements QuestionDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;	
	
	@Override
	public void saveQuestion(Question question){
		sessionFactory.getCurrentSession().save(question);
	}
	
}
