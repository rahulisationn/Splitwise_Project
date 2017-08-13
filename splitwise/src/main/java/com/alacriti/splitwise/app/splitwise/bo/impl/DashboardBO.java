package com.alacriti.splitwise.app.splitwise.bo.impl;

import java.sql.Connection;
import java.util.List;

import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.dao.impl.DashboardDAO;
import com.alacriti.splitwise.app.splitwise.dao.impl.LoginDAO;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;

public class DashboardBO extends BaseBO {
	
	public DashboardBO(Connection conn)
	{
		super(conn);
	}
	DashboardBO(){}
		
	public void dashboardDetails(DashboardModel userdashboardVO) throws DAOException, BOException{
		
		try {
			DashboardDAO dashboardDAO =new DashboardDAO(getConnection());
			dashboardDAO.dashboardDetails(userdashboardVO);
			System.out.println("In Dashboard Bo");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}	
	
	public void getFriends()throws BOException{
		try{
			DashboardDAO dashboardDAO =new DashboardDAO(getConnection());
			dashboardDAO.getFriends();
							
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BOException();
		}
	}
	
	public List billsInfo() throws BOException
	{
		try{
			DashboardDAO dashboardDAO=new DashboardDAO(getConnection());
			return dashboardDAO.billsInfo();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BOException();
		}
	}

}
