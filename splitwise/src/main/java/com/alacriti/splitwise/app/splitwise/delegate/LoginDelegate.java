
package com.alacriti.splitwise.app.splitwise.delegate;



import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.bo.impl.LoginBO;
import com.alacriti.splitwise.app.splitwise.model.vo.LoginModel;


	
public class LoginDelegate extends BaseDelgate{


	public void userLogin(LoginModel userLoginVO) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			LoginBO loginRoleBO = new LoginBO(getConnection());
			loginRoleBO.userLogin(userLoginVO);
		} catch (Exception e) {
			System.out.println("Exception in getMessage " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	
}
