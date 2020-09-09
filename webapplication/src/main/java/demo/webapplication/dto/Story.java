package demo.webapplication.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true)
	@Size(min = 5, max = 100, message = "Min 5 characters and Max 100 characters")
	private String title;

	@Column(nullable = false)
	@Lob
	@Size(min = 20, max = 10000, message = "Min 20 characters and Max 100 characters")
	private String content;

	@ManyToOne
	private Customer customer;

	public Story() {
		super();
	}

	public Story(Integer id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public Story(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

}
