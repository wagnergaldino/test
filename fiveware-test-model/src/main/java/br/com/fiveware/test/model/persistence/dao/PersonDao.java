package br.com.fiveware.test.model.persistence.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import br.com.fiveware.test.model.persistence.entity.Person;

@Repository
public class PersonDao {
	
	public void save(Person person) throws SQLException {
		SessionFactory sessionFactory;
        sessionFactory = new Configuration().configure().buildSessionFactory(); 
        Session session = sessionFactory.openSession(); 
        Transaction tx = session.beginTransaction();
        session.save(person);
        session.flush();
        tx.commit();
        session.close();
	}

}
