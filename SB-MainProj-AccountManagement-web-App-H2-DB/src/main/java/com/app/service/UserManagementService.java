package com.app.service;

//import java.util.Map;

import com.app.domain.UserAccount;
//import com.app.domain.UserLoginDetails;
import com.app.entity.UserAccountEntity;

public interface UserManagementService {
	
	
	//public UserAccountEntity checkCredintials(UserLoginDetails details);
	public UserAccountEntity fetchRecordByEmail(String email);
	public String findByEmail(String email);

	/*
	 * public Map<Integer, String> getAllCountries();
	 * 
	 * public Map<Integer, String> getStatesByCountryId(Integer countryId);
	 * 
	 * public Map<Integer, String> getCitiesByStateId(Integer stateId);
	 */
	public boolean saveUserAcc(UserAccount userAcc);
	
	public UserAccount getUserAccntByTempPwd(String tempPwd, String email);
	
	public boolean updateUserAccount(UserAccount userAcc);
}
