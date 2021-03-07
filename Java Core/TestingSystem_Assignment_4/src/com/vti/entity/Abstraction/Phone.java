package com.vti.entity.Abstraction;

public abstract class Phone {
	private String[] contacts;
	private String phone;
	private String name;
	
	public Phone(){
		
	}
	public String[] getContacts() {
		return contacts;
	}
	public void setContacts(String[] contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public abstract void insertContact(String name, String phone);
	public abstract void removeContact(String name);
	public abstract void updateContact(String name, String newPhone);
	public abstract void searchContact(String name);
	
	public Phone(String[] contacts, String phone, String name) {
		super();
		this.contacts = contacts;
		this.phone = phone;
		this.name = name;
	}
}
