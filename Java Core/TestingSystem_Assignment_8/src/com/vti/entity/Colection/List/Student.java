package com.vti.entity.Colection.List;

public class Student {
	private static int counter = 0;

	private int id;
	private String name;
	
	public Student(String name) {
		this.name = name;
		setId(++counter);
	}

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

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
	}

}
