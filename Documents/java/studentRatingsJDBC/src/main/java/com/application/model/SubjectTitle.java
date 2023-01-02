package com.application.model;

public class SubjectTitle {

	private String name;
	private float testScore = 0.0f;
	private float quizScore = 0.0f;
	private float labScore = 0.0f;
	private float projectScore = 0.0f;
	private float tot = 0.0f;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTestScore() {
		return testScore;
	}

	public void setTestScore(float testScore) {
		this.testScore = testScore;
	}

	public float getQuizScore() {
		return quizScore;
	}

	public void setQuizScore(float quizScore) {
		this.quizScore = quizScore;
	}

	public float getLabScore() {
		return labScore;
	}

	public void setLabScore(float labScore) {
		this.labScore = labScore;
	}

	public float getProjectScore() {
		return projectScore;
	}

	public void setProjectScore(float projectScore) {
		this.projectScore = projectScore;
	}

	public float getTot() {
		return tot;
	}

	public void setTot(float tot) {
		this.tot = tot;
	}

}
