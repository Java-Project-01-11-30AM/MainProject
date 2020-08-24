package com.app.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.domain.UserAccount;
import com.app.service.UserManagementService;

@Controller
public class UserManagementController {
	private static Logger logger= LoggerFactory.getLogger(UserUnlockFormController.class);
	@Autowired
	private UserManagementService umService;

	@RequestMapping("/loadForm")
	public String loadForm(Model model) {
       logger.debug("*********Method Execution started********");
       try {
		UserAccount acc = new UserAccount();
		model.addAttribute("userAcc", acc);

			/*
			 * Map<Integer, String> countryMap = umService.getAllCountries();
			 * model.addAttribute("countryMap", countryMap);
			 */
       }catch(Exception e) {
    	   logger.error("Exception Occured ::"+e.getMessage());
         }
       logger.info("***************Registration form loaded successfully********");
		return "addUserForm";
	}
	
	@PostMapping("/create")
	public String handleCreateAccountform(@ModelAttribute("account") UserAccount userAcc, RedirectAttributes attributes) {
		boolean isSaved = umService.saveUserAcc(userAcc);
		if (isSaved) {
			attributes.addFlashAttribute("msg",
					"Your registration is almost complete ,please check ur mail to unlock it...");
		} else {
			attributes.addFlashAttribute("errMsg", "Failed to create account..!");
		}

		return "redirect:/loadForm";
	}

	@RequestMapping(value = "/userAccReg", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute("userAcc") UserAccount userAcc, Model model) {
		logger.debug("*********Method Execution Started******");
		
		try {
			umService.saveUserAcc(userAcc);
			logger.info("*******User Registration Completed Successfully*******");
		}catch (Exception e) {
			logger.error("Exception Occured While Saving User ::" + e.getMessage());
		}
		 logger.debug("********Method Execution Ended******");
		return "userAccRegSuccess";
	}

	
	
}
