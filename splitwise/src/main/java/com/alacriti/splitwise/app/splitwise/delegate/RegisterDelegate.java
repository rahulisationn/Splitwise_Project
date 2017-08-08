package com.alacriti.splitwise.app.splitwise.delegate;



import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.bo.impl.RegistrationBO;
import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;

public class RegisterDelegate extends BaseDelgate{
	
	public  String getRegistration(RegistrationModel list) {
		
		boolean rollBack = false;
		Connection connection = null;
		try {
			System.out.println("In getRegistration");
			connection = startDBTransaction();
			System.out.println("In getRegistration....after startDBTransaction ");
			setConnection(connection);
			System.out.println("In getRegistration....after setConnection ");
			RegistrationBO registraionBO= new RegistrationBO(getConnection());
			System.out.println("In getRegistration....after creatig registraionBO ");
			registraionBO.registrationImplement(list);
		} catch (Exception e) {
			System.out.println("Exception in getMessage " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return "Success";

	}

}
