package com.vti.entity.Polymorphism.Question5;

public class DienThoaiCoDien extends DienThoaiDiDong{
	public void ngheRadio(){
		System.out.println("Nghe Đài radio...");	
	}
	
	@Override
	public void vuKhi() {
		System.out.println("Cục gạch thần chưởng :v");
	}
}
