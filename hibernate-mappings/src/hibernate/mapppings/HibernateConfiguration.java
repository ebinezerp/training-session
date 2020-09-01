package hibernate.mapppings;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.mapppings.tablepersubclass.Cloth;
import hibernate.mapppings.tablepersubclass.ElectronicsProduct;
import hibernate.mapppings.tablepersubclass.Product;

/*import hibernate.mapppings.tableperconcreate.Cloth;
import hibernate.mapppings.tableperconcreate.ElectronicsProduct;
import hibernate.mapppings.tableperconcreate.Product;*/

/*import hibernate.mapppings.tableperhirarchy.Cloth;
import hibernate.mapppings.tableperhirarchy.ElectronicsProduct;
import hibernate.mapppings.tableperhirarchy.Product;*/

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
		configuration.addAnnotatedClass(Author.class);
		configuration.addAnnotatedClass(Book.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(ElectronicsProduct.class);
		configuration.addAnnotatedClass(Cloth.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		/*
		 * User user = new User("ravi");
		 * 
		 * Session session = sessionFactory.openSession(); Transaction tx =
		 * session.beginTransaction(); try { session.save(user); tx.commit(); } catch
		 * (Exception e) { e.printStackTrace(); tx.rollback(); } finally {
		 * session.clear(); session.close(); }
		 * 
		 * Address address = new Address("Hyderabad", "500032"); address.setUser(user);
		 * 
		 * session = sessionFactory.openSession(); tx = session.beginTransaction(); try
		 * { session.save(address); tx.commit(); } catch (Exception e) {
		 * e.printStackTrace(); tx.rollback(); } finally { session.clear();
		 * session.close(); }
		 * 
		 * session = sessionFactory.openSession(); User fetchedUser = null; try {
		 * fetchedUser = session.get(User.class, 1); } catch (Exception e) {
		 * e.printStackTrace(); } finally { session.clear(); session.close(); }
		 * 
		 * System.out.println(fetchedUser.getName());
		 * System.out.println(fetchedUser.getAddress().getCity());
		 * 
		 * session = sessionFactory.openSession(); Address fetchedAddress =
		 * session.createQuery("From Address where user_id =: id", Address.class)
		 * .setParameter("id", 1).getSingleResult();
		 * 
		 * System.out.println(fetchedAddress.getCity());
		 * System.out.println(fetchedAddress.getUser().getName());
		 * 
		 * Article article1 = new Article("Cooking", "Westren Cooking"); Article
		 * article2 = new Article("Travel", "About Japan");
		 * 
		 * article1.setUser(user); article2.setUser(user);
		 * 
		 * session = sessionFactory.openSession(); tx = session.beginTransaction(); try
		 * { session.save(article1); session.save(article2); tx.commit(); } catch
		 * (Exception e) { e.printStackTrace(); tx.rollback(); } finally {
		 * session.clear(); session.close(); }
		 */

		/*
		 * Author author1 = new Author(); author1.setName("John");
		 * author1.setSpecialization("programming");
		 * 
		 * Author author2 = new Author(); author2.setName("Burke");
		 * author2.setSpecialization("medicin");
		 * 
		 * Author author3 = new Author(); author3.setName("Krish");
		 * author3.setSpecialization("cooking");
		 * 
		 * Author author4 = new Author(); author4.setName("Krishnan");
		 * author4.setSpecialization("programming");
		 * 
		 * Author author5 = new Author(); author5.setName("Geethakshi");
		 * author5.setSpecialization("cooking");
		 * 
		 * Book book1 = new Book(); book1.setName("Anuglar Evalution");
		 * book1.setPrice(200.00F);
		 * 
		 * Book book2 = new Book(); book2.setName("Programming in Medical Domain");
		 * book2.setPrice(250.00F);
		 * 
		 * Book book3 = new Book(); book3.setName("Western Cooking");
		 * book3.setPrice(100.00F);
		 * 
		 * Book book4 = new Book(); book4.setName("Cardio Thearpy");
		 * book4.setPrice(180.00F);
		 * 
		 * List<Author> book1Authors = new ArrayList<Author>();
		 * book1Authors.add(author1); book1Authors.add(author4);
		 * book1.setAuthors(book1Authors);
		 * 
		 * List<Book> author1BookList = new ArrayList<Book>();
		 * author1BookList.add(book1);
		 * 
		 * List<Book> author4BookList = new ArrayList<Book>();
		 * author4BookList.add(book1);
		 * 
		 * author1.setBookList(author1BookList); author4.setBookList(author4BookList);
		 * 
		 * 
		 * 
		 * 
		 * Session session = sessionFactory.openSession(); Transaction tx =
		 * session.beginTransaction(); try { session.save(book1); tx.commit(); } catch
		 * (Exception e) { e.printStackTrace(); tx.rollback(); } finally {
		 * session.clear(); session.close(); }
		 */

		ElectronicsProduct electronicsProduct = new ElectronicsProduct("mobile", 20000.00F, 6F, 60F);
		Cloth cloth = new Cloth("saree", 5000F, "Silk", 6F);
		
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(electronicsProduct);
			session.save(cloth);
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
