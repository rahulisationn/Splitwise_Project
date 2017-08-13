package com.alacriti.splitwise.app.splitwise.bo.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.alacriti.splitwise.app.splitwise.dao.impl.BillDAO;
import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.model.vo.BillModel;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;
import com.alacriti.splitwise.app.splitwise.model.vo.FriendsMoneyModel;

public class BillBO extends BaseBO {
	
	public static List<FriendsMoneyModel> afterAddedList=new ArrayList();
	public BillBO(Connection connection)
	{
		super(connection);
	}
	public BillBO(){}
	public void splitBill(BillModel billModel) throws BOException
	{
		
		try{
			
		BillDAO billDAO =new BillDAO(getConnection());
		
		List<FriendsMoneyModel> selectedList=billDAO.getMoneyDetails(billModel);
		
		
		int count=billModel.getCount();
		int amount=billModel.getTotalAmount();
		System.out.println("COunt is "+count);
		int paidToEachMember=amount/count;
		Iterator itr=selectedList.iterator();
		System.out.println("In BillBO after getting list------"+paidToEachMember);
		while(itr.hasNext())
		{
			
			FriendsMoneyModel friendsMoneyModel=(FriendsMoneyModel) itr.next();
			String firstname=friendsMoneyModel.getFirstname();
			int friendid=friendsMoneyModel.getFriendid();
			System.out.println("NAMHD****"+firstname);
			int money_owes=friendsMoneyModel.getMoney_owes();
			System.out.println("owes****"+money_owes);
			int money_owed=friendsMoneyModel.getMoney_owed();
			System.out.println("owes****"+money_owed);
			int balance=friendsMoneyModel.getBalance();
			String paidby=billModel.getPaidby();
			if(firstname.equals(paidby))
			{
				money_owed=paidToEachMember;
				if(money_owes > money_owed)
				{
					balance=money_owes-money_owed;
					
				}
				else
				{
					balance=money_owed-money_owes;
					
				}		
			}
			else{
			
			money_owes=money_owes + paidToEachMember;
			if(money_owes > money_owed)
			{
				balance=money_owes-money_owed;
				
			}
			else
			{
				balance=money_owed-money_owes;
				
			}
			}
			afterAddedList.add(new FriendsMoneyModel(friendid,firstname,money_owes,money_owed,balance));
			System.out.println("fter added friends" +"firstname"+firstname+"money_owes"+money_owes+"money_owed"+money_owed);
		}
		System.out.println("befor update call");
		billDAO.updateMoneyInDatabase(billModel);
		billDAO.getBillInfo(billModel);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		
		}
	}
	
	
}