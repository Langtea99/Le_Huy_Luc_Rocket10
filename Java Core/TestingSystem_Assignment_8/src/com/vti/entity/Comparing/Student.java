package com.vti.entity.Comparing;

import java.time.LocalDate;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	private LocalDate birthDay;
	private int score;
	private static int counter = 0;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Student(String name, LocalDate birthDay, int score) {
		super();
		setId(++counter);
		this.name = name;
		this.birthDay = birthDay;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthDay=" + birthDay + ", score=" + score + "]";
	}
	
	@Override
	public int compareTo(Student student) {
		return this.name.compareTo(student.getName());
	}


}
