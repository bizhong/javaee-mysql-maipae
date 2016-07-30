package com.maipae.dao;

import java.util.ArrayList;
import java.util.List;

import com.maipae.entity.ProjectEntity;
import com.maipae.util.DBUtil;

public class ProjectDao {
	/**
     * Description:[建设项目负责人 - 查询建设项目工程]
     * 
     * @param verifyPerson
     * @return
     */
    public List<ProjectEntity> searchProjectList(String s) {
    	String sql = "select * from t_projectinfo where ProjectName like ?";
        List<Object> param = new ArrayList<Object>();
        param.add("%" + s + "%");
        
    	DBUtil db = new DBUtil();
    	
    	List<ProjectEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, ProjectEntity.class);
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
     * Description:[建设项目负责人 - 新增建设项目工程]
     * 
     * @param addProject
     * @return
     */
	public boolean addProject(ProjectEntity projectEntity) {
		String sql = "insert into t_projectinfo (ProjectName,ProjectFiles,EnterpriseID,State,ProjectStartTime,ProjectEndTime,PersonID,BelongStations,StationName,Remarks,MonitorState) values (?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> param = new ArrayList<Object>();
        param.add(projectEntity.getProjectName());
        param.add(projectEntity.getProjectFiles());
        param.add(projectEntity.getEnterpriseID());
        param.add(projectEntity.getState());
        param.add(projectEntity.getProjectStartTime());
        param.add(projectEntity.getProjectEndTime());
        param.add(projectEntity.getPersonID());
        param.add(projectEntity.getBelongStations());
        param.add(projectEntity.getStationName());
        param.add(projectEntity.getRemarks());
        param.add(projectEntity.getMonitorState());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[建设项目负责人 - 建设项目工程详情]
     * 
     * @param projectDetail
     * @return
     */
	public List<ProjectEntity> projectDetail(int projectID) {
		// TODO Auto-generated method stub
		String sql = "select * from t_projectinfo where projectID = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(projectID);
        
    	DBUtil db = new DBUtil();
    	
    	List<ProjectEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, ProjectEntity.class);
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
     * Description:[建设项目负责人 - 修改建设项目工程]
     * 
     * @param modifyProject
     * @return
     */
	public boolean modifyProject(ProjectEntity projectEntity) {
		String sql = "update t_projectinfo set ProjectName = ?,ProjectFiles = ?,EnterpriseID = ?,ProjectStartTime = ?,ProjectEndTime = ?,PersonID = ?,BelongStations = ?,StationName = ?,Remarks = ?,MonitorState = ? where ProjectID = ?";
		List<Object> param = new ArrayList<Object>();
        param.add(projectEntity.getProjectName());
        param.add(projectEntity.getProjectFiles());
        param.add(projectEntity.getEnterpriseID());
        param.add(projectEntity.getProjectStartTime());
        param.add(projectEntity.getProjectEndTime());
        param.add(projectEntity.getPersonID());
        param.add(projectEntity.getBelongStations());
        param.add(projectEntity.getStationName());
        param.add(projectEntity.getRemarks());
        param.add(projectEntity.getMonitorState());
        param.add(projectEntity.getProjectID());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[建设项目负责人 - 提交建设项目工程]
     * 
     * @param changeMState
     * @return
     */
	public boolean changeMState(int projectID) {
		String sql = "update t_projectinfo set MonitorState = ? where ProjectID = ?";
		List<Object> param = new ArrayList<Object>();
        param.add("已报监");
        param.add(projectID);
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[建设项目负责人 - 删除建设项目工程]
     * 
     * @param deleteProject
     * @return
     */
	public boolean deleteProject(int projectID) {
		String sql = "delete from t_projectinfo where ProjectID = ?";
		List<Object> param = new ArrayList<Object>();
        param.add(projectID);
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}

	public List<ProjectEntity> projectList() {
		// TODO Auto-generated method stub
		String sql = "select * from t_projectinfo";
		List<Object> param = new ArrayList<Object>();
        
    	DBUtil db = new DBUtil();
    	
    	List<ProjectEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, ProjectEntity.class);
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
     * Description:[建设项目负责人 - 报监审查]
     * 
     * @param reviewProject
     * @return
     */
	public boolean reviewProject(int projectID, String state) {
		String sql = "update t_projectinfo set State = ? where ProjectID = ?";
		List<Object> param = new ArrayList<Object>();
        param.add(state);
        param.add(projectID);
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[站领导 - 获取审核通过的建设项目工程列表数据]
     * 
     * @param statedProjectList
     * @return
     */

	public List<ProjectEntity> statedProjectList(String stated) {
		// TODO Auto-generated method stub
		String sql = "select * from t_projectinfo where State = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(stated);
        
    	DBUtil db = new DBUtil();
    	
    	List<ProjectEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, ProjectEntity.class);
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
