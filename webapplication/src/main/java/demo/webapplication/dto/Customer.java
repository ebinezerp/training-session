package demo.webapplication.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Enter fullname")
	@Pattern(regexp = "[a-z ]{4,}", message = "only alphabet, min 4 characters")
	private String fullname;
	@NotEmpty
	@Email(message = "Enter valid email address")
	private String email;
	@NotEmpty
	@Pattern(regexp = "[6-9][0-9]{9}", message = "Enter valid Mobile")
	private String mobile;
	@NotEmpty
	@Pattern(regexp = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})", message = "atleast 1 small alphabet,1 capital alphabet,1 special character. Min 8 character, Max 40 characters")
	private String password;
	
	@OneToMany(mappedBy = "customer")
	private List<Story> stories;

	public Customer() {
		super();
	}

	public Customer(Integer id, String fullname, String email, String mobile, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Customer(String fullname, String email, String mobile, String password) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullname=" + fullname + ", email=" + email + ", mobile=" + mobile
				+ ", password=" + password + "]";
	}

}
