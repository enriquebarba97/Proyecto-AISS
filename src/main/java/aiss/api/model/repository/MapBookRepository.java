package aiss.api.model.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aiss.api.model.Book;
import aiss.api.model.Review;



public class MapBookRepository implements BookRepository {
	
	Map<String, Book> bookMap;
	Map<String, Review> reviewMap;
	private static MapBookRepository instance=null;
	private int index=0;
	
public static MapBookRepository getInstance() {
		
		if (instance==null) {
			instance = new MapBookRepository();
			instance.init();
		}
		
		return instance;
	}

public void init() {
	bookMap = new HashMap<String,Book>();
	reviewMap = new HashMap<String,Review>();
	
	//create Reviews
	Review review1 = new Review();
	review1.setTitle("Los pilares de la Tierra");
	review1.setAuthor("Ateav");
	review1.setReview_count(5);
	review1.setRelease_date(LocalDate.parse("2019-05-15"));
	review1.setCritic_review("A mi todo lo que escribe este hombre me apasiona. Para los amantes de la"+
	" historia es un regalo. Es cierto que es un topicazo y que todos sus libros siguen el mismo esquema"+
	" pero si funciona para que cambiarlo??");
	addReview(review1);
	
	Review review2 = new Review();
	review2.setTitle("Los pilares de la Tierra");
	review2.setAuthor("Eduardo Gamboa");
	review2.setReview_count(5);
	review2.setRelease_date(LocalDate.parse("2018-10-02"));
	review2.setCritic_review("El libro es una joya de la literatura, los personajes están tan bien diseñados"
			+ " que te encariñas con unos y odias a otros. La ambientación en la edad media es excelente y tiene"
			+ " un gran final. Recomendado para todo amante de los libros históricos y de fantasía."
			+ " De los mejores libros qué he leído.");
	addReview(review2);
	
	Review review3 = new Review();
	review3.setTitle("Los pilares de la Tierra");
	review3.setAuthor("Lla");
	review3.setReview_count(2);
	review3.setRelease_date(LocalDate.parse("2018-02-20"));
	review3.setCritic_review("Para mi gusto es un libro sobrevalorado. Me he aburrido leyéndolo."
			+ " Demasiada descripción y demasiadas páginas. No lo he disfrutado mucho, la verdad.");
	addReview(review3);
	
	Review review4 = new Review();
	review4.setTitle("LA LLAMADA DE CTHULHU");
	review4.setAuthor("Alexander");
	review4.setReview_count(5);
	review4.setRelease_date(LocalDate.parse("2018-07-16"));
	review4.setCritic_review("Me aterró, así de simple. En un principio no me causó miedo en sí; "
			+ "fue cuando decidí ponerme al 100% en el lugar del personaje cuando me apercibí del horror "
			+ "que se vislumbraba en cada palabra acerca del relato. La forma en que se desarrolla hace que "
			+ "en ningún momento llegue a tornarse pesada la lectura, y uno queda atrapado por no saber cómo "
			+ "terminará. Además, las frases relatadas son, desde mi punto de vista, tan profundas como exactas:"
			+ " \"Vivimos en una plácida isla de ignorancia rodeada de negros océanos de infinitud, y "
			+ "no hemos sido concebidos para viajar lejos.\"");
	addReview(review4);
	
	Review review5 = new Review();
	review5.setTitle("LA LLAMADA DE CTHULHU");
	review5.setAuthor("Salvador Morales León");
	review5.setReview_count(2);
	review5.setRelease_date(LocalDate.parse("2014-09-09"));
	review5.setCritic_review("Pues me esperaba otra cosa. Terror. Y eso no nos lo ofrece este libro. "
			+ "Es una narración interesante pero no llega a dar miedo ni nada por el estilo. "
			+ "Los que busquen pasar miedo mientras leen no lean este libro.");
	addReview(review5);
	
	Review review6 = new Review();
	review6.setTitle("LA LLAMADA DE CTHULHU");
	review6.setAuthor("Jorge");
	review6.setReview_count(5);
	review6.setRelease_date(LocalDate.parse("2013-11-28"));
	review6.setCritic_review("Una estupenda obra con muy buena prosa y un manejo del ritmo impresionante, "
			+ "Lovecraf trasciende el mundo tal y como lo conocemos para mostrarnos las más horribles y "
			+ "desalentadoras posibilidades que se le puedan plantear al hombre. Su terror no solo comprende"
			+ " el mismo relato, sino que ademas lleva al lector a una profunda reflexión sobre su posición en "
			+ "el mundo. Muy recomendable.");
	addReview(review6);
	
	
	//create Books
	Book lpdt = new Book();
	lpdt.setTitle("Los pilares de la Tierra");
	lpdt.setAuthor("Ken Follett");
	lpdt.setIsbn("9788401328510");
	lpdt.setRating(8);
	lpdt.setPrecio(24.90);
	addBook(lpdt);
	
	Book lldc = new Book();
	lldc.setTitle("LA LLAMADA DE CTHULHU");
	lldc.setAuthor("H.P. Lovecraft");
	lldc.setIsbn("9788492837397");
	lldc.setRating(8);
	lldc.setPrecio(9.00);
	addBook(lldc);
	
	//add reviews to books
	addReview(lpdt.getIsbn(),review1.getId());
	addReview(lpdt.getIsbn(),review2.getId());
	addReview(lpdt.getIsbn(),review3.getId());
	
	addReview(lldc.getIsbn(),review4.getId());
	addReview(lldc.getIsbn(),review5.getId());
	addReview(lldc.getIsbn(),review5.getId());
	
}
	
