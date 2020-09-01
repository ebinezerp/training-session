package hibernate.mapppings;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Float price;

	@ManyToMany(mappedBy = "bookList", cascade = CascadeType.ALL)
	private List<Author> authors;

	public Book() {
		super();
	}

	public Book(Integer id, String name, Float price, List<Author> authors) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.authors = authors;
	}

	public Book(String name, Float price, List<Author> authors) {
		super();
		this.name = name;
		this.price = price;
		this.authors = authors;
	}

	public Book(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

}
