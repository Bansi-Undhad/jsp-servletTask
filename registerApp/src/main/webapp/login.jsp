<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import=" com.javaWebapplicationController.ForgotPassword,com.javaWebApplication.Model.MyDb,com.javaWebApplication.Model.MyDbInterface,com.javaWebApplication.bean.User,java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Conent-Type" conTent="text/html; charset=ISO-8859-1">
        <title>Sign In</title>
        <link href="http://localhost:8080/registerApp/index.jsp" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<script>
function validateForm()
{
	var email = document.getElementById('email').value;
	var psw = document.getElementById('password').value;
	if (email==null || email=="" )
	{
		alert("Please enter email ");
		return false;
	}else if(psw==null || psw==""){
		alert("Please enter Password ");
		return false;
	}
}
</script>
<body>
	
<%-- 	<% String forgotpassword = (String)session.getAttribute("password"); %> --%>
<%-- 	<% System.out.println(forgotpassword); %> --%>
	
	<form action="signin" id="formLogin"  onsubmit="return validateForm();">
	<div class="container">
            <div class="row">
              <div class="col-lg-offset-3 col-md-offset-3 col-lg-6 col-md-6" id="MySignUpForm">
                <center><h4><i class="fa fa-users"></i>Sign In</h4></center>
                
				 <div class="form-group">
                    <span>Email Id* :</span><br />
                      <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                        <input id="email" type="text"  placeholder="Enter Email Id Here.." class="form-control" name="email" onfocusout="emailvalidate()" onkeypress="return preventSpace(event)" />
                      </div>
                      <small id="error5"></small>
                  </div>
                  
                  <div class="form-group">
                    <span>Password* :</span><br />
                      <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                        <input id="password" type="password" rel="textTooltip" title="password contains character between 8-12 must have 1 uppsercase, 1 digit, 1 special character, 1 lower case" name="password" placeholder="Enter Password Here.." class="form-control" onfocusout="passwordvalidate()" oncopy="return false;"/>
                      </div>
                      <small id="passerror"></small>
                  </div>                 
                   <div class="form-group text-center">
                    <input type="submit" id="submit" value="Sign In" class="btn btn-primary" />
                  </div>
                  
                  <div><a href="forgotPassword.jsp">Forgot Password?</a></div>
               </div>
              </div>
             </div>
		</form>
</body> 
<script type="text/javascript" src="js/javascript.js"></script> 	
</html>