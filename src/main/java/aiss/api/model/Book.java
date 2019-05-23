package aiss.api.model;

import java.util.ArrayList;
import java.util.List;



public class Book {
	private String title;
	private String author;
	private String isbn;
	private Integer rating;
	private Double precio;
	private List<Review> reviews;
	
	public Book() {
		
	}

	public Book(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Book(String title, String author, String isbn, Integer rating, Double precio, List<Review> reviews) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.rating = rating;
		this.precio = precio;
		this.reviews = reviews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review getReview(String id) {
		if (reviews==null)
			return null;
		
		Review review = null;
		for(Review r:reviews) {
			if(r.getId().equals(id)) {
				review=r;
				break;
			}
		}
		return review;
	}
	
	public void addReview(Review r) {
		if(reviews==null) {
			reviews = new ArrayList<Review>();
		}
		reviews.add(r);
	}

	public void deleteReview(Review r) {
		reviews.remove(r);
	}
	
	public void deleteReview(String id) {
		Review review = getReview(id);
		if(review!=null) {
			reviews.remove(review);
		}	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((reviews == null) ? 0 : reviews.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (reviews == null) {
			if (other.reviews != null)
				return false;
		} else if (!reviews.equals(other.reviews))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
