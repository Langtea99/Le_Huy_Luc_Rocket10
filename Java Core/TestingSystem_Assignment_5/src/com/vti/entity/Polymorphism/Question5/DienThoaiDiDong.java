package com.vti.entity.Polymorphism.Question5;

public abstract class DienThoaiDiDong implements ITanCong{
	public void nghe() {
		System.out.println("Đang nghe...");
	}

	public void goi() {
		System.out.println("Đang gọi...");
	}

	public void guiTinNhan() {
		System.out.println("Đang gửi tin nhắn...");
	}

	public void nhanTinNhan() {
		System.out.println("Đã nhận tin nhắn...");
	}
}
