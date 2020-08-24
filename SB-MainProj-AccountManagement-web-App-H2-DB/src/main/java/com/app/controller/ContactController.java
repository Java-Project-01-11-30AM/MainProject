package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.domain.Contact;
import com.app.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService; // HAS-A

	
	@RequestMapping(value = { "/", "/addContact" }, method = RequestMethod.GET)
	public String loadForm(Model model) {
		Contact c = new Contact();
		model.addAttribute("contact", c);
		return "contactInfo";
	}

	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String handleSubmitBtn(@ModelAttribute(value="contact") Contact c, RedirectAttributes redirectattribute) {
		String msg = null;
		boolean isSaved = contactService.saveContact(c);
		if (isSaved) {
			msg = "contact details are saved";
		} else {
			msg="contact details failed to save";
			redirectattribute.addFlashAttribute("msg",msg);
		}
		return "redirect:/doubleposting";
	}
	@RequestMapping(value = "/doubleposting" ,method = RequestMethod.GET)
	public String preventDoublePosting(Model model) {
		model.addAttribute("contact", new Contact());
		return "contactInfo";
	}
	
	@GetMapping("/viewcontacts")
	public String handleViewContactsLink(Model model) {
		List<Contact> contactsList = contactService.getAllContacts();
		model.addAttribute("contacts", contactsList);
		return "viewcontacts";
	}
	@GetMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(HttpServletRequest req) {
		String email = req.getParameter("email");
		String emailStatus = contactService.findByEmail(email);
		return emailStatus;
	}

}
