package com.alacriti.splitwise.app.splitwise.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;

public class FriendsDAO extends BaseDAO{
	public FriendsDAO(Connection conn)
	{
		super(conn);
	}
	public FriendsDAO()
	{}
	public void addFriends(RegistrationModel registrationmodel) throws DAOException
	{
		PreparedStatement stmt=null;
		ResultSet resultSet=null;
		try
		{
			String sqlCmd = "sql command";
			stmt =getPreparedStatementForAddFriends(getConnection(), sqlCmd);
			stmt.setString(1,registrationmodel.firstname);
			stmt.setString(2,registrationmodel.lastname);
			stmt.setString(3, registrationmodel.email);
			stmt.setString(4, registrationmodel.phoneno);
			stmt.setInt(5,0);
			stmt.setInt(6,0);
			stmt.executeUpdate();
		
		}	
	catch(SQLException e) {
		System.out.println(e.getMessage()+"In dao");
		
		throw new DAOException("SQLException in getUserRole():", e);
		
	} finally {
		close(stmt, resultSet);
	}
		
	}
	
	
	public PreparedStatement getPreparedStatementForAddFriends(Connection connection, String sqlCmd) throws SQLException{
		try {
			return connection.prepareStatement("insert into sravanthir_splitwise_friend_tbl(firstname,lastname,email,Phoneno,money_owes,money_owed) values(?,?,?,?,?,?)");
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementGeteUserRole"+ e.getMessage());
			throw e;
		}
	}

}

