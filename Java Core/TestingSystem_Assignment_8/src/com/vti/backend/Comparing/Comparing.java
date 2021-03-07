package com.vti.backend.Comparing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vti.entity.Comparing.Student;

public class Comparing {
	private List<Student> students;

	public Comparing() {
		students = new ArrayList<>();
		inputStudents();
	}

	private void inputStudents() {
		// TODO Auto-generated method stub
		students.add(new Student("Lực", LocalDate.parse("2020-05-29"), 8));
		students.add(new Student("Công", LocalDate.parse("2020-05-29"), 10));
		students.add(new Student("Sơn", LocalDate.parse("2015-05-04"), 6));
		students.add(new Student("Trương", LocalDate.parse("2020-01-29"), 5));
		students.add(new Student("Kết", LocalDate.parse("2020-04-29"), 8));

		System.out.println("List student vừa khởi tạo: ");
		printStudent();

	}
	private void printStudent() {
		for (Student student : students) {
			System.out.println(student);
		}
	}
//	Question 1: Comparable 
//	In ra học sinh sắp xếp theo name
	public void question1() {
		Collections.sort(students);

		System.out.println("List sau khi sắp xếp theo name: ");
		printStudent();
	}

}
