package com.maipae.service;

import java.util.List;

import com.maipae.entity.ProjectSuperviseGroupEntity;

public interface ProjectSuperviseGroupService {
	/**
     * Description:[站领导 - 获取工程监督组列表数据]
     * 
     * @param psgList
     * @return
     */
	List<ProjectSuperviseGroupEntity> psgList();
	
	/**
     * Description:[站领导 - 处理分配监督组 - 增加到工程监督组]
     */
	public boolean addPSG(int projectID);
	
	/**
     * Description:[站领导 - 处理分配监督组 - 获取ProjectID列表数据]
     * 
     * @param PSGList
     * @return
     */
	List<ProjectSuperviseGroupEntity> PSGList(int projectID);

}
