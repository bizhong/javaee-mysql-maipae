package com.maipae.dao;

import java.util.ArrayList;
import java.util.List;

import com.maipae.entity.EnterpriseEntity;
import com.maipae.util.DBUtil;

public class EnterpriseDao {
	/**
     * Description:[各责任主体 - 注册单位]
     * 
     * @param addEnterprise
     * @return
     */
	public boolean addEnterprise(EnterpriseEntity enterpriseEntity) {
		String sql = "insert into t_enterpriseinfo (EnterpriseName,EnterpriseStartTime,EnterpriseCharacter,EnterpriseAddress,EnterpriseNumber,EnterpriseWebSite,EnterpriseOrganCode,EnterprisePerson,EnterpriseEmail,EnterprisePersonTel,EnterprisePassword,EnterpriseState,Remarks) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> param = new ArrayList<Object>();
        param.add(enterpriseEntity.getEnterpriseName());
        param.add(enterpriseEntity.getEnterpriseStartTime());
        param.add(enterpriseEntity.getEnterpriseCharacter());
        param.add(enterpriseEntity.getEnterpriseAddress());
        param.add(enterpriseEntity.getEnterpriseNumber());
        param.add(enterpriseEntity.getEnterpriseWebSite());
        param.add(enterpriseEntity.getEnterpriseOrganCode());
        param.add(enterpriseEntity.getEnterprisePerson());
        param.add(enterpriseEntity.getEnterpriseEmail());
        param.add(enterpriseEntity.getEnterprisePersonTel());
        param.add(enterpriseEntity.getEnterprisePassword());
        param.add(enterpriseEntity.getEnterpriseState());
        param.add(enterpriseEntity.getRemarks());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[系统管理员 - 待审核的单位注册列表数据，或获取单个注册单位数据]
     * 
     * @param enterpriseToBeAuditedList
     * @return
     */
    public List<EnterpriseEntity> enterpriseToBeAuditedList(String parameterName, String parameterValue) {
    	String sql = "select * from t_enterpriseinfo where " + parameterName + " = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(parameterValue);
        
    	DBUtil db = new DBUtil();
    	
    	try {
			return db.queryInfoByParam(sql, param, EnterpriseEntity.class);
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
     * Description:[系统管理员 - 更新注册单位的审核状态]
     * 
     * @param updateEnterprise
     * @return
     */
	public boolean updateEnterprise(EnterpriseEntity enterpriseEntity) {
		String sql = "update t_enterpriseinfo set EnterpriseState= ? where EnterpriseID = ?";
		List<Object> param = new ArrayList<Object>();
        param.add(enterpriseEntity.getEnterpriseState());
        param.add(enterpriseEntity.getEnterpriseID());
        
        DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
	/**
     * Description:[系统管理员 - 删除审核不通过的注册单位资料]
     * 
     * @param deleteEnterprise
     * @return
     */
	public boolean deleteEnterprise(int enterpriseID) {
		// TODO Auto-generated method stub
		String sql = "delete from t_enterpriseinfo where EnterpriseID = ?";
        List<Object> param = new ArrayList<Object>();
        param.add(enterpriseID);
		
		DBUtil db = new DBUtil();
        
        return db.InsertUpdateDeleteExcute(sql, param);
	}
	
}
