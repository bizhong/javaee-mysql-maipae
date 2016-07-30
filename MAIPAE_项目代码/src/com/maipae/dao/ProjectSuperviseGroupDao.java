package com.maipae.dao;

import java.util.ArrayList;
import java.util.List;

import com.maipae.entity.ProjectSuperviseGroupEntity;
import com.maipae.util.DBUtil;

public class ProjectSuperviseGroupDao {
	/**
     * Description:[站领导 - 获取工程监督组列表数据]
     * 
     * @param psgList
     * @return
     */
	public List<ProjectSuperviseGroupEntity> psgList() {
		String sql = "select * from t_projectsupervisegroup";
        List<Object> param = new ArrayList<Object>();
        
    	DBUtil db = new DBUtil();
    	
    	List<ProjectSuperviseGroupEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, ProjectSuperviseGroupEntity.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	/**
     * Description:[站领导 - 处理分配监督组 - 增加到工程监督组]
     * 
     * @param psgList
     * @return
     */
	public boolean addPSG(int projectID) {
		// TODO Auto-generated method stub
		String sql = "insert into t_projectsupervisegroup (ProjectID) values (?)";
        List<Object> param = new ArrayList<Object>();
        param.add(projectID);
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[站领导 - 处理分配监督组 - 获取ProjectID列表数据]
     * 
     * @param psgList
     * @return
     */

	public List<ProjectSuperviseGroupEntity> PSGList(int projectID) {
		// TODO Auto-generated method stub
		String sql = "select * from t_projectsupervisegroup where projectID = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(projectID);
        
    	DBUtil db = new DBUtil();
    	
    	List<ProjectSuperviseGroupEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, ProjectSuperviseGroupEntity.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
