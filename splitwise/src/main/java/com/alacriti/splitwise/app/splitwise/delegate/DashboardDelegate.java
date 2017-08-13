package com.alacriti.splitwise.app.splitwise.delegate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.alacriti.splitwise.app.splitwise.bo.impl.DashboardBO;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;

public class DashboardDelegate extends BaseDelgate{
	
	public void dashboardDetails(DashboardModel userDashboardVO) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			DashboardBO dashboardRoleBO = new DashboardBO(getConnection());
			dashboardRoleBO.dashboardDetails(userDashboardVO);
			System.out.println("In dashboard delegate");
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
	
	
	public void getFriends()
	{
		boolean rollBack=false;
		Connection connection=null;
		try{
			connection=startDBTransaction();
			setConnection(connection);
			DashboardBO dashboardBO= new DashboardBO(getConnection());
			dashboardBO.getFriends();
		}
		catch(Exception e)
		{
			rollBack=true;
			e.printStackTrace();
		}
		finally{
			endDBTransaction(connection,rollBack);	
		}
	}
	
	public List billsInfo()
	{
		boolean rollBack=false;
		Connection connection=null;
		List bills=new ArrayList();
		
		try
		{
			connection=startDBTransaction();
			setConnection(connection);
			DashboardBO dashboardBO= new DashboardBO(getConnection());
			 bills= dashboardBO.billsInfo();
			
		}
		catch(Exception e)
		{
			rollBack=true;
			e.printStackTrace();
		}
		finally{
			endDBTransaction(connection,rollBack);	
		}
		
		return bills;
	}
}
