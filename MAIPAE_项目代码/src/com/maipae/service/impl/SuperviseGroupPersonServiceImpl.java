package com.maipae.service.impl;

import com.maipae.dao.SuperviseGroupPersonDao;
import com.maipae.service.SuperviseGroupPersonService;

public class SuperviseGroupPersonServiceImpl implements SuperviseGroupPersonService {

	@Override
	public boolean addPSGperson(int projectSuperviseGroupID, String personID, String post) {
		// TODO Auto-generated method stub
		SuperviseGroupPersonDao superviseGroupPersonDao = new SuperviseGroupPersonDao();
        
        return superviseGroupPersonDao.addPSG(projectSuperviseGroupID, personID, post);
	}

}
