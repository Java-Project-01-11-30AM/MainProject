package com.app.domain;

import java.util.Date;


public class UserAccount {

	private Integer userId;
	private String firstName;
	private String userLastName;
	private String email;
	private String userPazzword;
	private String userPhonenumber;
	private Date dateOfBirth;
	private Character gender;
	private Integer cityId;
	private Integer stateId;
	private Integer roleId;
	private String accStatus;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	public UserAccount() {
		super();
		
	}
	public UserAccount(Integer userId, String firstName, String userLastName, String email, String userPazzword,
			String userPhonenumber, Date dateOfBirth, Character gender, Integer cityId, Integer stateId,
			Integer roleId, String accStatus, Date createdDate, Date updatedDate, String createdBy,
			String updatedBy) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.userLastName = userLastName;
		this.email = email;
		this.userPazzword = userPazzword;
		this.userPhonenumber = userPhonenumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.cityId = cityId;
		this.stateId = stateId;
		this.roleId = roleId;
		this.accStatus = accStatus;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", firstName=" + firstName + ", userLastName=" + userLastName
				+ ", email=" + email + ", userPazzword=" + userPazzword + ", userPhonenumber=" + userPhonenumber
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", cityId=" + cityId + ", stateId=" + stateId
				+ ", roleId=" + roleId + ", accStatus=" + accStatus + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserPazzword() {
		return userPazzword;
	}
	public void setUserPazzword(String userPazzword) {
		this.userPazzword = userPazzword;
	}
	public String getUserPhonenumber() {
		return userPhonenumber;
	}
	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setCountryId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
