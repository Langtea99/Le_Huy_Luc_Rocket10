package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Inheritance.HighSchoolStudents;
import com.vti.backend.Inheritance.QLCB;
import com.vti.backend.Inheritance.QLTV;

public class InheritanceProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			question2();
//			question4();	
			HighSchoolStudents highSchoolStudents = new HighSchoolStudents();
			highSchoolStudents.question3();
		}
		private static void menuQuesion2() {
			System.out.println("=======MENU==========");
			System.out.println("==  1. Thêm cán bộ ==");
			System.out.println("==  2. Hiện cán bộ ==");
			System.out.println("==  3. Tìm cán bộ  ==");
			System.out.println("==  4. Xóa cán bộ  ==");
			System.out.println("==  0. Thoát       ==");
			System.out.println("=====================");
		}

		public static void question2() {
			QLCB qlcb = new QLCB();
			byte choose;
			do {
				menuQuesion2();
				Scanner scanner = new Scanner(System.in);
				System.out.print("Nhap lua chon cua ban :");
				choose= scanner.nextByte();

				switch (choose) {
				case 1:
					qlcb.addCanBo();
					break;
				case 2:
					qlcb.printInforCanBo();
					break;
				case 3:
					qlcb.findCanBo();
					break;
				case 4:
					qlcb.deleteCanBo();
					break;
				case 0:
					break;
				default:
					System.out.println("Nhập sai ! Nhập lại !");
					break;
				}
			} while (choose != 0);
		}
		private static void menuQuestion4() {
			System.out.println("=======MENU==========");
			System.out.println("==  1. Thêm tài liệu ==");
			System.out.println("==  2. Hiện tài liệu ==");
			System.out.println("==  3. Tìm tài liệu  ==");
			System.out.println("==  4. Xóa tài liệu  ==");
			System.out.println("==  0. Thoát         ==");
			System.out.println("=====================");
		}

		public static void question4() {
			QLTV qltv = new QLTV();

			byte choose;
			do {
				menuQuestion4();
				Scanner scanner = new Scanner(System.in);

				choose = scanner.nextByte();
				switch (choose) {
				case 1:
					qltv.inputTaiLieu();
					break;
				case 2:
					qltv.printTaiLieu();
					break;
				case 3:
					qltv.findTaiLieu();
					break;
				case 4:
					qltv.deleteTaiLieu();
					break;
				case 0:
					break;
				default:
					System.out.println("Nhập sai ! Nhập lại !");
					break;
				}
			} while (choose != 0);
		}
}
