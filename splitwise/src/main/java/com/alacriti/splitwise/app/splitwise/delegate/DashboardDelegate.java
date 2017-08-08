package com.alacriti.splitwise.app.splitwise.delegate;

import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.bo.impl.DashboardBO;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;

public class DashboardDelegate extends BaseDelgate{
	public void getDashboardDetailsDelegate(DashboardModel userDashboardVO) {
		boolean rollBack = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			DashboardBO dashboardRoleBO = new DashboardBO(getConnection());
			dashboardRoleBO.getDashboardDetailsBO(userDashboardVO);
			System.out.println("In dashboard delegate");
		} catch (Exception e) {
			System.out.println("Exception in getMessage " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}

	}
}
