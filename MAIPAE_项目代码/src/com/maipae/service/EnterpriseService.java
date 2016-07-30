package com.maipae.service;

import java.util.List;

import com.maipae.entity.EnterpriseEntity;

public interface EnterpriseService {
	/**
     * Description:[各责任主体 - 注册单位]<br>
     * 
     * @param addEnterprise
     * @return
     */
	public boolean addEnterprise(EnterpriseEntity enterpriseEntity);
	
	/**
     * Description:[系统管理员 - 待审核的单位注册列表数据，或获取单个注册单位数据]<br>
     * 
     * @param enterpriseToBeAuditedList
     * @return
     */
    public List<EnterpriseEntity> enterpriseToBeAuditedList(String parameterName, String parameterValue);
    
    /**
     * Description:[系统管理员 - 更新注册单位的审核状态]
     * 
     * @param updateEnterprise
     * @return
     */
    public boolean updateEnterprise(EnterpriseEntity enterpriseEntity);
    
    /**
     * Description:[系统管理员 - 删除审核不通过的注册单位资料]
     * 
     * @param deleteEnterprise
     * @return
     */
	public boolean deleteEnterprise(int enterpriseID);
}
