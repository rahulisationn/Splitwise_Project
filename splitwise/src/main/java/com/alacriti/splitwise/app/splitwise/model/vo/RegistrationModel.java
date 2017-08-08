package com.alacriti.splitwise.app.splitwise.model.vo;

public class RegistrationModel {

	
		
		public String firstname;
		public String lastname;
		public String password;
		public String email;
		public String phoneno;
		public String currency;
		public String profile;
		
		RegistrationModel(String fname,String lname,String psd,String email,String phoneno,String currency,String profile)
		{
			
			this.firstname=fname;
			this.lastname=lname;
			this.password=psd;
			this.email=email;
			this.phoneno=phoneno;
			this.currency=currency;
			this.profile=profile;
			
		}
		
		RegistrationModel(){}
		
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(String phoneno) {
			this.phoneno = phoneno;
		}
		public String getCurrency() {
			return currency;
		}
		public void setCurrency(String currency) {
			this.currency = currency;
		}
		public String getProfile() {
			return profile;
		}
		public void setProfile(String profile) {
			this.profile = profile;
		}
	}

