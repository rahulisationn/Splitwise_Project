package com.alacriti.splitwise.app.splitwise.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;
import com.alacriti.splitwise.app.splitwise.model.vo.LoginModel;

public class DashboardDAO extends BaseDAO {
	public static List<DashboardModel> dashboardlist =new ArrayList();
	public DashboardDAO(Connection conn)
	{
		super(conn);
	}
	DashboardDAO(){}
	public void getDashboardDetails(DashboardModel dashboardModel) throws DAOException{
		
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
			String sqlCmd = "select balance,money_owes,money_owed,firstname from sravanthir_splitwise_friends_tbl where firstname='"+Dashboard_login_name+"'";
			stmt =getStatementDashboard(getConnection(), sqlCmd);
			System.out.println("reached here********");
			resultset= stmt.executeQuery(sqlCmd);
			System.out.println("after result set");
			//System.out.println("reult set "+resultset.toString());
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
	

}
