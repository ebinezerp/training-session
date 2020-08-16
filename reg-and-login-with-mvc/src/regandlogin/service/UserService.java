package regandlogin.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import regandlogin.dto.User;
import regandlogin.util.DBConnection;

public class UserService {

	private Connection con;

	public UserService() throws SQLException {
		con = new DBConnection().getConnection();
	}

	public boolean saveUser(User user) {

		try {
			PreparedStatement ps = con.prepareStatement("insert into user(firstname,username,password) values(?,?,?)");

			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());

			int count = ps.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public User login(String username, String password) {

		try {
			PreparedStatement ps = con.prepareStatement("select * from user where username=? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setFirstname(rs.getString("firstname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				return user;

			} else {
				return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void getUser() {

	}

}