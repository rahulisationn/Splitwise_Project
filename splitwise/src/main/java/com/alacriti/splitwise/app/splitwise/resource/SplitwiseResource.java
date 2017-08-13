package com.alacriti.splitwise.app.splitwise.resource;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.splitwise.app.splitwise.dao.impl.DashboardDAO;
import com.alacriti.splitwise.app.splitwise.delegate.BillDelegate;
import com.alacriti.splitwise.app.splitwise.delegate.DashboardDelegate;
import com.alacriti.splitwise.app.splitwise.delegate.LoginDelegate;
import com.alacriti.splitwise.app.splitwise.delegate.RegisterDelegate;
import com.alacriti.splitwise.app.splitwise.model.vo.BillModel;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;
import com.alacriti.splitwise.app.splitwise.model.vo.LoginModel;
import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;
import com.alacriti.splitwise.app.splitwise.util.SessionUtility;
@Path("user")
public class SplitwiseResource {
	public static boolean validUser=false;
	@Path("display")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String toPrint() {
		return "Sravanthi";
	}
	@Path("/registration")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String userRegister(RegistrationModel list) 
	{
		System.out.println("Recieved @ implementPostForReg:" + list);
		String output = "msg";
		RegisterDelegate registerDelegate = new RegisterDelegate();
		output = registerDelegate.userRegister(list);
		
		return output;
	}
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response userLogin(LoginModel loginmodel,@Context HttpServletRequest request){
		System.out.println("In post method of login resource");
		LoginDelegate loginDelegate= new LoginDelegate();
		loginDelegate.userLogin(loginmodel);
		
		if(validUser){
			HttpSession session= request.getSession();
			return Response.status(200).entity(loginmodel).build();
			
		}
		else 
			return Response.status(401).entity(loginmodel).build();
	}
	
	
	@Path("/dashboard")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.TEXT_PLAIN)
	public List dashboardDetails()
	{
		System.out.println("In get method of dashboard");
		DashboardDelegate dashboardDelegate = new DashboardDelegate();
		DashboardModel dashboardModel=new DashboardModel();
		System.out.println("In betweenn ");
		dashboardDelegate.dashboardDetails(dashboardModel);
		System.out.println("In get method of dashboard before return ");
		
		return DashboardDAO.dashboardlist;
	
	}
	@Path("/friends")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFriends(RegistrationModel registrationModel)
	{
		RegisterDelegate registerDelegte =new RegisterDelegate();
		registerDelegte.addFriends(registrationModel);
		return Response.status(200).entity(registrationModel).build();
	}
	@Path("/friendslist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List friendsList()
	{
		DashboardDelegate dashboardDelegate=new DashboardDelegate();
		dashboardDelegate.getFriends();
		DashboardDAO dashboardDAO = new DashboardDAO();
		return DashboardDAO.friendslist;
	}
	
	@Path("/billpayment")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response billSplit(BillModel billModel)
	{
		System.out.println("came to resource");
		BillDelegate billDelegate=new BillDelegate();
		billDelegate.splitBill(billModel);
		return Response.status(200).entity(billModel).build();
	}
	
	@GET
	@Path("/checkSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSessoin(@Context HttpServletRequest request)
	{
	SessionUtility sessionUtility=new SessionUtility();
	HttpSession session= request.getSession(false);
	System.out.println("session in checkSession :"+session);
	return sessionUtility.checkForSession(session);
	}
	
	@Path("/billInformation")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List billsInfo()
	{
		DashboardDelegate dashboardDelegate=new DashboardDelegate();
		return dashboardDelegate.billsInfo();
	}
	
	
}
