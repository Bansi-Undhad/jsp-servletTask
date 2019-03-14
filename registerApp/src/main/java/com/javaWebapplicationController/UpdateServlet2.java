package com.javaWebapplicationController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaWebApplication.Model.MyDb;
import com.javaWebApplication.Model.MyDbInterface;
import com.javaWebApplication.bean.User;

/**
 * Servlet implementation class UpdateServlet2
 */
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out=response.getWriter();  
         
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String fname=request.getParameter("fname");
	        String lname=request.getParameter("lname");
	        String dob=request.getParameter("dob");
	        String password=request.getParameter("password");    
	        String language = " ";
	        String lang[] = request.getParameterValues("lang");
	        for(int i=0;i<lang.length;i++) {
				language+=lang[i]+"  ";
			}
	        String gender=request.getParameter("gender");
	        User user = new User();
	        user.setId(id);
	        user.setFname(fname);
	        user.setLname(lname);
	        user.setDob(dob);
	        user.setPassword(password);
	        user.setLang(language);
	        user.setGender(gender);
	        
	        MyDbInterface dp = new MyDb();
			 dp.update(user); 
			
			
				response.sendRedirect("welcome.jsp");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
