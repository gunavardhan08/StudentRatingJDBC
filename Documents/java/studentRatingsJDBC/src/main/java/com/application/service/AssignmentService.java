package com.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.Assignments;
import com.application.model.Input;
import com.application.model.TotalScore;
import com.application.repository.AssignmentRepository;
import java.util.*;

@Service
public class AssignmentService {

	AssignmentRepository assignmentRepository;
	List<TotalScore> list = new ArrayList<>();
	
	public AssignmentService(AssignmentRepository assignmentRepository) {
		this.assignmentRepository=assignmentRepository;
	}
	
	public List<TotalScore> compute1(Input input)
	{
		String inputText = input.getInput();
		Set<String> subject = new HashSet<String>();
		List<TotalScore> totList = new ArrayList<>();
		List<Assignments> assignment = assignmentRepository.findByStudentName(inputText);
		for (Assignments assignments : assignment) {
			subject.add(assignments.getSubject());
		}
		String[] arrayOfString = subject.toArray(new String[0]);
		for (String string : arrayOfString) {
			List<Assignments> test = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(string,inputText,"%test%");
			List<Assignments> quiz = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(string,inputText,"%quiz%");
			List<Assignments> lab = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(string,inputText,"%lab%");
			List<Assignments> project = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(string,inputText,"%project%");
			float testScore=0.0f;
			float quizScore = 0.0f;
			float labScore = 0.0f;
			float projectScore = 0.0f;
			int a = Math.max(test.size(), quiz.size());
			int b = Math.max(lab.size(), project.size());
			int max = Math.max(a, b);
			TotalScore t = new TotalScore();
			t.setTitle(string);
			for(int i=0;i<max;i++)
			{
				if(i<test.size())
				{
					float val=(40/test.size())*test.get(i).getPoints();
					val=val/100;
					testScore+=val;
				}
				if(i<quiz.size())
				{
					float val=(20/quiz.size())*quiz.get(i).getPoints();
					val=val/100;
					quizScore+=val;
				}
				if(i<lab.size())
				{
					float val=(10/lab.size())*lab.get(i).getPoints();
					val=val/100;
					labScore+=val;
				}
				if(i<project.size())
				{
					float val=(30/project.size())*project.get(i).getPoints();
					val=val/100;
					projectScore+=val;
				}
			}
			t.setTestScore(testScore);
			t.setQuizScore(quizScore);
			t.setProjectScore(projectScore);
			t.setLabScore(labScore);
			t.setTot(testScore+quizScore+projectScore+labScore);
			totList.add(t);
		}
		return totList;
	}

	public List<TotalScore> compute2(Input input) {
		String inputText = input.getInput();
		Set<String> subject = new HashSet<String>();
		List<TotalScore> totList = new ArrayList<>();
		List<Assignments> assignment = assignmentRepository.findBySubject(inputText);
		for (Assignments assignments : assignment) {
			subject.add(assignments.getStudentName());
		}
		String[] arrayOfString = subject.toArray(new String[0]);
		for (String string : arrayOfString) {
			List<Assignments> test = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(inputText,string,"%test%");
			List<Assignments> quiz = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(inputText,string,"%quiz%");
			List<Assignments> lab = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(inputText,string,"%lab%");
			List<Assignments> project = assignmentRepository.findBySubjectAndStudentNameAndAssignmentCategoryLike(inputText,string,"%project%");
			float testScore=0.0f;
			float quizScore = 0.0f;
			float labScore = 0.0f;
			float projectScore = 0.0f;
			int a = Math.max(test.size(), quiz.size());
			int b = Math.max(lab.size(), project.size());
			int max = Math.max(a, b);
			TotalScore t = new TotalScore();
			t.setTitle(string);
			for(int i=0;i<max;i++)
			{
				if(i<test.size())
				{
					float val=(40/test.size())*test.get(i).getPoints();
					val=val/100;
					testScore+=val;
				}
				if(i<quiz.size())
				{
					float val=(20/quiz.size())*quiz.get(i).getPoints();
					val=val/100;
					quizScore+=val;
				}
				if(i<lab.size())
				{
					float val=(10/lab.size())*lab.get(i).getPoints();
					val=val/100;
					labScore+=val;
				}
				if(i<project.size())
				{
					float val=(30/project.size())*project.get(i).getPoints();
					val=val/100;
					projectScore+=val;
				}
			}
			t.setTestScore(testScore);
			t.setQuizScore(quizScore);
			t.setProjectScore(projectScore);
			t.setLabScore(labScore);
			t.setTot(testScore+quizScore+projectScore+labScore);
			totList.add(t);
		}

		return totList;
	}
}
