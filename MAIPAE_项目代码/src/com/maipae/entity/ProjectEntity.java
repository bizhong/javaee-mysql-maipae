package com.maipae.entity;

import java.util.Date;

public class ProjectEntity {
	private int ProjectID;
	private String ProjectName;
	private String ProjectFiles;
	private int EnterpriseID;
	private String State;
	private Date ProjectStartTime;
	private Date ProjectEndTime;
	private int PersonID;
	private String BelongStations;
	private String StationName;
	private String Remarks;
	private String MonitorState;
	
	public int getProjectID() {
		return ProjectID;
	}
	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectFiles() {
		return ProjectFiles;
	}
	public void setProjectFiles(String projectFiles) {
		ProjectFiles = projectFiles;
	}
	public int getEnterpriseID() {
		return EnterpriseID;
	}
	public void setEnterpriseID(int enterpriseID) {
		EnterpriseID = enterpriseID;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public Date getProjectStartTime() {
		return ProjectStartTime;
	}
	public void setProjectStartTime(Date projectStartTime) {
		ProjectStartTime = projectStartTime;
	}
	public Date getProjectEndTime() {
		return ProjectEndTime;
	}
	public void setProjectEndTime(Date projectEndTime) {
		ProjectEndTime = projectEndTime;
	}
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	public String getBelongStations() {
		return BelongStations;
	}
	public void setBelongStations(String belongStations) {
		BelongStations = belongStations;
	}
	public String getStationName() {
		return StationName;
	}
	public void setStationName(String stationName) {
		StationName = stationName;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getMonitorState() {
		return MonitorState;
	}
	public void setMonitorState(String monitorState) {
		MonitorState = monitorState;
	}
	
}
