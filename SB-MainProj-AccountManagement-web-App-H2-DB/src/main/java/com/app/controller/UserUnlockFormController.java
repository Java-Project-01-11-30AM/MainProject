package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.domain.UnlockAccount;
import com.app.domain.UserAccount;
import com.app.service.UserManagementService;
@Controller
public class UserUnlockFormController {
	
	private static Logger logger= LoggerFactory.getLogger(UserUnlockFormController.class);
	
	@Autowired
	private UserManagementService umService;
	
	@RequestMapping(value = "/unlockAcc")
	public String displayUnlockAccForm(@RequestParam("email")  String email, Model model) {
		logger.debug("**************displayUnlockAccFormMethod Execution started**********");
		//model.addAttribute("email", email);
		UnlockAccount unlockAcc = new UnlockAccount();
		unlockAcc.setEmail(email);
		model.addAttribute("unlockAcc", unlockAcc);
		logger.debug("******************displayUnlockAccFormMethod Execution ended**********");
		logger.info("********UnlockAccForm loaded successfully*******");
		return "unlockAccForm";
	}
  @PostMapping("/unlockUserAcc")
  public String unlockUserAcc(@ModelAttribute("unlockAcc") UnlockAccount acc, Model model) {
	  logger.debug("**************unlockUserAccMethod Execution started**********");
	  try {
	  UserAccount userAccnt = umService.getUserAccntByTempPwd(acc.getTempPwd(), acc.getEmail());
	  if(userAccnt!= null) {
		  //update pwd & accnt_status & display success msg
		  userAccnt.setAccStatus("Un-Locked");
		  userAccnt.setUserPazzword(acc.getNewPwd());
		  boolean isUpdated = umService.updateUserAccount(userAccnt);
		  if(isUpdated) {
			  logger.info("*****User Account Unlocked Successfully*******");
			  return "unlockAccntSuccess";
		  }else {
			  logger.warn("****User Account Not Updated *****");
		  }
			  
		}
				  	  
	  //display error msg on the same form
	  model.addAttribute("errMsg","Please enter correct temporary password");
	  }catch (Exception e) {
		  logger.error("Exception Occured ::" + e.getMessage());
	  }
	  logger.debug("******************unlockUserAccMethod Execution ended**********");
	  return "unlockAccForm";
	  
  }
	
}
