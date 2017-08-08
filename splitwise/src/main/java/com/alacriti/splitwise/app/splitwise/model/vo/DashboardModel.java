package com.alacriti.splitwise.app.splitwise.model.vo;

public class DashboardModel {
	public String name;
	public int balance;
	public int money_owes;
	public int money_owed;
	public DashboardModel(String name,int balance,int money_owes,int money_owed)
	{
		this.name=name;
		this.balance=balance;
		this.money_owes=money_owes;
		this.money_owed=money_owed;
		
	}
	public DashboardModel(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
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
	
	

}
