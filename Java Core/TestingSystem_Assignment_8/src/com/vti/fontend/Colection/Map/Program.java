package com.vti.fontend.Colection.Map;

import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> students = new HashMap<>();
		students.put(1, "Lực");
		students.put(2, "Công");
		students.put(3, "Sơn");
		students.put(4, "Trương");
		students.put(5, "Kết");
		
		for (Map.Entry<Integer, String> entry : students.entrySet()) {
			System.out.println("ID: " + entry.getKey() + " , " + "Name: " + entry.getValue());
		}
	}

}
