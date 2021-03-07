package com.vti.entity.Polymorphism.Question5;

public class DienThoaiThongMinh extends DienThoaiDiDong{
	public void suDung3G(){
		System.out.println("Sử dụng 3G ...");	
	}
	
	public void chupHinh(){
		System.out.println("Chụp hinh ...");	
	}
	
	@Override
	public void vuKhi() {
		System.out.println("Bay màu:v");
	}
}
