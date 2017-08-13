package com.alacriti.splitwise.app.splitwise.model.vo;

public class BillInfoModel {
	public int money_balance;
	public String givenBy;
	public String givento;
	public int money_owes;
	public int money_owed;
	public BillInfoModel(int money_balance, String givenBy, String givento,
			int money_owes,int money_owed) {
		super();
		this.money_balance = money_balance;
		this.givenBy = givenBy;
		this.givento = givento;
		this.money_owes = money_owes;
		this.money_owed=money_owed;
	}
	public int getMoney_owed() {
		return money_owed;
	}
	public void setMoney_owed(int money_owed) {
		this.money_owed = money_owed;
	}
	public BillInfoModel(){}
	public int getMoney_balance() {
		return money_balance;
	}
	public void setMoney_balance(int money_balance) {
		this.money_balance = money_balance;
	}
	public String getGivenBy() {
		return givenBy;
	}
	public void setGivenBy(String givenBy) {
		this.givenBy = givenBy;
	}
	public String getGivento() {
		return givento;
	}
	public void setGivento(String givento) {
		this.givento = givento;
	}
	public int getMoney_owes() {
		return money_owes;
	}
	public void setMoney_owes(int money_owes) {
		this.money_owes = money_owes;
	}

}
