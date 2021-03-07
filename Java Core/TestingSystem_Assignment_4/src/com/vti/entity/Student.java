package com.vti.entity;

public class Student {
	protected int id;
	protected String name;
	protected String hometown;
	protected float academic_grade;
	
	public Student()
	{
		
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

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public float getAcademic_grade() {
		return academic_grade;
	}

	public void setAcademic_grade(float academic_grade) {
		this.academic_grade = academic_grade;
	}

	public  Student(String name,String hometown)
	{
		this.name = name;
		this.hometown = hometown;
		academic_grade = 0;
		System.out.println("Name: "+name+";Hometown: "+hometown+";Academic_grade: "+academic_grade);
	}
	
	public Student(int id, String name, String hometown, float academic_grade) {
		this.id=id;
		this.name = name;
		this.hometown = hometown;
		this.academic_grade = academic_grade;
	}

	public void plus_Academic_grade(float grade)
	{
		this.academic_grade +=grade;
	}
@Override
	public String toString() {
		String grade;
		if (academic_grade < 4.0) {
			grade = "Yếu";
		} else if (academic_grade < 6) {
			grade = "Trung bình";
		} else if (academic_grade < 8) {
			grade = "Khá";
		} else {
			grade = "Giỏi";
		}
		return "Student{" + "id=" + id + ", Name='" + name + '\'' + ", Hometown='" + hometown + '\'' + ", Academic_grade="
				+ academic_grade + ", xepLoai='" + grade + '\'' + '}';
	}
}
