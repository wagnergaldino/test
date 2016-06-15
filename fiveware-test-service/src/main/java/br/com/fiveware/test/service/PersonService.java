package br.com.fiveware.test.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import br.com.fiveware.test.model.persistence.dao.PersonDao;
import br.com.fiveware.test.model.persistence.entity.Person;

@Service
public class PersonService {
	
	public void savePerson(Person person, PersonDao dao) throws SQLException {
		dao.save(person);
	}

}
