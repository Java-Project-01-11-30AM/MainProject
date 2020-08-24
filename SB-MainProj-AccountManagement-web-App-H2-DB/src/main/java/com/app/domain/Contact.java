package com.app.domain;

import java.io.Serializable;
import java.util.Date;


public class Contact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7592813092739202684L;
	
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date createDate;
	private Date updatedDate;
	
     //super constructor
	public Contact() {
		super();
	}
	//Id(PK) based constructor
	public Contact(Integer contactId) {
		super();
		this.contactId=contactId;
	}
	//Parameterized constructor
	
	
	public Contact(Integer contactId, String contactName, String contactEmail, Long contactNumber, Date createDate,
			Date updatedDate) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
		this.createDate = createDate;
		this.updatedDate = updatedDate;
	}
	
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", contactNumber=" + contactNumber + ", createDate=" + createDate + ", updatedDate=" + updatedDate
				+ "]";
	}
		
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
