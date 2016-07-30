package com.maipae.service;

import java.util.List;

import com.maipae.entity.ProjectEntity;

public interface ProjectService {
	/**
     * Description:[建设项目负责人 - 查询建设项目工程]
     * 
     * @param verifyPerson
     * @return
     */
    public List<ProjectEntity> searchProjectList(String s);
    
    /**
     * Description:[建设项目负责人 - 新增建设项目工程]
     * 
     * @param addProject
     * @return
     */
    public boolean addProject(ProjectEntity projectEntity);
    
    /**
     * Description:[建设项目负责人 - 建设项目工程详情]
     * 
     * @param projectDetail
     * @return
     */
	public List<ProjectEntity> projectDetail(int projectID);
	
	/**
     * Description:[建设项目负责人 - 修改建设项目工程]
     * 
     * @param modifyProject
     * @return
     */
	public boolean modifyProject(ProjectEntity pe);
	
    /**
     * Description:[建设项目负责人 - 提交建设项目工程]
     * 
     * @param changeMState
     * @return
     */
    public boolean changeMState(int projectID);
    
    /**
     * Description:[建设项目负责人 - 删除建设项目工程]
     * 
     * @param deleteProject
     * @return
     */
	public boolean deleteProject(int projectID);
	
	/**
     * Description:[报监审核员 - 获取建设项目工程列表数据]
     * 
     * @param projectList
     * @return
     */
	public List<ProjectEntity> projectList();
	
	/**
     * Description:[报监审核员 - 报监审查]
     * 
     * @param projectList
     * @return
     */
	public boolean reviewProject(int projectID, String state);
	
	/**
     * Description:[站领导 - 获取审核通过的建设项目工程列表数据]
     * 
     * @param statedProjectList
     * @return
     */
	public List<ProjectEntity> statedProjectList(String stated);
	
}
