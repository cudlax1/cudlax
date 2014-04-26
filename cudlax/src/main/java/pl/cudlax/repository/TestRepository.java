package pl.cudlax.repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import pl.cudlax.domain.TestBazy;

@Repository
public class TestRepository {

	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<TestBazy> readList() {
		return sessionFactory.openSession()
				.createQuery("from pl.cudlax.domain.TestBazy").list();
	}

	public void save(TestBazy tb) {
		Session session = sessionFactory.openSession();
		session.save(tb);
		session.close();
	}
}
