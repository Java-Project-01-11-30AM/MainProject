package com.app.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.domain.Contact;
import com.app.repository.ContactDtlsRepository;
import com.app.entity.ContactEntity;


@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactDtlsRepository contactRepo; //HAS-A

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c , entity);
		ContactEntity savedEntity = contactRepo.save(entity);
		return savedEntity.getContactId() !=null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities=contactRepo.findAll();
		//java 8 approach
		return entities.stream().map(entity ->{
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity,contact);
			return contact;
		}).collect(Collectors.toList());		
	}

	@Override
	public Contact getContactById(Integer cid) {
		 java.util.Optional<ContactEntity> findById = contactRepo.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity,c);
			return c;
		}
		return null;
	}
	
	@Override
	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}
	@Override
	public String findByEmail(String email) {
		ContactEntity entity=contactRepo.findByContactEmail(email);
		if(null!=entity) {
			return "Duplicate";
		}
		return "Unique";
	}
	public ContactDtlsRepository getContactRepo() {
		return contactRepo;
	}

	public void setContactRepo(ContactDtlsRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@Override
	public boolean updateContact(Contact c) {
		return false;
	}
    


}
