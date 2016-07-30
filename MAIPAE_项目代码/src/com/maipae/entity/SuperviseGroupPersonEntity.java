package com.maipae.entity;

public class SuperviseGroupPersonEntity {
	
	private int ID;
	
	private int ProjectSuperviseGroupID;
	
	private int PersonID;
	
	private String Post;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public int getProjectSuperviseGroupID() {
		return ProjectSuperviseGroupID;
	}

	public void setProjectSuperviseGroupID(int ProjectSuperviseGroupID) {
		this.ProjectSuperviseGroupID = ProjectSuperviseGroupID;
	}

	public int getPersonID() {
		return PersonID;
	}

	public void setPersonID(int PersonID) {
		this.PersonID = PersonID;
	}

	public String getPost() {
		return Post;
	}

	public void setPost(String Post) {
		this.Post = Post;
	}
	
}
