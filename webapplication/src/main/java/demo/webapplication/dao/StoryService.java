package demo.webapplication.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.webapplication.dto.Story;

@Service
@Transactional
public class StoryService {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(Story story) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(story);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.clear();
		}
	}

	public List<Story> getStories(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("From Story where customer_id=:id", Story.class).setParameter("id", customerId)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.clear();
		}
	}

	public List<Story> getStories() {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery("From Story", Story.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.clear();
		}
	}

	public Story getStory(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(Story.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.clear();
		}
	}

}
