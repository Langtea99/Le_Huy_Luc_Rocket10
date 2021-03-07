package com.vti.backend.Colection.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.vti.entity.Colection.List.Student;

public class List {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<Student> students;
	public List(){
		students = new ArrayList<>();
		students.add(new Student("Lực"));
		students.add(new Student("Trương"));
		students.add(new Student("Lực"));
		students.add(new Student("Lực"));
		students.add(new Student("Công"));
		students.add(new Student("Sơn"));

	}
	public void printStudent() {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	//a) In ra tổng số phần tử của students
	public void getAmountOfStudent() {
		System.out.println("Student Amount: " + students.size());
	}
	// b) Lấy phần tử thứ 4 của students
	public void getIndex4OfStudent(){
		System.out.println("Student thứ 4 :"+students.get(3));
	}
	// c) In ra phần tử đầu và phần tử cuối của students
	public void printFristAndLastStudent(){
		System.out.println("Student đầu :"+students.get(0));
		System.out.println("Student cuối :"+students.get(students.size()-1));
	}
	//d) Thêm 1 phần tử vào vị trí đầu của students
	public void addStudentIntoFistStudent(){
		students.add(0,new Student("Việt"));
		printStudent();
	}
	//e) Thêm 1 phần tử vào vị trí cuối của students
	public void addStudentIntoLastStudent(){
		students.add(students.size(),new Student("Kết"));
		printStudent();
	}
	//f) Đảo ngược vị trí của students
	public void reverseStudents() {
		// reverse students
		Collections.reverse(students);

		System.out.println("List students after reverse: ");
		printStudent();
	}
	//g) Tạo 1 method tìm kiếm student theo id
	public void findStudentById(){
		System.out.println("Nhập id cần tìm: ");
		int id = scanner.nextInt();
		for (Student student : students) {
			if(student.getId() == id){
				System.out.println(student);
			}
			}
		}
	//h) Tạo 1 method tìm kiếm student theo name
		public void findStudentByName(){
			System.out.println("Nhập name cần tìm: ");
			String name = scanner.next();
			for (Student student : students) {
				if(student.getName().equals(name)){
					System.out.println(student);
				}
			}
	}
	//i) Tạo 1 method để in ra các student có trùng tên
		public void findDuplicateStudent() {
			for (int i = 0; i < students.size(); i++) {
				for (int j = i + 1; j < students.size(); j++) {
					// So sánh tên của student
					if (students.get(i).getName().equals(students.get(j).getName())) {
						System.out.println("Các student trùng tên: ");
						System.out.println(students.get(i));
						System.out.println(students.get(j));
					}
				}
			}
		}
	//j) Xóa name của student có id = 2;
		public void deleteStudentById2(){
			for (Student student : students) {
				if(student.getId() == 2){
					student.setName(null);
				}
			}
			printStudent();
		}
	//k) Delete student có id = 5;
		public void deleteStudentById5(){
			for (Student student : students) {
				if(student.getId() == 5){
					students.remove(student);
				}
			}
			printStudent();
		}
	//l) Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies
		public void addAllStudentsToStudentCopies() {
			ArrayList<Student> studentCopies = new ArrayList<>();
			studentCopies.addAll(students);
		}

}
