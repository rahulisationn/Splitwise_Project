package com.alacriti.splitwise.app.splitwise.bo.impl;

import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.dao.impl.DAOException;
import com.alacriti.splitwise.app.splitwise.dao.impl.DashboardDAO;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;

public class DashboardBO extends BaseBO {
	
	public DashboardBO(Connection conn)
	{
		super(conn);
	}
	DashboardBO(){}
		
	public void getDashboardDetailsBO(DashboardModel userdashboardVO) throws DAOException, BOException{
		
		try {
			DashboardDAO dashboardDAO =new DashboardDAO(getConnection());
			dashboardDAO.getDashboardDetails(userdashboardVO);
			System.out.println("In Dashboard Bo");
			
		} catch (Exception e) {
			System.out.println("Exception in DashboardVo " + e.getMessage());
			throw new BOException();
		}
	}	

}
