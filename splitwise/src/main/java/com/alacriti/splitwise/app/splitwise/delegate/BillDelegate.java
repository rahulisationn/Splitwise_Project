package com.alacriti.splitwise.app.splitwise.delegate;

import java.sql.Connection;

import com.alacriti.splitwise.app.splitwise.bo.impl.BillBO;
import com.alacriti.splitwise.app.splitwise.model.vo.BillModel;

public class BillDelegate extends BaseDelgate{
	public void splitBill(BillModel billModel)
	{
		boolean rollBack = false;
		Connection connection = null;
		try {
			System.out.println("In billDelegate");
			connection = startDBTransaction();
			
			setConnection(connection);
			System.out.println("connection in billdelegate"+getConnection());
			BillBO billBO= new BillBO(getConnection());
			System.out.println("In billdelegate....after creatig registraionBO ");
			billBO.splitBill(billModel);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in getMessage " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		
	}

}
