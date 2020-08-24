package com.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "USER_ACCOUNTS")
public class UserAccountEntity {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String userLastName;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "USER_PWD")
	private String userPazzword;

	@Column(name = "USER_MOBILE")
	private String userPhonenumber;

	@Column(name = "DOB")
	private Date dateOfBirth;

	@Column(name = "GENDER")
	private Character gender;
	
	@Column(name = "ROLE_ID")
	private Integer roleId;

	@Column(name = "ACC_STATUS")
	private String accStatus;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DELETE_SW")
	private String deletedSwitch;

	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	

	public UserAccountEntity() {
		super();
		
	}



	public UserAccountEntity(Integer userId, String firstName, String userLastName, String email, String userPazzword,
			String userPhonenumber, Date dateOfBirth, Character gender, Integer roleId, String accStatus, String name,
			String deletedSwitch, Date createdDate, Date updatedDate, String createdBy, String updatedBy) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.userLastName = userLastName;
		this.email = email;
		this.userPazzword = userPazzword;
		this.userPhonenumber = userPhonenumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.roleId = roleId;
		this.accStatus = accStatus;
		this.name = name;
		this.deletedSwitch = deletedSwitch;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}



	@Override
	public String toString() {
		return "UserAccountEntity [userId=" + userId + ", firstName=" + firstName + ", userLastName=" + userLastName
				+ ", email=" + email + ", userPazzword=" + userPazzword + ", userPhonenumber=" + userPhonenumber
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", roleId=" + roleId + ", accStatus="
				+ accStatus + ", name=" + name + ", deletedSwitch=" + deletedSwitch + ", createdDate=" + createdDate
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



	public Integer getRoleId() {
		return roleId;
	}



	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}



	public String getAccStatus() {
		return accStatus;
	}



	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDeletedSwitch() {
		return deletedSwitch;
	}



	public void setDeletedSwitch(String deletedSwitch) {
		this.deletedSwitch = deletedSwitch;
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
