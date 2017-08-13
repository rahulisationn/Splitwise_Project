package com.alacriti.splitwise.app.splitwise.bo.impl;

import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.dao.impl.FriendsDAO;
import com.alacriti.splitwise.app.splitwise.dao.impl.RegisterDAO;
import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;


public class RegisterBO extends BaseBO{
	
	public RegisterBO(Connection connection) {
		super(connection);
	}

	public String userRegister(RegistrationModel regres) throws DAOException,BOException
	{
		
		
		try {
			RegisterDAO registerDAO =   new RegisterDAO(getConnection());
			registerDAO.userRegister(regres);
			
		} catch (Exception e) {
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException();
		}
		return "sucess";
	}
	
	
	public void addFriends(RegistrationModel registrationModel)throws DAOException,BOException
	{
		try{
			FriendsDAO friendsDAO = new FriendsDAO(getConnection());
			friendsDAO.addFriends(registrationModel);
		}
		catch(Exception e)
		{
			System.out.println("Exception in friends  BO"+e.getMessage());
			throw new BOException();
		}
	}
}