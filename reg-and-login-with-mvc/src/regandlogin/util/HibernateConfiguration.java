package regandlogin.util;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import regandlogin.dto.User;

public class HibernateConfiguration {

	public static void main(String[] args) {

		Configuration config = new Configuration();
		/* config.configure(); */
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/appdemo");
		properties.setProperty("hibernate.connection.user", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		
		
		
		config.setProperties(properties);
		config.addAnnotatedClass(User.class);
		
		
		
		SessionFactory sessionFactory = config.buildSessionFactory();

		// session factory provides session to execute commands with in a session

		User user = new User();
		user.setFirstname("sanjay");
		user.setUsername("sanjay@123");
		user.setPassword("12345");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		/*
		 * Session session = sessionFactory.openSession(); User user =
		 * session.get(User.class, 2);
		 * 
		 * System.out.println(user);
		 */

		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * Query query =
		 * session.createQuery("From User where username=:un and password=:pass");
		 * //query.setParameter("un", "kumar@123"); query.setParameter("un",
		 * "kumar@123"); query.setParameter("pass", "12345"); Object obj=
		 * query.getSingleResult(); User user = (User)obj; System.out.println(user);
		 */

		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * Query<User> query =
		 * session.createQuery("From User where username=:un and password=:pass",
		 * User.class); // query.setParameter("un", "kumar@123");
		 * query.setParameter("un", "kumar@123"); query.setParameter("pass", "12345");
		 * User user = query.getSingleResult(); System.out.println(user);
		 */

		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * User user =
		 * session.createQuery("From User where username=:un and password=:pass",
		 * User.class) .setParameter("un", "kumar@123").setParameter("pass",
		 * "12345").getSingleResult();
		 * 
		 * user.setPassword("7890");
		 * 
		 * Transaction tx = session.beginTransaction(); try { session.update(user);
		 * tx.commit(); } catch (Exception e) { e.printStackTrace(); tx.rollback(); }
		 */

		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * User user =
		 * session.createQuery("From User where username=:un and password=:pass",
		 * User.class) .setParameter("un", "kumar@123").setParameter("pass",
		 * "12345").getSingleResult();
		 * 
		 * 
		 * session.close();
		 * 
		 * user.setPassword("7890");
		 * 
		 * 
		 * session = sessionFactory.openSession(); Transaction tx =
		 * session.beginTransaction(); try { session.update(user); tx.commit(); } catch
		 * (Exception e) { e.printStackTrace(); tx.rollback(); }
		 */

		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * User user =
		 * session.createQuery("From User where username=:un and password=:pass",
		 * User.class) .setParameter("un", "kumar@123").setParameter("pass",
		 * "12345").getSingleResult();
		 * 
		 * session.close();
		 * 
		 * user.setUserId(101);
		 * 
		 * 
		 * 
		 * User dummyUser = new User(); dummyUser.setUserId(102);
		 * dummyUser.setFirstname("dummy"); dummyUser.setUsername("dummy");
		 * dummyUser.setPassword("12345");
		 * 
		 * 
		 * session = sessionFactory.openSession(); Transaction tx =
		 * session.beginTransaction(); try { session.update(dummyUser); tx.commit(); }
		 * catch (Exception e) { e.printStackTrace(); tx.rollback(); }
		 */
	}

}
