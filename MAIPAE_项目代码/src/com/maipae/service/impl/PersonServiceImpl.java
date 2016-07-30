package com.maipae.service.impl;

import java.util.List;

import com.maipae.dao.PersonDao;
import com.maipae.entity.PersonEntity;
import com.maipae.service.PersonService;

public class PersonServiceImpl implements PersonService {
	@Override
    public List<PersonEntity> verifyPerson(String personname, String password) {
		PersonDao personDao = new PersonDao();
		List<PersonEntity> result = personDao.verifyPerson(personname, password);
		
		return result;
    }
	
	@Override
	public boolean addPreson(PersonEntity personEntity) {
		PersonDao personDao = new PersonDao();
        
        return personDao.addPreson(personEntity);
    }
	
	@Override
	public List<PersonEntity> enterprisePersonList(String parameterName, int parameterValue) {
		PersonDao personDao = new PersonDao();
		List<PersonEntity> result = personDao.enterprisePersonList(parameterName, parameterValue);
		
		return result;
    }
	
	@Override
	public List<PersonEntity> personInfo(int personID) {
		PersonDao personDao = new PersonDao();
        
        return personDao.personInfo(personID);
    }

	@Override
	public List<PersonEntity> jdpList(String identity) {
		PersonDao personDao = new PersonDao();
		List<PersonEntity> result = personDao.jdpList(identity);
		
		return result;
	}
}