	//Operaciones relacionadas con Reviews
	public void addReview(Review r) {
		String id = "r" + index++;
		r.setId(id);
		r.setRelease_date(LocalDate.now());
		reviewMap.put(id, r);
	}

	
	public Collection<Review> getAllReviews() {
		
		return reviewMap.values();
	}

	
	public Review getReview(String id) {
		
		return reviewMap.get(id);
	}

	@Override
	public void updateReview(Review r) {
		Review review = reviewMap.get(r.getId());
		if(r.getTitle()!=null)
			review.setTitle(r.getTitle());
		if(r.getSub_title()!=null)
			review.setSub_title(r.getSub_title());
		if(r.getAuthor()!=null)
			review.setAuthor(r.getAuthor());
		if(r.getReview_count()!=null)
			review.setReview_count(r.getReview_count());
		if(r.getGenre()!=null)
			review.setGenre(r.getGenre());
		if(r.getCritic_review()!=null)
			review.setCritic_review(r.getCritic_review());	
		review.setUpdate_date(LocalDate.now());
	}


	public void deleteReview(String id) {
		reviewMap.remove(id);
	}

	//Operaciones relacionadas con Books
	
	@Override
	public void addBook(Book b) {
		bookMap.put(b.getIsbn(), b);
		}

	@Override
	public Collection<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookMap.values();
	}

	@Override
	public Book getBook(String isbn) {
		// TODO Auto-generated method stub
		return bookMap.get(isbn);
	}
	
	public Collection<Book> getBooksAuthor(String author) {
		List<Book> lista = new ArrayList<>();
		Collection<Book> mapLibros = bookMap.values();
		for(Book b:mapLibros) {
			if(b.getAuthor().equals(author)) {
				lista.add(b);
			}
		}
		return lista ;
	}

	@Override
	public void updateBook(Book b) {
		// TODO Auto-generated method stub
		bookMap.put(b.getIsbn(), b);

	}

	@Override
	public void deleteBook(String isbn) {
		// TODO Auto-generated method stub
		bookMap.remove(isbn);
	}
	
	public void deleteBooksPerAuthor(String author) {
		Collection<Book> mapLibros = bookMap.values();
		for(Book b:mapLibros) {
			if(b.getAuthor().equals(author)) {
				mapLibros.remove(b);
			}
		}
	}

	@Override
	public Collection<Review> getAll() {
		// TODO Auto-generated method stub
		return reviewMap.values();
	}
	
	public Collection<Review>getReviewsPerTitle(String title){
		List<Review> lista = new ArrayList<>();
		Collection<Book> mapLibros = bookMap.values();
		for(Book b:mapLibros) {
			if(b.getTitle().equals(title)) {
				lista = b.getReviews();
			}
		}
		
		return lista;
	}

	@Override
	public void addReview(String isbn, String id) {
		// TODO Auto-generated method stub
		Book b = getBook(isbn);
		b.addReview(reviewMap.get(id));
		
	}

	@Override
	public void removeReview(String isbn, String author) {
		// TODO Auto-generated method stub
		getBook(isbn).deleteReview(author);
	}

}
