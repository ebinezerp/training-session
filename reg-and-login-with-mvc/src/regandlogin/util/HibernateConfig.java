package regandlogin.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	public SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

}
