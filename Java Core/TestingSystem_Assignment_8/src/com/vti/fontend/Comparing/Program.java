package com.vti.fontend.Comparing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vti.backend.Comparing.Comparing;
import com.vti.backend.Comparing.SortBy;
import com.vti.backend.Comparing.SortByDate;
import com.vti.entity.Comparing.Student;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
//		List<Student> students = new ArrayList<>();
//		students.add(new Student("Lực", LocalDate.parse("2020-05-29"), 8));
//		students.add(new Student("Công", LocalDate.parse("2020-05-29"), 10));
//		students.add(new Student("Lực", LocalDate.parse("2015-05-04"), 6));
//		students.add(new Student("Trương", LocalDate.parse("2020-01-29"), 5));
//		students.add(new Student("Kết", LocalDate.parse("2020-04-29"), 8));
		
		Comparing comparing = new Comparing();
		comparing.question1();
		
//		Comparator sortBy = new SortBy();
//		Comparator sortByDate = new SortByDate();
//		Collections.sort(students, sortBy.thenComparing(sortByDate));
//		
//		for(Student student : students){
//			System.out.println(student);
//		}
	}

}
