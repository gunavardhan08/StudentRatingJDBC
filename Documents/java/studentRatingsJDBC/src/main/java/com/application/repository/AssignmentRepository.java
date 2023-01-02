package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.application.model.Assignments;
import java.util.*;


public interface AssignmentRepository extends JpaRepository<Assignments, Integer> {

	List<Assignments> findByStudentName(String inputText);

	List<Assignments> findBySubjectAndStudentNameAndAssignmentCategoryLike(String input, String name, String text);

	List<Assignments> findBySubject(String inputText);

}
