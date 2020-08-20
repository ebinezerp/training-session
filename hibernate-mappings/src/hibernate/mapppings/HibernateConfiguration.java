package hibernate.mapppings;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/appdemo");
		properties.setProperty("hibernate.connection.user", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "create");

		configuration.setProperties(properties);

		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Article.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		User user = new User("ravi");

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}

		Address address = new Address("Hyderabad", "500032");
		address.setUser(user);

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			session.save(address);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}

		session = sessionFactory.openSession();
		User fetchedUser = null;
		try {
			fetchedUser = session.get(User.class, 1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
		}

		System.out.println(fetchedUser.getName());
		System.out.println(fetchedUser.getAddress().getCity());

		session = sessionFactory.openSession();
		Address fetchedAddress = session.createQuery("From Address where user_id =: id", Address.class)
				.setParameter("id", 1).getSingleResult();

		System.out.println(fetchedAddress.getCity());
		System.out.println(fetchedAddress.getUser().getName());

		Article article1 = new Article("Cooking", "Westren Cooking");
		Article article2 = new Article("Travel", "About Japan");
		
		article1.setUser(user);
		article2.setUser(user);

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			session.save(article1);
			session.save(article2);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}

	}

}
