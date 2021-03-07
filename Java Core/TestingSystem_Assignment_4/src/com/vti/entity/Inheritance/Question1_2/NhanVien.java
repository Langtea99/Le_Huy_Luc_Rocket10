package com.vti.entity.Inheritance.Question1_2;

import java.util.Scanner;

public class NhanVien extends CanBo{
	private String congViec;

	public String getCongViec() {
		return congViec;
	}

	@Override
	public void input() {
		super.input();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập công việc: ");
		congViec = scanner.nextLine();
	}

	@Override
	public void getInfor() {
		super.getInfor();
		System.out.println("Công việc  : " + getCongViec());
	}
}
