package com.vti.backend.Comparing;

import java.util.Comparator;

import com.vti.entity.Comparing.Student;

public class SortBy implements Comparator<Student>{
	//
	@Override
	public int compare(Student student1, Student student2) {
		int value = 0;
		if((student1.getName() == student2.getName())&&(student1.getBirthDay() != student2.getBirthDay())){
			value = -1;
		}else if((student1.getName() == student2.getName())&&(student1.getBirthDay() == student2.getBirthDay())){
			value = 1;
		}else if(student1.getName() != student2.getName()){
			value =0;
		}
		return value;
	}
//	@Override
//	public int compare(Student student1, Student student2){
//		int value = 0;
//		if(student1.getName().compareTo(student2.getName())!=0){
//			value = student1.getName().compareTo(student2.getName());
//		}
//		return value;
//	}

}
