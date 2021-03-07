package com.vti.backend.Generic;

import com.vti.entity.Generic.Employee;
import com.vti.entity.Generic.Phone;
import com.vti.entity.Generic.Staff;
import com.vti.entity.Generic.Student;

public class Generic {
	
	public void question1_2(){
	Student<Integer> student1 = new Student<Integer>(1, "Lặng");
	Student<Float> student2 = new Student<Float>(2.0f, "Bốc họ");
	Student<Double> student3 = new Student<Double>(3.0, "Dubai");
	
	print(student1);
	print(student2);
	print(student3);
	
	// print number
	print(1);
	print(2f);
	print(3d);
	}
	
	public void question4() {
		Integer[] arrInt = { 5, 10, 15 };
		Float[] arrFloat = { 6f, 5f, 15f };
		Double[] arrDouble = { 5.2, 2.6, 6.9 };
		Long[] arrLong = {5l,6l,8l};
		
		printArray(arrInt);
		printArray(arrFloat);
		printArray(arrDouble);
		printArray(arrLong);
	}
	
	public void question5(){
		// khởi tạo employee có salaries datatype là int
		Integer[] salaryEmployee1 = {1000,2000,3000};
		Employee<Integer> employee1 = new Employee<Integer>(1, "Lực", salaryEmployee1);
		System.out.println("Employee vừa khởi tạo: ");
		print(employee1);
		System.out.println("Tháng lương cuối cùng của employee 1: " + salaryEmployee1[salaryEmployee1.length - 1]);

		// khởi tạo employee có salaries datatype là Float
		Float[] salaryEmployee2 = { 1000f, 2000f,  3000f };
		Employee<Float> employee2 = new Employee<Float>(1, "Công", salaryEmployee2);

		System.out.println("Employee vừa khởi tạo: ");
		print(employee2);
		System.out.println("Tháng lương cuối cùng của employee 2: " + salaryEmployee2[salaryEmployee2.length - 1]);

		// khởi tạo employee có salaries datatype là double
		Double[] salaryEmployee3 = { 1000d, 2000d,3000d};
		Employee<Double> employee3 = new Employee<Double>(1, "Trương", salaryEmployee3);

		System.out.println("Employee vừa khởi tạo: ");
		print(employee3);
		System.out.println("Tháng lương cuối cùng của employee1: " + salaryEmployee3[salaryEmployee3.length - 1]);
	}
	
	public void question7() {
		// <email, phone number>
		Phone<String, String> email = new Phone<String, String>("nhoksok99@gmail.com", "0342744550");
		System.out.println("Email: " + email.getKey() + " / " + "Phone Number: " + email.getPhoneNumber());

		// <id, phone number>
		Phone<Integer, String> id = new Phone<Integer, String>(1, "0342744550");
		System.out.println("id: " + id.getKey() + " / " + "Phone Number: " + id.getPhoneNumber());

		// <name, phone number>
		Phone<String, String> name = new Phone<String, String>("Lực", "0342744550");
		System.out.println("Name: " + name.getKey() + " / " + "Phone Number: " + name.getPhoneNumber());
	}

	public void question8() {
		// Integer
		Staff<Integer,String> staff1 = new Staff<Integer,String>(1, "Nguyễn Văn A");
		System.out.println("ID: " + staff1.getId() + " / " + "Name: " + staff1.getName());

		// Float
		Staff<Float,String> staff2 = new Staff<Float,String>(1.5f, "Nguyễn Văn A");
		System.out.println("ID: " + staff2.getId() + " / " + "Name: " + staff2.getName());
	}


	private <T> void print(T a) {
		System.out.println(a);
	}

	private <T> void printArray(T[] arr) {
		for (T x : arr) {
			System.out.println(x);
		}
	}

}
