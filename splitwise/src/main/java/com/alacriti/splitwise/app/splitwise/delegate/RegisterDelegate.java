package com.alacriti.splitwise.app.splitwise.delegate;



import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.bo.impl.RegisterBO;
import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;

public class RegisterDelegate extends BaseDelgate{
	
	public  String userRegister(RegistrationModel registrationModel) {
		
		boolean rollBack = false;
		Connection connection = null;
		try {
			System.out.println("In getRegistration");
			connection = startDBTransaction();
			System.out.println("In getRegistration....after startDBTransaction ");
			setConnection(connection);
			System.out.println("In getRegistration....after setConnection ");
			RegisterBO registraionBO= new RegisterBO(getConnection());
			System.out.println("In getRegistration....after creatig registraionBO ");
			registraionBO.userRegister(registrationModel);
		} catch (Exception e) {
			System.out.println("Exception in getMessage " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return "Success";

	}
	
	
	public void addFriends(RegistrationModel registrationModel)
	{
		boolean rollback=false;
	
		Connection connection=null;
		try
		{
			System.out.println("In freinds Delegte");
			connection =startDBTransaction();
			setConnection(connection);
			RegisterBO registraionBO= new RegisterBO(getConnection());
			registraionBO.addFriends(registrationModel);
		}
	catch(Exception e)
	{
		System.out.println("Exception friends Delegate"+e.getMessage());
		rollback=true;
	}finally{
		endDBTransaction(connection,rollback);
	}
	}

}
