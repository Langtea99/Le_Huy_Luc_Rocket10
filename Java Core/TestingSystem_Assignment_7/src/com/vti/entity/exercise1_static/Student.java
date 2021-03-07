package com.vti.entity.exercise1_static;

public class Student {
	private int id;
	private String name;
	public static String college = "Đại học bách khoa";
	
	public Student(int id, String name){
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student{" + "id=" + id + ", name='" + name + '\'' + ", college= " + college + '\'' + '}';
	}

	public static String getCollege() {
		return college;
	}

}
