package com.app.domain;

public class UnlockAccount {
	
	private String email;
	private String tempPwd;
	private String newPwd;
	private String confirmPwd;
	
	public UnlockAccount() {
		super();
		
	}
	public UnlockAccount(String email, String tempPwd, String newPwd, String confirmPwd) {
		super();
		this.email = email;
		this.tempPwd = tempPwd;
		this.newPwd = newPwd;
		this.confirmPwd = confirmPwd;
	}
	@Override
	public String toString() {
		return "UnlockAccount [email=" + email + ", tempPwd=" + tempPwd + ", newPwd=" + newPwd + ", confirmPwd="
				+ confirmPwd + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTempPwd() {
		return tempPwd;
	}
	public void setTempPwd(String tempPwd) {
		this.tempPwd = tempPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConfirmPwd() {
		return confirmPwd;
	}
	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}
	
	
}
