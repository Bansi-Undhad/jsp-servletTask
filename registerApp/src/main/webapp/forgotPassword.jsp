<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Forgot Password</title>
		<link href="http://localhost:8080/registerApp/index.jsp" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.43/css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	
	<form class="form-horizontal" action="ForgotPassword" name="form1" method="post">
	<div class="container">
            <div class="row">
              <div class="col-lg-offset-3 col-md-offset-3 col-lg-6 col-md-6" id="MySignUpForm">
                <h4 align="center">Forgot Password</h4>
                
                <div class="form-group">
                	<span>Email Id* :</span><br />
	                 <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                        <input id="email" type="text" placeholder="Enter Email Id Here.." class="form-control" name="email" onfocusout="emailvalidate()" onkeypress="return preventSpace(event)" />
                      </div>
	               <small id="error5"></small>
            	</div>

	            <div class="form-group">
	            	<button type="submit" id="submit" class="btn btn-default submit" style="background-color:lightgray;"><b>Click here to get your password</b></button>                        
	            </div>
            
            </div>
           </div>
          
    </div>
    </form>
	
</body>
</html>