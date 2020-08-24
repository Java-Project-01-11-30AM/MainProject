package com.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.ContactEntity;
@Repository
public interface ContactDtlsRepository
extends JpaRepository<ContactEntity, Serializable> {

	public ContactEntity findByContactEmail(String email);

}
