package com.vti.backend.Annotations;

import com.vti.entity.Annotations.Student;

public class Annotations {
	@SuppressWarnings("deprecation")
	public void question2() {
		Student student = new Student("Nguyễn Văn A");
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getIdV2());

	}
}
