package demo.webapplication.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
