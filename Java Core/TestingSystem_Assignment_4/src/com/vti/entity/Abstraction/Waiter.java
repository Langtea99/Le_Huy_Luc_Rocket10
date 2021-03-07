package com.vti.entity.Abstraction;

public class Waiter extends User{

	public Waiter(String name, double salaryRatio) {
		super(name, salaryRatio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculatePay() {
		// TODO Auto-generated method stub
		return salaryRatio * 220;
	}

}
