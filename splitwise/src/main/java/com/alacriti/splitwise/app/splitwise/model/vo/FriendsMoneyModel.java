package com.alacriti.splitwise.app.splitwise.model.vo;

public class FriendsMoneyModel {
	public String firstname;
	public int money_owes;
	public int money_owed;
	public int friendid;
	public int balance;
	public FriendsMoneyModel(int friendid,String firstname,int money_owes,int money_owed,int balance)
	{
		this.friendid=friendid;
		this.firstname=firstname;
		this.money_owes=money_owes;
		this.money_owed=money_owed;	
		this.balance=balance;
		
	}
	
	public FriendsMoneyModel(){}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getMoney_owes() {
		return money_owes;
	}
	public void setMoney_owes(int money_owes) {
		this.money_owes = money_owes;
	}
	public int getMoney_owed() {
		return money_owed;
	}
	public void setMoney_owed(int money_owed) {
		this.money_owed = money_owed;
	}

	public int getFriendid() {
		return friendid;
	}

	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
