package aiss.api.model;

import java.time.LocalDate;

public class Review {
	
	private String id;
	private String title;
	private String sub_title;
	private String author;
	private Integer review_count;
	private String genre;
	private LocalDate release_date;
	private String critic_review;
	
	public Review(){
		
	}
	
	
	public Review(String title, String author, String genre, LocalDate release_date, String critic_review) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.release_date = release_date;
		this.critic_review = critic_review;
	}



	public Review(String id,String title, String sub_title, String author, Integer review_count, String genre,
			LocalDate release_date, String critic_review) {
		super();
		this.id = id;
		this.title = title;
		this.sub_title = sub_title;
		this.author = author;
		this.review_count = review_count;
		this.genre = genre;
		this.release_date = release_date;
		this.critic_review = critic_review;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		 this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getReview_count() {
		return review_count;
	}
	public void setReview_count(Integer review_count) {
		this.review_count = review_count;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public LocalDate getRelease_date() {
		return release_date;
	}
	public void setRelease_date(LocalDate release_date) {
		this.release_date = release_date;
	}
	public String getCritic_review() {
		return critic_review;
	}
	public void setCritic_review(String critic_review) {
		this.critic_review = critic_review;
	}
	
	
}
