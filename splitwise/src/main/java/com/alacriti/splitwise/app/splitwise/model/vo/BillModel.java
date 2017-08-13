package com.alacriti.splitwise.app.splitwise.model.vo;

import java.util.ArrayList;
import java.util.List;

public class BillModel {

	public int count=0;
	List<String> selectedfriends=new ArrayList();
	public String reason;
	public int  totalAmount;
	public String paidby;
	public BillModel(int count,List array,String reason,int totalAmount,String paidby)
	{
		this.count=count;
		this.selectedfriends=array;
		this.reason=reason;
		this.totalAmount=totalAmount;
		this.paidby=paidby;
	}
	
	public String getPaidby() {
		return paidby;
	}

	public void setPaidby(String paidby) {
		this.paidby = paidby;
	}

	public BillModel(){}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<String> getSelectedfriends() {
		return selectedfriends;
	}
	public void setSelectedfriends(List<String> selectedfriends) {
		this.selectedfriends = selectedfriends;
	}
	
	
}
