package com.maipae.service.impl;

import java.util.List;

import com.maipae.dao.EnterpriseDao;
import com.maipae.entity.EnterpriseEntity;
import com.maipae.service.EnterpriseService;

public class EnterpriseServiceImpl implements EnterpriseService {
	@Override
	public boolean addEnterprise(EnterpriseEntity enterpriseEntity) {
        EnterpriseDao enterpriseDao = new EnterpriseDao();
        
        return enterpriseDao.addEnterprise(enterpriseEntity);
    }
	
	@Override
	public List<EnterpriseEntity> enterpriseToBeAuditedList(String parameterName, String parameterValue) {
		EnterpriseDao enterpriseDao = new EnterpriseDao();
		List<EnterpriseEntity> result = enterpriseDao.enterpriseToBeAuditedList(parameterName, parameterValue);
		
		return result;
    }
	
	@Override
	public boolean updateEnterprise(EnterpriseEntity enterpriseEntity) {
        EnterpriseDao enterpriseDao = new EnterpriseDao();
        
        return enterpriseDao.updateEnterprise(enterpriseEntity);
    }
	
	@Override
	public boolean deleteEnterprise(int enterpriseID) {
        EnterpriseDao enterpriseDao = new EnterpriseDao();
        
        return enterpriseDao.deleteEnterprise(enterpriseID);
    }
	
}