package com.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.application.model.Input;
import com.application.model.TotalScore;
import com.application.service.AssignmentService;

import java.util.*;

@Controller
public class LoginController {

	
	AssignmentService assignmentService;
	
	@Autowired
	public LoginController(AssignmentService assignmentService)
	{
		this.assignmentService=assignmentService;
	}
	@GetMapping("/")
	public String showHome(@ModelAttribute("Input") Input input) {
		return "Home";
	}
	
	@PostMapping("/home/input")
	public String getInput(@ModelAttribute("Input") Input input,Model model) {
		List<TotalScore> list = new ArrayList<>();
		if(input.getType().equals("Student Name"))
		{
			list = assignmentService.compute1(input);
		}
		else
		{
			list = assignmentService.compute2(input);
		}
		for(TotalScore t:list)
			System.out.println(t.toString());
		model.addAttribute("list", list);
		return "subject";
	}
	
	@ModelAttribute("inputType")
	public List<String> populateGender() {
		List<String> list = new ArrayList<>();
		list.add("Student Name");
		list.add("Subject");
		return list;
	}


}
