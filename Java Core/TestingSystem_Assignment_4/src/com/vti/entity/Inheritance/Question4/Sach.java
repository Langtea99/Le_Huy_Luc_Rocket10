package com.vti.entity.Inheritance.Question4;

import java.util.Scanner;

public class Sach extends TaiLieu{
	private String tenTacGia;
	private int soTrang;
	
	public Sach(){
		
	}

	public String getTenTacGia() {
		return tenTacGia;
	}
	public Sach(String tenTacGia, int soTrang) {
		super();
		this.tenTacGia = tenTacGia;
		this.soTrang = soTrang;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public int getSoTrang() {
		return soTrang;
	}

	@Override
	public void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập tên tác giả: ");
		tenTacGia = scanner.nextLine();
		System.out.print("Nhập số trang: ");
		soTrang = scanner.nextInt();
	}
	
	@Override
	public void getInfor() {
		super.getInfor();
		System.out.print("Tên tác giả: " + tenTacGia);
		System.out.print("Số trang: " + soTrang);
	}
}
