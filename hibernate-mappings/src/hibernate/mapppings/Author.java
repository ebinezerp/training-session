package hibernate.mapppings;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String specialization;

	@ManyToMany
	private List<Book> bookList;

	public Author() {
		super();
	}

	public Author(Integer id, String name, String specialization, List<Book> bookList) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.bookList = bookList;
	}

	public Author(String name, String specialization, List<Book> bookList) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.bookList = bookList;
	}

	public Author(String name, String specialization) {
		super();
		this.name = name;
		this.specialization = specialization;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

}
