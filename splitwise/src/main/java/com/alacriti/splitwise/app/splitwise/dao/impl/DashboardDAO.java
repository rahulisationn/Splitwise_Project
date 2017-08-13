package com.alacriti.splitwise.app.splitwise.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.splitwise.app.splitwise.model.vo.BillInfoModel;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;
import com.alacriti.splitwise.app.splitwise.model.vo.LoginModel;

public class DashboardDAO extends BaseDAO {
	public static List<DashboardModel> dashboardlist =new ArrayList();
	public static List<String> friendslist=new ArrayList();
	public DashboardDAO(Connection conn)
	{
		super(conn);
	}
	public DashboardDAO(){}
	public void dashboardDetails(DashboardModel dashboardModel) throws DAOException{
		
		Statement stmt=null;
		ResultSet resultset=null;
		LoginModel loginmodel=new LoginModel();
		try{
			dashboardlist.clear();
			System.out.println("In dashboard DAO");
			String Dashboard_login_name=LoginDAO.login_name;
			String name=dashboardModel.getName();
			int balance=dashboardModel.getBalance();
			int money_owes=dashboardModel.getMoney_owes();
			int money_owed=dashboardModel.getMoney_owed();
			String sqlCmd = "select balance,money_owes,money_owed,firstname from sravanthir_splitwise_friend_tbl where firstname='"+Dashboard_login_name+"'";
			stmt =getStatementDashboard(getConnection(), sqlCmd);
			System.out.println("reached here********");
			resultset= stmt.executeQuery(sqlCmd);
			System.out.println("after result set");
			//System.out.println("result set "+resultset.toString());
			while(resultset.next()){
				name=resultset.getString("firstname");
			balance=resultset.getInt("balance");
			System.out.println("blance is"+balance);
			money_owes=resultset.getInt("money_owes");
			money_owed=resultset.getInt("money_owed");
			dashboardlist.add(new DashboardModel(name,balance,money_owes,money_owed));
			System.out.println("balance"+balance);
			System.out.println("money owes"+money_owes);
			System.out.println("money_owed"+money_owed);	
			}
		}
			 catch (SQLException e) {
				System.out.println(
						"SQLException in checkUser " + e.getMessage() +"catch");
				//throw new DAOException("SQLException in getUserRole():"+ e);
			} finally {
				close(stmt);
			}
		
	}

	
			public Statement getStatementDashboard(Connection connection, String sqlCmd) throws SQLException{
			//		log.debugPrintCurrentMethodName();

		System.out.println("getStatement: " + sqlCmd);
		try {

			return connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Exception in getStatementCheckUser " + e.getMessage());
			throw e;
		}
	}
	public void getFriends() throws DAOException
	{
		Statement statement=null;
		ResultSet resultset=null;
		try{
			friendslist.clear();
			System.out.println("In list of friends Dao");
			String firstname=null;
			String sqlcommand="select firstname from sravanthir_splitwise_friend_tbl where firstname !='"+LoginDAO.login_name+"'";
			statement =getStatementDashboard(getConnection(), sqlcommand);
			resultset= statement.executeQuery(sqlcommand);
			while(resultset.next())
			{
				firstname=resultset.getString("firstname");
				System.out.println("firstanme is "+firstname);
				friendslist.add(firstname);
				System.out.println(friendslist);	
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			
			throw new DAOException("SQLException in getUserRole():"+ e);
		} finally {
			close(statement);
		}
		
	}
	public List billsInfo() throws DAOException
	{
		List<BillInfoModel> billinfolist=new ArrayList<BillInfoModel>();
		Statement statement=null;
		ResultSet resultset=null;
		try{
			billinfolist.clear();
			String sqlCommand="select l1.firstname,l2.firstname"
					+ ",l2.balance,l1.money_owes,l1.money_owed from sravanthir_splitwise_friend_tbl as l1"
					+ ",sravanthir_splitwise_friend_tbl as l2,"
					+ "sravanthir_splitwise_billmembers_tbl as t1 "
					+ "where t1.paidby=l1.friendid and t1.paidto=l2.friendid";
			statement =getStatementDashboard(getConnection(), sqlCommand);
			resultset= statement.executeQuery(sqlCommand);
			while(resultset.next())
			{
				int balance=resultset.getInt("l2.balance");
				String givenby=resultset.getString("l1.firstname");
				String givento=resultset.getString("l2.firstname");
				int money_owes=resultset.getInt("money_owes");
				int money_owed=resultset.getInt("money_owed");
				System.out.println("Balance---"+balance+"Given by********"+givenby+
						"given TO^^^^6"+givento+"money_owes88"+money_owes+"money_owed ###"+money_owed);
				billinfolist.add(new BillInfoModel(balance,givenby,givento,money_owes,money_owed));
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("SQLException in getUserRole():"+ e);
		} finally {
			close(statement);
		}
		return billinfolist;
		
	}
	
	

}
