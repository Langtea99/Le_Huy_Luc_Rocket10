package com.vti.entity;

public class Department {
	private int id;
	private String name;
	public Department(int int1, String string) {
		// TODO Auto-generated constructor stub
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
