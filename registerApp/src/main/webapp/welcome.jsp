<%@ page import=" com.javaWebApplication.Model.MyDb,com.javaWebApplication.Model.MyDbInterface,com.javaWebApplication.bean.User,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "com.javaWebApplication.bean.Address" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>  
	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
</head>
<body>	

	<%
	String email = (String)session.getAttribute("email");
	String roll  = (String)session.getAttribute("roll"); 
	ArrayList<User> datalist = (ArrayList)session.getAttribute("datalist");
	ArrayList<Address> addresslist = (ArrayList)session.getAttribute("addresslist");
	ArrayList<Address> useraddress = (ArrayList)session.getAttribute("useraddress");
	User user = (User)session.getAttribute("user");
	System.out.println(useraddress);
	%>
	
	<h1>Welcome  <%out.print(email); %> <% out.print(roll); %></h1>
	
	<c:set var="role" value="admin"/>
 	<c:choose>
		<c:when test="${roll == role}"> 
		  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">       
			 <div class="collapse navbar-collapse" id="navbarSupportedContent"></div>
		  </nav>
			<table id="example" class="display" style="width:100%">
		        <thead>
		            <tr>
		            		<th>Id</th>
		               		<th>First Name</th>
		 	                <th>Last Name</th>
		 	                <th>Date Of Birth</th>
		 	                <th>Email</th>
		 	                <th>Password</th>
		 					<th>Gender</th>
		 					<th>Language</th>
		 					<th>Action</th>
		 					<th>Address</th>
		            </tr>
		        </thead>
		        <tbody>
		        <% for (User user2 : datalist) 
		   		{%> 
		            <tr>
		            	<td><%out.print(user2.getId());%></td>
		                <td><%out.print(user2.getFname());%></td>
				        <td><%out.print(user2.getLname());%></td>
				        <td><%out.print(user2.getDob());%></td>
			            <td><%out.print(user2.getEmail());%></td>
			            <td><%out.print(user2.getPassword());%></td>
			            <td><%out.print(user2.getGender());%></td>
			            <td><%out.print(user2.getLang());%></td>
			            <td>
				            <a href="UpdateServlet?id=<%=user2.getId()%>">Edit</a>
				                                &nbsp;&nbsp;&nbsp;&nbsp;
			                <a href="DeleteServlet?id=<%=user2.getId()%>">Delete</a>                     
			             </td>
		            </tr>
		          <% }%>  
		        </tbody>
		    </table><br/>
		    <table id="example" class="display" cellspacing="0" width="100%"">
		        <thead>
		            <tr>
		            		<th>Address_Id</th>
		               		<th>Street 1</th>
		 	                <th>Street 2</th>
		 	                <th>City</th>
		 	                <th>State</th>
		 	                <th>Pincode</th>
		 					<th>User_Id</th>
		            </tr>
		        </thead>
		        <tbody>
		        <% for (Address address : addresslist) 
 		   		{%>  
		            <tr>
		            	<td><%out.print(address.getAId());%></td>
		                <td><%out.print(address.getAddressLine1());%></td>
				        <td><%out.print(address.getAddressLine2());%></td>
				        <td><%out.print(address.getCity());%></td>
			            <td><%out.print(address.getState());%></td>
			            <td><%out.print(address.getPincode());%></td>
			            <td><%out.print(address.getId()); %></td>
		            </tr>
		          <% }%>  
		        </tbody>
		    </table><br/>
			<div class="container">
		    	<div class="row">
		    		<div class="col-lg-offset-5 col-md-offset-5 col-lg-6 col-md-6">
						<a href="logout.jsp" class="btn btn-primary form-group text-center">Log Out</a>
					</div>
				</div>
			</div>			
		</c:when>
	<c:otherwise>
 			 <table  class="display" cellspacing="0" width="100%"">
		        <thead>
		            <tr>
		               		<th>First Name</th>
		 	                <th>Last Name</th>
		 	                <th>Date Of Birth</th>
		 	                <th>Email</th>
		 	                <th>Password</th>
		 					<th>Gender</th>
		 					<th>Language</th>
		 					<th>Action</th>
		            </tr>
		        </thead>
		        <tbody> 
		            <tr>
		                <td><%out.print(user.getFname());%></td>
				        <td><%out.print(user.getLname());%></td>
				        <td><%out.print(user.getDob());%></td>
			            <td><%out.print(user.getEmail());%></td>
			            <td><%out.print(user.getPassword());%></td>
			            <td><%out.print(user.getGender());%></td>
			            <td><%out.print(user.getLang());%></td>
			            <td>
				         <a href="UpdateServlet?id=<%=user.getId()%>">Edit</a>                  
			             </td>
		            </tr>  
		        </tbody>
		    </table><br/>
		     <table id="example" class="display" cellspacing="0" width="100%"">
		        <thead>
		            <tr>
		            		<th>Address_Id</th>
		               		<th>Street 1</th>
		 	                <th>Street 2</th>
		 	                <th>City</th>
		 	                <th>State</th>
		 	                <th>Pincode</th>
		 					<th>User_Id</th>
		            </tr>
		        </thead>
		        <tbody>
		        <% for (Address useradd : useraddress) 
 		   		{%>  
		            <tr>
		            	<td><%out.print(useradd.getAId());%></td>
		                <td><%out.print(useradd.getAddressLine1());%></td>
				        <td><%out.print(useradd.getAddressLine2());%></td>
				        <td><%out.print(useradd.getCity());%></td>
			            <td><%out.print(useradd.getState());%></td>
			            <td><%out.print(useradd.getPincode());%></td>
			            <td><%out.print(useradd.getId()); %></td>
		            </tr>
		          <% }%>  
		        </tbody>
		    </table><br/>
		    <div class="container">
		    	<div class="row">
		    		<div class="col-lg-offset-5 col-md-offset-5 col-lg-6 col-md-6">
						<a href="logout.jsp" class="btn btn-primary form-group text-center">Log Out</a>
					</div>
				</div>
			</div>	
		</c:otherwise>
	</c:choose>		
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/javascript.js"></script> 
</html>