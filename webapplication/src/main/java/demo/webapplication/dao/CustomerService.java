package demo.webapplication.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.webapplication.dto.Customer;

@Component
@Transactional
public class CustomerService {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
		}

		return false;
	}

	public Customer login(String email, String password) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Customer> query = session.createQuery("From Customer where email=:email and password=:pass",
					Customer.class);
			query.setParameter("email", email);
			query.setParameter("pass", password);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.clear();
			return false;
		}
	}

}
