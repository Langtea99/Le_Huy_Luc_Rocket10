package com.vti.entity.Inheritance.Question4;

import java.util.Scanner;

public class TaiLieu {
	private static int counter = 1000;
	private int maTaiLieu;
	private String tenNXB;
	private int soBanPhatHanh;

	public TaiLieu() {
		maTaiLieu = ++counter;
	}

	public TaiLieu(int maTaiLieu, String tenNXB, int soBanPhatHanh) {
		super();
		this.maTaiLieu = maTaiLieu;
		this.tenNXB = tenNXB;
		this.soBanPhatHanh = soBanPhatHanh;
	}

	public int getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(int maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getTenNXB() {
		return tenNXB;
	}

	public void setTenNXB(String tenNXB) {
		this.tenNXB = tenNXB;
	}

	public int getSoBanPhatHanh() {
		return soBanPhatHanh;
	}

	public void setSoBanPhatHanh(int soBanPhatHanh) {
		this.soBanPhatHanh = soBanPhatHanh;
	}
	public void input() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Mã tài liệu: " + maTaiLieu);
		
		System.out.print("Nhập tên NXB: ");
		tenNXB = scanner.nextLine();

		System.out.print("Nhập số bản phán hành: ");
		soBanPhatHanh = scanner.nextInt();
	}

	public void getInfor() {
		System.out.println("Mã tài liệu: " + maTaiLieu);
		System.out.println("Tên NXB: " + tenNXB);
		System.out.println("Số bản phán hành: " + soBanPhatHanh);
	}
}
