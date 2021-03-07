package com.vti.entity.Abstraction;

public class News implements INews{
	private int id;
	private	String title;
	private String publishDate;
	private	String author;
	private	String content;
	private float averageRate;
	private int[] rates;

	
	public int[] getRates() {
		return rates;
	}
	public void setRates(int[] rates) {
		this.rates = rates;
	}
	public News(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getAverageRate() {
		return averageRate;
	}
	@Override
	public void Display() {
		// TODO Auto-generated method stub
		System.out.println("Title : "+title);
		System.out.println("PublishDate : "+publishDate);
		System.out.println("Author, : "+author);
		System.out.println("Content : "+content);
		System.out.println("AverageRate : "+averageRate);
	}
	@Override
	public float calculate() {
		// TODO Auto-generated method stub
		averageRate = (float) (rates[0] + rates[1] + rates[2]) / 3;
		return averageRate;
	}
	
}
