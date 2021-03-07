package com.vti.entity;

public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
	}

	public double getRadius() {
		return radius;
	}

	public Circle(double radius, String color) {
		super();
		this.radius = radius;
		this.color = color;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Circle{" + "radius=" + radius + ", color='" + color + '\'' + '}';
	}
}
