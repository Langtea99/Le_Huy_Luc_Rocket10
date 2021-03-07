package com.vti.entity;

public class Manager extends User {

	private int ExpInYear;

	public Manager(int id, String fullName, String email, String password, int ExpInYear) {
		super(id, fullName, email, password, Position.MANAGER);
		this.ExpInYear = ExpInYear;
	}

	public int getExpInYear() {
		return ExpInYear;
	}

	@Override
	public String toString() {
		return "Admin [ExpInYear=" + ExpInYear + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getRole()=" + getPosition()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
