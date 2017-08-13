package com.alacriti.splitwise.app.splitwise.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.splitwise.app.splitwise.model.vo.LoginModel;
import com.alacriti.splitwise.app.splitwise.resource.SplitwiseResource;

public class LoginDAO extends BaseDAO {
	
	public LoginDAO(Connection conn)
	{
		super(conn);
	}
	LoginDAO(){}
	public static String login_name="";
	public void userLogin(LoginModel userLogin) throws DAOException {
//		log.debugPrintCurrentMethodName();
		Statement stmt = null;
		ResultSet rs = null;
	
		try {
			String login_email=userLogin.getLogin_email();
			String password=userLogin.getPassword();
			System.out.println("connection is "+getConnection());
			String sqlCmd = "select password,firstname from sravanthir_splitwise_registration_table where email='"+login_email+"'";
			stmt =getStatementCheckUserLogin(getConnection(), sqlCmd);
			System.out.println("connection is "+getConnection());
			System.out.println("reached statement");
			rs= stmt.executeQuery(sqlCmd);
			if(rs.next()){
				if(password.equals(rs.getString("password"))){
					System.out.println("Successfully Logged in***"+login_email);
					SplitwiseResource.validUser=true;
					userLogin.isValid=true;
					login_name=rs.getString("firstname");
					System.out.println(userLogin.name);
				}
				else
				{
					System.out.println("Invalid Password");
				}
				
			}
			
		} catch (SQLException e) {
			System.out.println(
					"SQLException in checkUser " + e.getMessage());
			//throw new DAOException("SQLException in getUserRole():"+ e);
		} finally {
			close(stmt);
		}
	}
	public Statement getStatementCheckUserLogin(Connection connection, String sqlCmd) throws SQLException{
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
