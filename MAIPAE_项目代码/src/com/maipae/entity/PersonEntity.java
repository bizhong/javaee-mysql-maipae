package com.maipae.entity;

import java.util.Date;

public class PersonEntity {
	private int PersonID;
	private String PersonName;
	private String PersonSex;
	private Date BirthDate;
	private String TelNumber;
	private String Email;
	private String Password;
	private String PersonIdentity;
	private int ZipCode;
	private String Address;
	private int EnterpriseID;
	
	public int getPersonID() {
		return PersonID;
	}
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	public String getPersonName() {
		return PersonName;
	}
	public void setPersonName(String personName) {
		PersonName = personName;
	}
	public String getPersonSex() {
		return PersonSex;
	}
	public void setPersonSex(String personSex) {
		PersonSex = personSex;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	public String getTelNumber() {
		return TelNumber;
	}
	public void setTelNumber(String telNumber) {
		TelNumber = telNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPersonIdentity() {
		return PersonIdentity;
	}
	public void setPersonIdentity(String personIdentity) {
		PersonIdentity = personIdentity;
	}
	public int getZipCode() {
		return ZipCode;
	}
	public void setZipCode(int zipCode) {
		ZipCode = zipCode;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getEnterpriseID() {
		return EnterpriseID;
	}
	public void setEnterpriseID(int enterpriseID) {
		EnterpriseID = enterpriseID;
	}
	
}
