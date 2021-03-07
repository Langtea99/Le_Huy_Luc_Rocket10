package com.vti.fontend.InnerClass;

import com.vti.backend.InnerClass.InnerClass;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerClass innerClass = new InnerClass();

		innerClass.question1();
		innerClass.question2();
		
		//Question3:
		//+Output: Đây là inner class
		//+Output: Đây là inner class ( OuterClass.InnerClass innerClass = outerClass.new InnerClass();)
		//+Output: Ngày : 31/10/2017 
		//         Giờ  : 10/15/30    (NgayThangNam.GioPhutGiay time = date.new GioPhutGiay();)
	}

}
