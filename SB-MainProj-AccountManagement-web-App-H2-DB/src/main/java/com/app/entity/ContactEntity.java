package com.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



@Entity
@Table(name = "CONTACT_DTLS")
public class ContactEntity {

	@Id
	@Column(name = "CONTACT_ID")
	@SequenceGenerator(name = "cid_seq_gen", sequenceName = "CONTACT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "cid_seq_gen", strategy = GenerationType.SEQUENCE)
	private Integer contactId;//contactId
	
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(length=10, name = "CONTACT_NUMBER")
	private Long contactNumber;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", updatable=false)
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE" ,insertable=false)
	private Date updatedDate;
	
	@Column(name="ACTIVE_SW")
	private String activeSw;
	
	@Column(name="ACC_STATUS")
	private String accountStatus;
	
	@Column(name="USER_PWD")
	private String userPwd;
	
	  //super constructor
		public ContactEntity() {
			super();
		}
		//Id(PK) based constructor
		public ContactEntity(Integer contactId) {
			super();
			this.contactId=contactId;
		}
		//Parameterized constructor
				
		public ContactEntity(Integer contactId, String contactName, String contactEmail, Long contactNumber, Date createDate,
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
		return "ContactEntity [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail="
				+ contactEmail + ", contactNumber=" + contactNumber + ", createDate=" + createDate + ", updatedDate="
				+ updatedDate + "]";
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

}
