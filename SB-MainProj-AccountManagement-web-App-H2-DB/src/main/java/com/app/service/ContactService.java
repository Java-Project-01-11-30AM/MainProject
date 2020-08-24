package com.app.service;

import java.util.List;

import com.app.domain.Contact;

public interface ContactService {
	
	 boolean saveContact(Contact c);
	 List<Contact> getAllContacts();
	 Contact getContactById(Integer cid);
	 boolean updateContact(Contact c);
	 boolean deleteContact(Integer cid);
	String findByEmail(String email);
}
