package com.app.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.app.domain.UserAccount;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendUserAccUnlockEmail01(UserAccount userAcc) {
		boolean isSent = false;
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(userAcc.getEmail());
			msg.setSubject("Registration Email");
			msg.setText(getUnlockAccEmailBody(userAcc));
			mailSender.send(msg);
			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}

	public boolean sendUserAccUnlockEmail(UserAccount userAcc) {
		boolean isSent = false;
		try {

			MimeMessage mimeMsg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
			helper.setTo(userAcc.getEmail());
			helper.setSubject("Unlock your account");
			helper.setText(getUnlockAccEmailBody(userAcc), true);

			mailSender.send(mimeMsg);

			isSent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}

	private String getUnlockAccEmailBody(UserAccount acc) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", acc.getFirstName());
		mailBody = mailBody.replace("{LNAME}", acc.getUserLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", acc.getUserPazzword());
		mailBody = mailBody.replace("{EMAIL}", acc.getEmail());

		return mailBody;
	}
	public void sendEmailForPwd(String email,String body,String subject) {
		System.out.println("MailUtility.sendEmailForPwd()");
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject(subject);
		msg.setText(body);
		mailSender.send(msg);
	}

	public void sendUserSmsOtp(String userPazzword) {
		
		
	}

	
}
