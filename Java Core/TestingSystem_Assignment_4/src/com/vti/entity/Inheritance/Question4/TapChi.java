package com.vti.entity.Inheritance.Question4;

import java.util.Scanner;

public class TapChi extends TaiLieu{
	private int soPhatHanh;
	private byte thangPhatHanh;
	
public TapChi(){
		
	}

	public int getSoPhatHanh() {
		return soPhatHanh;
	}

	public byte getThangPhatHanh() {
		return thangPhatHanh;
	}

	@Override
	public void input() {
		super.input();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số phát hành: ");
		soPhatHanh = scanner.nextInt();

		System.out.print("Nhập tháng phát hành: ");
		thangPhatHanh = scanner.nextByte();
	}
	public TapChi(int soPhatHanh, byte thangPhatHanh) {
		super();
		this.soPhatHanh = soPhatHanh;
		this.thangPhatHanh = thangPhatHanh;
	}

	public void setSoPhatHanh(int soPhatHanh) {
		this.soPhatHanh = soPhatHanh;
	}

	public void setThangPhatHanh(byte thangPhatHanh) {
		this.thangPhatHanh = thangPhatHanh;
	}

	@Override
	public void getInfor() {
		super.getInfor();

		System.out.println("Số phát hành: " + soPhatHanh);
		System.out.println("Tháng phát hành: " + thangPhatHanh);
	}
}
