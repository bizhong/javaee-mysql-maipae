package com.maipae.service;

public interface SuperviseGroupPersonService {
	/**
     * Description:[站领导 - 增加工程监督组人员（监督组长、监督员）]
     * 
     * @param addPSGperson
     * @return
     */
	public boolean addPSGperson(int projectSuperviseGroupID, String personID, String post);

}
