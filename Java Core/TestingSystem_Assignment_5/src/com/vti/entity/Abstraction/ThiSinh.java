package com.vti.entity.Abstraction;

import java.util.Scanner;

public class ThiSinh {
	private int soBaoDanh;
	private String hoTen;
	private String diaChi;
	private int doUuTien;
	private Khoi khoi;
	
	public int getSoBaoDanh() {
		return soBaoDanh;
	}

	public void setSoBaoDanh(int soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getDoUuTien() {
		return doUuTien;
	}

	public void setDoUuTien(int doUuTien) {
		this.doUuTien = doUuTien;
	}

	public Khoi getKhoi() {
		return khoi;
	}

	public void setKhoi(Khoi khoi) {
		this.khoi = khoi;
	}

	public void nhap() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số báo danh: ");
		soBaoDanh = scanner.nextInt();

		System.out.print("Nhập họ tên: ");
		hoTen = scanner.next();

		System.out.print("Nhập địa chỉ: ");
		diaChi = scanner.next();

		System.out.print("Nhập mức ưu tiên: ");
		doUuTien = scanner.nextByte();

		System.out.print("Nhập khối (A/B/C) :");
		khoi = new Khoi();
		khoi.setTen(scanner.next());
	}

	@Override
	public String toString() {
		return "Thi Sinh{" + "So bao danh :" + soBaoDanh + ", Ho ten :" + hoTen +  ", Dia Chi :" + diaChi + ", Do uu tien :" + doUuTien + ", Khoi :" + khoi.getMonThi() + "}";
	}
}
