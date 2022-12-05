package com.healthcare.dto;

public class FeedbackEntity {
	
	private int id;
	
	private String Name;
	
	private String review;

	public FeedbackEntity() {
		
	}

	public FeedbackEntity(String name, String review) {
		super();
		Name = name;
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "FeedbackEntity [id=" + id + ", Name=" + Name + ", review=" + review + "]";
	}
	
	

}
