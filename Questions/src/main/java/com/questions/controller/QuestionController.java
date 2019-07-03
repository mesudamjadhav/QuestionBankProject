package com.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.questions.dto.QuestionDTO;
import com.questions.service.QuestionServiceImpl;

@RestController
@RequestMapping("/questionController/")
public class QuestionController {
	
	@Autowired
	private QuestionServiceImpl questionService;
	
	@RequestMapping(value = "test",method = RequestMethod.POST)
	public ModelAndView test(@RequestParam Integer qNo, ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.setViewName("homePage");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "getSubQuestion",method = RequestMethod.POST)
	public ModelAndView getSubQuestion(@RequestParam Integer qNo,@RequestParam Integer ansNo, ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.addObject("ansNo",ansNo);
		modelAndView.setViewName("subQuestion");
		return modelAndView;
	}
	
	@RequestMapping(value = "getTextArea",method = RequestMethod.POST)
	public ModelAndView getTextArea(@RequestParam Integer qNo,ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.setViewName("textArea");
		return modelAndView;
	}
	
	@RequestMapping(value = "getSingleText",method = RequestMethod.POST)
	public ModelAndView getSingleText(@RequestParam Integer qNo,ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.setViewName("textBox");
		return modelAndView;
	}
	
	@RequestMapping(value = "getMultiText",method = RequestMethod.POST)
	public ModelAndView getMultiText(@RequestParam Integer qNo,ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.setViewName("multipleChoice");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "getSubTextArea",method = RequestMethod.POST)
	public ModelAndView getSubTextArea(@RequestParam Integer qNo,ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.setViewName("subTextAre");
		return modelAndView;
	}
	
	@RequestMapping(value = "getSubSingleText",method = RequestMethod.POST)
	public ModelAndView getSubSingleText(@RequestParam Integer qNo,ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.setViewName("subTextBox");
		return modelAndView;
	}
	
	@RequestMapping(value = "getSubMultiText",method = RequestMethod.POST)
	public ModelAndView getSubMultiText(@RequestParam Integer qNo,ModelAndView modelAndView){
		modelAndView.addObject("qNo",qNo);
		modelAndView.setViewName("subMultiChoice");
		return modelAndView;
	}
	
	@RequestMapping(value = "saveQuestions",method = RequestMethod.POST)
	public ModelAndView saveQuestions(@RequestBody List<QuestionDTO> questionDTOs, ModelAndView modelAndView){
		questionService.saveQuestions(questionDTOs);
		return modelAndView;
	}
	
	
	
}
