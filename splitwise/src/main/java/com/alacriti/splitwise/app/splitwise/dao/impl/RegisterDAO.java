package com.alacriti.splitwise.app.splitwise.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;

public class RegisterDAO extends BaseDAO{
	
	public RegisterDAO(Connection conn) {
		super(conn);
	}
	public RegisterDAO(){
		
	}
	public String userRegister(RegistrationModel userVO) throws DAOException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String msg="fail";
		try {
			String sqlCmd = "sql command";
			
			stmt =getPreparedStatementGeteUserRole(getConnection(), sqlCmd);
			stmt.setString(1,userVO.firstname);
			stmt.setString(2,userVO.lastname);
			stmt.setString(3,userVO.password);
			stmt.setString(4,userVO.email);
			stmt.setString(5,userVO.phoneno);
			stmt.setString(6,userVO.currency);
			stmt.setString(7,"null");
			
			stmt.executeUpdate();
			msg="success";
			}	
		catch(SQLException e) {
			e.printStackTrace();
			msg=e.toString();
			throw new DAOException("SQLException in getUserRole():", e);
			
		} finally {
			close(stmt, rs);
		}
		return msg;
	}
	public PreparedStatement getPreparedStatementGeteUserRole(Connection connection, String sqlCmd) throws SQLException{
		try {
			return connection.prepareStatement("insert into sravanthir_splitwise_registration_table(firstname,lastname,password,email,Phoneno,currency,profile) values(?,?,?,?,?,?,?)");
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementGeteUserRole"+ e.getMessage());
			throw e;
		}
	}

}
