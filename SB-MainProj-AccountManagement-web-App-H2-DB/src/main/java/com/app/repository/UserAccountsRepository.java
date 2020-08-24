package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.UserAccountEntity;

public interface UserAccountsRepository extends JpaRepository<UserAccountEntity, String> {

	@Query(value = "select  customer_id from cus where customer_id= :email;", nativeQuery = true)
	public Boolean checkEmail(String email);

	public UserAccountEntity findByUserPazzwordAndEmail(String tempPwd, String email);

	public UserAccountEntity getUserAccntByUserPazzwordAndEmail(String userPazzword, String email);

	public UserAccountEntity getRecordByEmail(String email);

	public UserAccountEntity findByEmail(String email);
}