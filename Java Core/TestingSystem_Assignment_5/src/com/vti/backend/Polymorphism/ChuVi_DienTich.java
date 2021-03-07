package com.vti.backend.Polymorphism;

import com.vti.entity.Polymorphism.Question3.HinhChuNhat;
import com.vti.entity.Polymorphism.Question3.HinhVuong;

public class ChuVi_DienTich {
	public void question3(){
		HinhChuNhat hinhChuNhat = new HinhChuNhat();
		HinhVuong hinhVuong = new HinhVuong();
		System.out.println("Tính chu vi theo hình chữ nhật : " + hinhChuNhat.tinhChuVi(4,8));
		System.out.println("Tính diện tích theo hình chữ nhật : " + hinhChuNhat.tinhDienTich(4,8));
		System.out.println("Tính chu vi theo hình vuông : " + hinhVuong.tinhChuVi(5,5));
		System.out.println("Tính chu vi theo hình chữ nhật : " + hinhVuong.tinhDienTich(5,5));
	}
}
