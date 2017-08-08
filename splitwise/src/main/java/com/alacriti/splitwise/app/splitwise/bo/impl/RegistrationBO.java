package com.alacriti.splitwise.app.splitwise.bo.impl;

import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.dao.impl.RegistrationDAO;
import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;


public class RegistrationBO extends BaseBO{
	
	public RegistrationBO(Connection connection) {
		super(connection);
	}

	public String registrationImplement(RegistrationModel regres) throws DAOException,BOException
	{
		
		/*RegistrationDAO registrationConnection=new RegistrationDAO();
		return registrationConnection.getUserRole(regres);*/
		try {
			RegistrationDAO registrationDAO =   new RegistrationDAO(getConnection());
			registrationDAO.getUserRole(regres);
			
		} catch (Exception e) {
			System.out.println("Exception in retrieveMessage " + e.getMessage());
			throw new BOException();
		}
		return "sucess";
	}
}