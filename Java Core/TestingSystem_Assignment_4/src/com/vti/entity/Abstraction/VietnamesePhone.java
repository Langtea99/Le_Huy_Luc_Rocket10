package com.vti.entity.Abstraction;

public class VietnamesePhone extends Phone{
	public VietnamesePhone() 
	{
		
	}
	@Override
	public void insertContact(String name, String phone) {
		// TODO Auto-generated method stub
		System.out.println("Insert new contact with " + name + " and phone " + phone);
	}

	@Override
	public void removeContact(String name) {
		// TODO Auto-generated method stub
		System.out.println("Removing contact with name :" + name);
	}

	@Override
	public void updateContact(String name, String newPhone) {
		// TODO Auto-generated method stub
		System.out.println("Update contact " + name + " with new phone " + newPhone);
	}

	@Override
	public void searchContact(String name) {
		// TODO Auto-generated method stub
		System.out.println("Search contact " + name );
	}

}
