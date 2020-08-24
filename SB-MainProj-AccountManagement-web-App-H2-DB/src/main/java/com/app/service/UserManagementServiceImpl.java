package com.app.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.constants.AppConstants;
import com.app.domain.UserAccount;
import com.app.entity.UserAccountEntity;
import com.app.repository.UserAccountsRepository;
import com.app.util.EmailUtils;
import com.app.util.PwdUtils;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	
	@Autowired
	private UserAccountsRepository userAccRepo;

	@Autowired
	private EmailUtils emailUtils;



	@Override
	public boolean saveUserAcc(UserAccount userAcc) {
		userAcc.setUserPazzword(PwdUtils.generateTempPwd(AppConstants.TEMP_PWD_LENGTH));
		userAcc.setAccStatus(AppConstants.LOCKED_STR);

		UserAccountEntity entity = new UserAccountEntity();
		BeanUtils.copyProperties(userAcc, entity);

		UserAccountEntity savedEntity = userAccRepo.save(entity);
		entity.setDeletedSwitch("N");
		entity.setAccStatus("LOCKED");
		entity.setName(entity.getFirstName() + " " + entity.getUserLastName());
		entity.setUserPazzword(PwdUtils.generateTempPwd(6));

		if (savedEntity.getUserId() != null) {
			return emailUtils.sendUserAccUnlockEmail(userAcc);
		}
		return false;
	}
	
	@Override
	public UserAccount getUserAccntByTempPwd(String tempPwd, String email) {
		UserAccountEntity entity = userAccRepo.findByUserPazzwordAndEmail(tempPwd, email);
		UserAccount accnt = null;
		if(entity != null) {
			accnt = new UserAccount();
			BeanUtils.copyProperties(entity, accnt);
		}
		return accnt;
	}

	@Override
	public boolean updateUserAccount(UserAccount userAcc) {
		UserAccountEntity entity = new UserAccountEntity();
		BeanUtils.copyProperties(userAcc, entity);
		UserAccountEntity savedEntity = userAccRepo.save(entity);
		return savedEntity != null;
	}

	/*
	 * @Override public UserAccountEntity checkCredintials(UserLoginDetails details)
	 * { UserAccountEntity entity = new UserAccountEntity();
	 * entity.setEmail(details.getEmail());
	 * entity.setUserPazzword(details.getPwd()); UserAccountEntity
	 * recordByEmailAndPwd =
	 * userAccRepo.getUserAccntByUserPazzwordAndEmail(entity.getUserPazzword(),
	 * entity.getEmail()); return recordByEmailAndPwd; }
	 */

	@Override
	public UserAccountEntity fetchRecordByEmail(String email) {
		UserAccountEntity userAccount = userAccRepo.getRecordByEmail(email);
		if (userAccount != null) {
			try {
				sendEmailToUser(email, userAccount.getUserPazzword());

			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return userAccount;
	}
	public void sendEmailToUser(String email, String pwd) throws Exception {
		System.out.println("UserMngtServiceImpl.sendEmailToUser()");

		String fileName = "forgetEmailTemplate";
		StringBuilder sb = new StringBuilder();
		FileReader reader = new FileReader(new File(fileName));
		BufferedReader br = new BufferedReader(reader);
		String line = br.readLine();
		while (line != null) {
			if (line.contains("${EMAIL}")) {
				line = line.replace("${EMAIL}", email);
				sb.append(line);
			}
			if (line.contains("${PWD}")) {
				line = line.replace("${PWD}", pwd);
				sb.append(line);
			}
			line = br.readLine();
		}
		emailUtils.sendEmailForPwd(email, sb.toString(), "Your Password");
	}
	@Override
	public String findByEmail(String email) {
		UserAccountEntity entity=userAccRepo.findByEmail(email);
		if(null!=entity) {
			return "Duplicate";
		}
		return "Unique";
	}

	
}

