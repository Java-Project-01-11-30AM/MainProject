package com.app.util;

import org.springframework.stereotype.Component;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


@Component

public class SmsUtils {
	private final static String ACCOUNT_SID = "AC00452e045e3f4b4cfdf379be8563d3e5";
	private final static String AUTH_ID = "ca8c488624c73d803c37c50ca811d59e";
	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public void sendUserSmsOtp(String password) {
		 Message.creator(new PhoneNumber("+918374071680"),
					             new PhoneNumber("+17203364553"),
					             "Your user app login pwd sent by Obed="+password)
				                 .create();
		
	}

}



