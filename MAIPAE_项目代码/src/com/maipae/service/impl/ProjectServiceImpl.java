package com.maipae.service.impl;

import java.util.List;

import com.maipae.dao.ProjectDao;
import com.maipae.entity.ProjectEntity;
import com.maipae.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
	@Override
    public List<ProjectEntity> searchProjectList(String s) {
		ProjectDao projectDao = new ProjectDao();
		List<ProjectEntity> result = projectDao.searchProjectList(s);
		
		return result;
    }
	
	@Override
	public boolean addProject(ProjectEntity projectEntity) {
		ProjectDao projectDao = new ProjectDao();
        
        return projectDao.addProject(projectEntity);
    }
	
	@Override
    public List<ProjectEntity> projectDetail(int projectID) {
		ProjectDao projectDao = new ProjectDao();
		List<ProjectEntity> result = projectDao.projectDetail(projectID);
		
		return result;
    }
	
	@Override
	public boolean modifyProject(ProjectEntity projectEntity) {
		ProjectDao projectDao = new ProjectDao();
        
        return projectDao.modifyProject(projectEntity);
	}
	
	@Override
	public boolean changeMState(int projectID) {
		ProjectDao projectDao = new ProjectDao();
        
        return projectDao.changeMState(projectID);
    }
	
	@Override
	public boolean deleteProject(int projectID) {
		ProjectDao projectDao = new ProjectDao();
        
        return projectDao.deleteProject(projectID);
    }
	
	@Override
    public List<ProjectEntity> projectList() {
		ProjectDao projectDao = new ProjectDao();
		List<ProjectEntity> result = projectDao.projectList();
		
		return result;
    }
	
	@Override
	public boolean reviewProject(int projectID, String state) {
		ProjectDao projectDao = new ProjectDao();
        
        return projectDao.reviewProject(projectID, state);
    }
	
	@Override
    public List<ProjectEntity> statedProjectList(String stated) {
		ProjectDao projectDao = new ProjectDao();
		List<ProjectEntity> result = projectDao.statedProjectList(stated);
		
		return result;
    }
	
}
