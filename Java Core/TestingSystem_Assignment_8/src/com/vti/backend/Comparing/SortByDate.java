package com.vti.backend.Comparing;

import java.util.Comparator;

import com.vti.entity.Comparing.Student;

public class SortByDate implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		int value = 0;
		if(student1.getBirthDay().compareTo(student2.getBirthDay())!=0){
			value = student1.getBirthDay().compareTo(student2.getBirthDay());
		}
		return value;
	}
}
