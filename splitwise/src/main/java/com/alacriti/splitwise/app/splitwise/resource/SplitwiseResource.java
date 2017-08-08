package com.alacriti.splitwise.app.splitwise.resource;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.alacriti.splitwise.app.splitwise.dao.impl.DashboardDAO;
import com.alacriti.splitwise.app.splitwise.delegate.DashboardDelegate;
import com.alacriti.splitwise.app.splitwise.delegate.LoginDelegate;
import com.alacriti.splitwise.app.splitwise.delegate.RegisterDelegate;
import com.alacriti.splitwise.app.splitwise.model.vo.DashboardModel;
import com.alacriti.splitwise.app.splitwise.model.vo.LoginModel;
import com.alacriti.splitwise.app.splitwise.model.vo.RegistrationModel;
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
	public String implementPostForRegistration(RegistrationModel list) {
		System.out.println("Recieved @ implementPostForReg:" + list);
		String output = "msg";
		RegisterDelegate registerDelegate = new RegisterDelegate();
		output = registerDelegate.getRegistration(list);
		
		return output;
	}
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkLogin(LoginModel loginmodel){
		System.out.println("In post method of login resource");
		LoginDelegate loginDelegate= new LoginDelegate();
		loginDelegate.checkUserLoginDelegate(loginmodel);
		if(validUser)
			return Response.status(200).entity(loginmodel).build();
		else 
			return Response.status(401).entity(loginmodel).build();
	}
	
	
	@Path("/dashboard")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.TEXT_PLAIN)
	public List DashboardDetails()
	{
		System.out.println("In get method of dashboard");
		DashboardDelegate dashboardDelegate = new DashboardDelegate();
		DashboardModel dashboardModel=new DashboardModel();
		System.out.println("In betweenn ");
		dashboardDelegate.getDashboardDetailsDelegate(dashboardModel);
		System.out.println("In get method of dashboard before return ");
		
		return DashboardDAO.dashboardlist;
	
	}
	
}
