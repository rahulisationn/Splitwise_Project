package com.alacriti.splitwise.app.splitwise.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alacriti.splitwise.app.splitwise.bo.impl.BOException;
import com.alacriti.splitwise.app.splitwise.bo.impl.BillBO;
import com.alacriti.splitwise.app.splitwise.model.vo.BillModel;
import com.alacriti.splitwise.app.splitwise.model.vo.FriendsMoneyModel;

public class BillDAO extends BaseDAO{
	public BillDAO(Connection connection)
	{
		super(connection);
	}
	public BillDAO(){}
	public int i=0;
	public List getMoneyDetails(BillModel billModel) throws DAOException
	{
		System.out.println("In splitDAO");
		Statement stmt = null;
		ResultSet resultset = null;
		List<FriendsMoneyModel> selectedlist=new ArrayList();
		List friends=billModel.getSelectedfriends();
		friends.add(billModel.getPaidby());
		Iterator friendsitr=friends.listIterator();
		System.out.println("Befor try");
		try {
		while(friendsitr.hasNext())
			{
				String frnds=(String) friendsitr.next();
				
				String sqlcommand="select friendid,money_owes,money_owed,firstname,balance from sravanthir_splitwise_friend_tbl where firstname='"+frnds+"'";
				stmt =getStatementFriendBill(getConnection(), sqlcommand);
				resultset= stmt.executeQuery(sqlcommand);
				if(resultset.next()){
					System.out.println("firstanme---"+resultset.getString("firstname")+"money_owes"+resultset.getInt("money_owes")+"money_owed"+resultset.getInt("money_owed"));
					selectedlist.add(new FriendsMoneyModel(resultset.getInt("friendid"),resultset.getString("firstname"),
							resultset.getInt("money_owes"),resultset.getInt("money_owed"),resultset.getInt("balance")));
					
			}
				
			}
			
			
		}
		catch (SQLException e) {
	
					e.printStackTrace();
			throw new DAOException("SQLException in getUserRole():"+ e);
		} finally {
			close(stmt);
		}
		return selectedlist;
	}
	
	
	public Statement getStatementFriendBill(Connection connection, String sqlCmd) throws SQLException{
//		log.debugPrintCurrentMethodName();

		System.out.println("getStatement: " + sqlCmd);
		try {
				
				return connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Exception in getStatementCheckUser " + e.getMessage());
			throw e;
		}
	}
	
	public void updateMoneyInDatabase(BillModel billModel) throws DAOException
	{
		PreparedStatement prepapredstatement=null;
		ResultSet resultset=null;
		
		BillBO billBO=new BillBO();
		System.out.println("AFter update billBO");
		List<FriendsMoneyModel> updateFriends=billBO.afterAddedList;
		
		Iterator<FriendsMoneyModel> itr=updateFriends.iterator();
		System.out.println("after list");
		try{
			String sqlCmd=null;
			
			while(itr.hasNext())
			{
				
				FriendsMoneyModel friendsMoneyModel=(FriendsMoneyModel) itr.next();
				prepapredstatement =getPreparedStatementGeteUserRole(getConnection(), sqlCmd);
				
				prepapredstatement.setInt(1,friendsMoneyModel.getMoney_owes());
				prepapredstatement.setInt(2,friendsMoneyModel.getMoney_owed());
				prepapredstatement.setString(3,friendsMoneyModel.getFirstname());		
				prepapredstatement.executeUpdate();
				
				System.out.println("In update query");
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
				
				throw new DAOException("SQLException in getUserRole():", e);
				
			} finally {
				System.out.println("finallyyyyyy");
				close(prepapredstatement, resultset);
			
		}
	}
	
	public PreparedStatement getPreparedStatementGeteUserRole(Connection connection, String sqlCmd) throws SQLException{
		try {
			return connection.prepareStatement("update sravanthir_splitwise_friend_tbl set money_owes=? ,money_owed =? where firstname=?");
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementGeteUserRole"+ e.getMessage());
			throw e;
		}
	}
	public void getBillInfo(BillModel billModel)throws DAOException
	{
		Statement statement=null;
		PreparedStatement prepapredstatement=null;
		ResultSet resultset=null;
		
		String paidby=billModel.getPaidby();
		int fid=0;
		try{
		String sqlCommand="select friendid from sravanthir_splitwise_friend_tbl where firstname='"+paidby +"'";	
		System.out.println("Before sql statement in geBillinfo");
		statement =getStatementFriendBill(getConnection(), sqlCommand);
		//stmt=getPreparedStatement(getConnection(), sqlCmd);
		System.out.println("statement executed ");
		resultset= statement.executeQuery(sqlCommand);
		System.out.println("result set exeuted");
		while(resultset.next())
		{
			 fid=resultset.getInt("friendid");
			 System.out.println("IN while of frit sql in get billinfo friendis is "+fid);
		}
		BillBO billBO=new BillBO();
		System.out.println("AFter update billBO");
		List<FriendsMoneyModel> updateFriends=billBO.afterAddedList;
		Iterator<FriendsMoneyModel> itr=updateFriends.iterator();
		System.out.println("after iterator in bill bo");
		int i=0;
		System.out.println("list is "+updateFriends);
		
		while(itr.hasNext() && i<updateFriends.size())
		{
			System.out.println("when to while sttement of insert st^^^^");
			String sqlCmd="insert into sravanthir_splitwise_billmembers_tbl(paidby,paidto,reason) values(?,?,?)";
			prepapredstatement=getPreparedStatement(getConnection(), sqlCmd);
			
			prepapredstatement.setInt(1,fid);	
			prepapredstatement.setInt(2,updateFriends.get(i).friendid);	
			prepapredstatement.setString(3,billModel.getReason());
			prepapredstatement.executeUpdate();
			
			
			
			System.out.println("fid"+fid+"paid to freindid"+
			updateFriends.get(i).friendid+"reason"+billModel.getReason());
			i++;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		throw new DAOException("SQLException in getUserRole():", e);
	}
		
	}
	
	
	
	
	
	
	
	}
	
