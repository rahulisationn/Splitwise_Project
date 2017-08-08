package com.alacriti.splitwise.app.splitwise.model.vo;

public class LoginModel {
	public String login_email;
	public String password;
	public boolean isValid=false;
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	LoginModel(String login_email,String password)
	{
		this.login_email=login_email;
		this.password=password;
	}
	public LoginModel(){}
	public String getLogin_email() {
		return login_email;
	}
	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
