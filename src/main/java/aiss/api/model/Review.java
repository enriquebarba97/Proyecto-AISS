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
	private LocalDate update_date;
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
	public LocalDate getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(LocalDate update_date) {
		this.update_date = update_date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((critic_review == null) ? 0 : critic_review.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((review_count == null) ? 0 : review_count.hashCode());
		result = prime * result + ((sub_title == null) ? 0 : sub_title.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (critic_review == null) {
			if (other.critic_review != null)
				return false;
		} else if (!critic_review.equals(other.critic_review))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (review_count == null) {
			if (other.review_count != null)
				return false;
		} else if (!review_count.equals(other.review_count))
			return false;
		if (sub_title == null) {
			if (other.sub_title != null)
				return false;
		} else if (!sub_title.equals(other.sub_title))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
