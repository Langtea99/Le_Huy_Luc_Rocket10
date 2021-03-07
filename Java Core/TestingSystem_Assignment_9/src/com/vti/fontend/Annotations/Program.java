package com.vti.fontend.Annotations;

import java.util.Date;

import com.vti.backend.Annotations.Annotations;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Annotations annotations = new Annotations();
		question1();
		
		annotations.question2();
	}

	private static void question1() {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		Date date = new Date(2020, 4, 29);
		System.out.println(date);
	}

}
