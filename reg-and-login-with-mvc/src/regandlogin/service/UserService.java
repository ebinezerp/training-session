package regandlogin.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import regandlogin.dto.User;
import regandlogin.util.HibernateConfig;

public class UserService {

	/*
	 * private Connection con;
	 * 
	 * public UserService() throws SQLException { con = new
	 * DBConnection().getConnection(); }
	 */

	private SessionFactory sessionFactory;

	public UserService() {
		this.sessionFactory = new HibernateConfig().getSessionFactory();
	}

	public boolean saveUser(User user) {

		/*
		 * try { PreparedStatement ps = con.
		 * prepareStatement("insert into user(firstname,username,password) values(?,?,?)"
		 * );
		 * 
		 * ps.setString(1, user.getFirstname()); ps.setString(2, user.getUsername());
		 * ps.setString(3, user.getPassword());
		 * 
		 * int count = ps.executeUpdate();
		 * 
		 * if (count > 0) { return true; } else { return false; } } catch (SQLException
		 * e) { e.printStackTrace(); return false; }
		 */

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			session.save(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return false;
		} finally {
			session.clear();
			session.close();
		}

	}

	public User login(String username, String password) {

		/*
		 * try { PreparedStatement ps =
		 * con.prepareStatement("select * from user where username=? and password = ?");
		 * ps.setString(1, username); ps.setString(2, password); ResultSet rs =
		 * ps.executeQuery(); if (rs.next()) {
		 * 
		 * User user = new User(); user.setUserId(rs.getInt("userId"));
		 * user.setFirstname(rs.getString("firstname"));
		 * user.setUsername(rs.getString("username"));
		 * user.setPassword(rs.getString("password"));
		 * 
		 * return user;
		 * 
		 * } else { return null; }
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); return null; }
		 */

		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("From User where username=: un and password =: pass", User.class)
					.setParameter("un", username).setParameter("pass", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.clear();
			session.close();
		}

	}

	public void getUser() {

	}

}
