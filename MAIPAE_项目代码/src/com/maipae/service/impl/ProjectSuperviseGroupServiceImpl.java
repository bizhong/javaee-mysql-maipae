package com.maipae.service.impl;

import java.util.List;

import com.maipae.dao.ProjectSuperviseGroupDao;
import com.maipae.entity.ProjectSuperviseGroupEntity;
import com.maipae.service.ProjectSuperviseGroupService;

public class ProjectSuperviseGroupServiceImpl implements ProjectSuperviseGroupService {

	@Override
	public List<ProjectSuperviseGroupEntity> psgList() {
		ProjectSuperviseGroupDao projectSuperviseGroupDao = new ProjectSuperviseGroupDao();
		List<ProjectSuperviseGroupEntity> result = projectSuperviseGroupDao.psgList();
		
		return result;
	}

	@Override
	public boolean addPSG(int projectID) {
		// TODO Auto-generated method stub
		ProjectSuperviseGroupDao projectSuperviseGroupDao = new ProjectSuperviseGroupDao();
        
        return projectSuperviseGroupDao.addPSG(projectID);
	}

	@Override
	public List<ProjectSuperviseGroupEntity> PSGList(int projectID) {
		ProjectSuperviseGroupDao projectSuperviseGroupDao = new ProjectSuperviseGroupDao();
		List<ProjectSuperviseGroupEntity> result = projectSuperviseGroupDao.PSGList(projectID);
		
		return result;
	}

}