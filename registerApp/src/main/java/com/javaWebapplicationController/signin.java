package com.javaWebapplicationController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Webapplication.service.SerInt;
import com.Webapplication.service.ServiceMain;
import com.javaWebApplication.bean.Address;
import com.javaWebApplication.bean.User;

/**
 * Servlet implementation class signin
 */
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		SerInt  serviceInterface  = new ServiceMain();
		String role = serviceInterface.login(user);
		int id = serviceInterface.id(user);
		String sid=String.valueOf(id);
		System.out.print(id);
		
		Address address = new Address();
		address.setId(sid);
		
		if (role.equalsIgnoreCase("user")) 
		  {
			  try { 
				  HttpSession session = request.getSession();
				  session.setAttribute("email",email);
				  session.setAttribute("roll", "user");
				  User user1 = serviceInterface.fetch(id);
				  ArrayList<Address> useraddress = serviceInterface.fetchAddress(address);
				  session.setAttribute("user", user1);
				  session.setAttribute("useraddress", useraddress);
				  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
			      rd.forward(request, response);  
			  } 
			  catch (IOException e) 
			  {
				  e.printStackTrace();
			  }
		  }
		  else if (role.equalsIgnoreCase("admin"))
		  {
			  HttpSession session = request.getSession();
			  session.setAttribute("email",email);
			  session.setAttribute("roll", "admin");
			  ArrayList<User> datalist = serviceInterface.RetriveData();
			  ArrayList<Address> addresslist = serviceInterface.RetriveAddress();
			  session.setAttribute("datalist",datalist);
			  session.setAttribute("addresslist", addresslist);
			  RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
		      rd.forward(request, response);   
		  }
		  else
		  {
			  response.sendRedirect("login.jsp");
		  }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
