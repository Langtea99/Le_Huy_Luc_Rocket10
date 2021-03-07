package com.vti.entity;

public class Accountz {
	protected String id;
	protected String name;
	protected int balance;
	public Accountz(String id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int credit(int amount) {
		return amount;
	}
	public int debit(int amount) {
		return amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void tranferTo(Accountz account, int amount) {
		System.out.println("Tranfer " + account + " to " + account.getName());
	}
}
