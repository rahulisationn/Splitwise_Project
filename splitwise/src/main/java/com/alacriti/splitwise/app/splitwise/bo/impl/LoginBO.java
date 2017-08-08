package com.alacriti.splitwise.app.splitwise.bo.impl;

import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.dao.impl.LoginDAO;
import com.alacriti.splitwise.app.splitwise.model.vo.LoginModel;
public class LoginBO extends BaseBO{
public LoginBO(Connection connection) {
	super(connection);
}
LoginBO(){}


public void checkUserLoginBO(LoginModel userLoginVO) throws DAOException, BOException{
	
	try {
		LoginDAO userDAO =new LoginDAO(getConnection());
		userDAO.checkUserLoginDAO(userLoginVO);
		
	} catch (Exception e) {
		System.out.println("Exception in retrieveMessage " + e.getMessage());
		throw new BOException();
	}
}	
}
