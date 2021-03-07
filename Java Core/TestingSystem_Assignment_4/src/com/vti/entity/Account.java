package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	private Position position;
	private Department department;
	private LocalDate createDate;
	private Group[] groups;

	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	public Account(){
		
	}
	
	public Account(int id,String email,String userName,String fisrtName,String lastName){
		this.id =id;
		this.email = email;
		this.userName = userName;
		this.fullName = fisrtName + " " + lastName;
	}
	public Account(int id,String email,String userName,String fisrtName,String lastName,Position position){
		this.id =id;
		this.email = email;
		this.userName = userName;
		this.fullName = fisrtName + " " + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}
	public Account(int id,String email,String userName,String fisrtName,String lastName,Position position,LocalDate createDate){
		this.id =id;
		this.email = email;
		this.userName = userName;
		this.fullName = fisrtName + " " + lastName;
		this.position = position;
		this.createDate = createDate;
	}
	public Account(String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", email='" + email + '\'' + ", username='" + userName + '\'' + ", fullname='"
				+ fullName + '\'' + ", department=" + department+ ", position=" + position + ", createDate="
				+ createDate  + '}';
	}

}
