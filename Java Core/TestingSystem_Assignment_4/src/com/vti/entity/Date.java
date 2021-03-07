package com.vti.entity;

public class Date {
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
@Override
	public String toString() {
		return "Date{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
	}

	public boolean isLeapYear() {
		return getYear() % 100 == 0 && getYear() % 400 == 0 ? true : false;
	}
}
