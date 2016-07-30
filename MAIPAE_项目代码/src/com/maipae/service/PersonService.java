package com.maipae.service;

import java.util.List;

import com.maipae.entity.PersonEntity;

public interface PersonService {
	/**
     * Description:[人员 - 验证登录]<br>
     * 
     * @param verifyPerson
     * @return
     */
    public List<PersonEntity> verifyPerson(String personname, String password);
    
    /**
     * Description:[系统管理员 - 审核通过的注册单位增加单位联系人到人员信息表]
     * 
     * @param addPreson
     * @return
     */
	public boolean addPreson(PersonEntity personEntity);
	
	/**
     * Description:[各责任主体 - 获取本单位人员列表数据]
     * 
     * @param enterprisePersonList
     * @return
     */
	public List<PersonEntity> enterprisePersonList(String parameterName, int parameterValue);
	
	/**
     * Description:[人员 - 个人信息]
     * 
     * @param personInfo
     * @return
     */
	public List<PersonEntity> personInfo(int personID);
	
	/**
     * Description:[人员 - 获取监督组长列表数据，获取监督员列表数据]
     * 
     * @param jdpList
     * @return
     */
	public List<PersonEntity> jdpList(String identity);
    
}