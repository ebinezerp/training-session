package regandlogin.dto;

public class User {
	private Integer userId;
	private String firstname;
	private String username;
	private String password;

	public User() {
		super();
	}

	public User(Integer userId, String firstname, String username, String password) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.username = username;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstname=" + firstname + ", username=" + username + ", password="
				+ password + "]";
	}

}
