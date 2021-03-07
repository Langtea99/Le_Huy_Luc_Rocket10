package com.vti.entity.Inheritance.Question3;

public class HighSchoolStudent extends Student{
	private String clazz;
	private String desiredUniversity;
	public HighSchoolStudent()
	{
		
	}

	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	@Override
	public String toString() {
		return "HighSchoolStudent{" + "id='" + super.getId() + '\'' + "name='" + super.getName() + '\'' + "clazz='"
				+ clazz + '\'' + ", desiredUniversity='" + desiredUniversity + '\'' + '}';
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDesiredUniversity() {
		return desiredUniversity;
	}

	public void setDesiredUniversity(String desiredUniversity) {
		this.desiredUniversity = desiredUniversity;
	}
}
