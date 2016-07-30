package com.maipae.dao;

import java.util.ArrayList;
import java.util.List;

import com.maipae.entity.PersonEntity;
import com.maipae.util.DBUtil;

public class PersonDao {
	/**
     * Description:[人员 - 验证登录]
     * 
     * @param verifyPerson
     * @return
     */
    public List<PersonEntity> verifyPerson(String personname, String password) {
        String sql = "select PersonID,PersonName,Password,PersonIdentity,EnterpriseID from t_personinfo where PersonName = ? and Password = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(personname);
        param.add(password);
        
        DBUtil db = new DBUtil();
        
        try {
			return db.queryInfoByParam(sql, param, PersonEntity.class);
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
        return null;
    }
    
    /**
     * Description:[系统管理员 - 审核通过的注册单位增加单位联系人到人员信息表]
     * 
     * @param addPreson
     * @return
     */
	public boolean addPreson(PersonEntity personEntity) {
		String sql = "insert into t_personinfo (PersonName,TelNumber,Email,Password,PersonIdentity,EnterpriseID) values (?,?,?,?,?,?)";
        List<Object> param = new ArrayList<Object>();
        param.add(personEntity.getPersonName());
        param.add(personEntity.getTelNumber());
        param.add(personEntity.getEmail());
        param.add(personEntity.getPassword());
        param.add(personEntity.getPersonIdentity());
        param.add(personEntity.getEnterpriseID());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[各责任主体 - 获取本单位人员列表数据]
     * 
     * @param enterprisePersonList
     * @return
     */
	public List<PersonEntity> enterprisePersonList(String parameterName, int parameterValue) {
		String sql = "select PersonName,TelNumber,Email,PersonIdentity from t_personinfo where " + parameterName + " = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(parameterValue);
        
    	DBUtil db = new DBUtil();
    	
    	try {
			return db.queryInfoByParam(sql, param, PersonEntity.class);
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
		return null;
	}
	
	/**
     * Description:[各责任主体 - 获取本单位人员列表数据]
     * 
     * @param personInfo
     * @return
     */
	public List<PersonEntity> personInfo(int personID) {
		String sql = "select * from t_personinfo where PersonID = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(personID);
        
    	DBUtil db = new DBUtil();
    	
    	List<PersonEntity> list = null;
    	
    	try {
			list =  db.queryInfoByParam(sql, param, PersonEntity.class);
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
     * Description:[人员 - 获取监督组长列表数据，获取监督员列表数据]
     * 
     * @param jdpList
     * @return
     */
	public List<PersonEntity> jdpList(String identity) {
		String sql = "select PersonID,PersonName,PersonIdentity from t_personinfo where PersonIdentity = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(identity);
        
    	DBUtil db = new DBUtil();
    	
    	try {
			return db.queryInfoByParam(sql, param, PersonEntity.class);
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
		return null;
	}
    
}
