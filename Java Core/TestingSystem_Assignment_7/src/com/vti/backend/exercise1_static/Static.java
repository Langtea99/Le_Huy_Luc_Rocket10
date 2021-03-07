package com.vti.backend.exercise1_static;

import com.vti.entity.exercise1_static.Student;

public class Static {
	public void question1() throws Exception {
		Student student1 = new Student(1,"Nguyễn Văn A");
		Student student2 = new Student(2,"Nguyễn Văn B");
		Student student3 = new Student(3,"Nguyễn Văn C");
		Student[] student = {student1,student2,student3};
		for(int i=0;i<student.length;i++){
			System.out.println(student[i].toString());
		}
		Student.college = "Đại học công nghệ";

		Student[] studentz = {student1,student2,student3};
		for(int i=0;i<studentz.length;i++){
			System.out.println(studentz[i].toString());
		}
	}
}
