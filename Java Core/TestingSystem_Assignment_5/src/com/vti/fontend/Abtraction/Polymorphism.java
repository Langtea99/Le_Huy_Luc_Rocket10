package com.vti.fontend.Abtraction;

import java.util.Scanner;

import com.vti.backend.Polymorphism.ChuVi_DienTich;
import com.vti.backend.Polymorphism.PersonManagement;
import com.vti.backend.Polymorphism.StudentManagement;
import com.vti.entity.Polymorphism.Question4.MyMath;

public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Q1
		StudentManagement studentManagement = new StudentManagement();

		studentManagement.initStudents();
		studentManagement.caLopDiemDanh();
		studentManagement.nhomDiHocBai();
		studentManagement.nhomDiDonVeSinh();
		
		//Q2
		Scanner scanner = new Scanner(System.in);
		PersonManagement personManagement = new PersonManagement();

		int choose;
		do {
			loadMenu();
			choose = scanner.nextInt();

			switch (choose) {
			case 1:
				personManagement.input();
				break;

			case 2:
				personManagement.showInforStudents();
				break;

			case 3:
				personManagement.xetHocBong();
				break;

			case 4:
				break;

			default:
				System.out.println("Nhập sai, vui lòng nhập lại !");
				break;
			}

		} while (choose != 4);
		//Q3
		ChuVi_DienTich chuVi_dienTich = new ChuVi_DienTich();
		chuVi_dienTich.question3();
		
		//Q4
		MyMath myMath = new MyMath();
		myMath.sum(4,5);
	}	
	private static void loadMenu() {
		System.out.println("==========MENU=========");
		System.out.println("=||1. Nhập student  ||=");
		System.out.println("=||2. Hiện student  ||=");
		System.out.println("=||3. Xét học bổng  ||=");
		System.out.println("=||4. Thoát         ||=");
		System.out.println("=======================");
	}
}

