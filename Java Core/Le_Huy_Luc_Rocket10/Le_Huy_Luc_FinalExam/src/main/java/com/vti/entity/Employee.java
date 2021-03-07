package com.vti.entity;

public class Employee extends User {

	private String ProSkill;
	private Project projectId;

	public Employee(int id, String fullName, String email, String password, String ProSkill, Project projectId) {
		super(id, fullName, email, password, Position.EMPLOYEE);
		this.ProSkill = ProSkill;
		this.projectId = projectId;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	@Override
	public String toString() {
		return "Employee [ProSkill=" + ProSkill + ", getId()=" + getId() + ", getFullName()=" + getFullName()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getRole()=" + getPosition()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
