$(document).ready(function() {
    $('#example').DataTable();
} );
// Get value from data table
 $(document).on("click", "#btnMyTest001", function (e) {
     $('#my_modal #age').attr("value", $(this).attr("data-age"));
 })

$(document).ready(function(){
	$('input[rel="txtTooltip"]').tooltip();
});

function myFunction() {
	var fname = document.getElementById('name').value;
	var i;
	var temp=0;
	var t;
	
	if(fname=="")
	{
		document.getElementById('name').style.borderColor="red";
		document.getElementById('fnameerror').innerHTML="Empty first Name";
		return false;
	}
	if(fname.length<3) {
		document.getElementById('name').style.borderColor="red";
		document.getElementById('fnameerror').innerHTML="Please enter minimum 3 Alphabet";
		return false;
	}
	else if(fname != "") {
		for (i=0; i<fname.length; i++)
    	{	
	      t = fname.charCodeAt(i);
	      if((t>=32 && t<=64)||(t>=91 && t<=96)||(t>=123 && t<=127))
	      {
	        temp = 1;
	      }
	      if (temp==1)
	      {
	          document.getElementById('name').style.borderColor = "red";
	          document.getElementById('fnameerror').innerHTML="only alphabets are allowed";
	      }
      	 else
	      {
			document.getElementById('name').style.borderColor="lightgray";
			document.getElementById('name').innerHTML="";
			document.getElementById('fnameerror').innerHTML="";
	      }
    	}
	}	 
    else {
		document.getElementById('name').style.borderColor="lightgray";
		document.getElementById('name').innerHTML="";
		document.getElementById('fnameerror').innerHTML="";
		return true;
	}
}
function lnamevalidate()
{
	var lname = document.getElementById('lastname').value;
	var i;
	var temp=0;
	var t='';
	if (lname == "") {
		document.getElementById('lastname').style.borderColor="red";
		document.getElementById('lnameerror').innerHTML="Empty Last Name";
		return false;
	}
	if(lname.length<3) {
		document.getElementById('lastname').style.borderColor="red";
		document.getElementById('lnameerror').innerHTML="Please enter minimum 3 Alphabet";
		return false;
	}
	if(lname!=""){
		for(i=0;i<lname.length;i++)
		{
			t=lname.charCodeAt(i);
			if((t>=32 && t<=64)||(t>=91 && t<=96)||(t>=123 && t<=127))
			{
				temp=1;
			}
			if(temp==1)
			{
				document.getElementById('lastname').style.borderColor="red";
				document.getElementById('lnameerror').innerHTML="please enter only Alphabet";
			}
			else
			{
				document.getElementById('lastname').style.borderColor="lightgray";
				document.getElementById('lastname').innerHTML="";
				document.getElementById('lnameerror').innerHTML="";
			}
		}
	}
	else
	{
		document.getElementById('lastname').style.borderColor="lightgray";
		document.getElementById('lastname').innerHTML="";
		document.getElementById('lnameerror').innerHTML="";
		return true;
	}
}

function dobvalidate()
{
	var dob = document.getElementById('dob').value;
	var regex = /^(?:(?:(?:0[1-9]|1\d|2[0-8])\/(?:0[1-9]|1[0-2])|(?:29|30)\/(?:0[13-9]|1[0-2])|31\/(?:0[13578]|1[02]))\/[1-9]\d{3}|29\/02(?:\/[1-9]\d(?:0[48]|[2468][048]|[13579][26])|(?:[2468][048]|[13579][26])00))^/;
	if (dob=="") {
		document.getElementById('dob').style.borderColor="red";
		document.getElementById('doberror').innerHTML="Empty Date Of Birth";
		return false;	
	}
//	else if (!(dob.match(regex))) {
//		document.getElementById('dob').style.borderColor="red";
//		document.getElementById('doberror').innerHTML="Enter valid date ";
//		return false;
//	}
	else{
		document.getElementById('dob').style.borderColor="lightgray";
		document.getElementById('dob').innerHTML="";
		document.getElementById('doberror').innerHTML="";
		return true;		
	}
}
function emailvalidate()
{
    var t=1;
    var email = document.getElementById('email').value;
    var regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    if(email=="")
    {
        document.getElementById('error5').innerHTML = "Enter your Email!!";
        document.getElementById('email').style.borderColor = "red";
       return false;
    }
    
    else if(!(email.match(regex))){
    	 document.getElementById('error5').innerHTML = "Enter valid Email!!";
         document.getElementById('email').style.borderColor = "red";
        return false;
      }
    else{
    	document.getElementById('email').style.borderColor="lightgray";
		document.getElementById('error5').innerHTML="";
		document.getElementById('error5').innerHTML="";
		return true;	
    }
}
function passwordvalidate()
{
	var psw = document.getElementById('password').value;
    var t='';
    var x;
    var count_capital =0, count_digit=0, count_small=0, count_special=0;

    if(psw != '' || psw.length > 8 || psw.length < 12){
        document.getElementById('password').style.borderColor="lightgray";
		document.getElementById('password').innerHTML="";
		document.getElementById('passerror').innerHTML="";
    }

    for(x=0;x<psw.length;x++)
    {
        t = psw.charCodeAt(x);
           if(t >= 65 && t <= 90)
        {
            count_capital = 1;
        }

        if (t >= 48 && t <= 57)
        {
            count_digit = 1;
        }

        if((t >= 33 && t <= 47) || (t >= 58 && t <= 64) || (t >= 91 &&t <= 96) || (t >= 123 && t <= 126)){
            count_special = 1;
        }

        if(t >= 97 && t <=122){
            count_small = 1;
        }
    }

    if (count_digit == 1 && count_capital == 1 && count_small == 1 &&count_special == 1)
    {
        document.getElementById('password').style.borderColor="lightgray";
		document.getElementById('password').innerHTML="";
		document.getElementById('passerror').innerHTML="";
		return true;
    }

    else{
     	document.getElementById('password').style.borderColor="red";
		document.getElementById('passerror').innerHTML="please enter valid password";
		return false;   
    }

}
function confirmvalidate()
{
	var psw = document.getElementById('password');
	var psw1 = document.getElementById('confirm');
	if(psw1.value=="")
	{
		document.getElementById('confirm').style.borderColor="red";
		document.getElementById('confirmerror').innerHTML="Empty Confirm password";
		return false; 	
	}
	else if((psw.value)!=(psw1.value))
	{
		document.getElementById('confirm').style.borderColor="red";
		document.getElementById('confirmerror').innerHTML="not match to password";
		return false; 
	}
	else
	{
		document.getElementById('confirm').style.borderColor="lightgray";
		document.getElementById('confirm').innerHTML="";
		document.getElementById('confirmerror').innerHTML="";
		return true;	
	}
}
function gendervalidate()
{
	  var gender = document.getElementsByName('gender');
	  var genValue = false;
	  
      for(var i=0; i<gender.length;i++){
          if(gender[i].checked == true){
        	  document.getElementById('gender').style.borderColor="lightgray";
	      		document.getElementById('gender').innerHTML="";
	      		document.getElementById('gendererror').innerHTML="";
      			return true;	
              genValue = true;    
          }
      }
      
      if(!genValue){
    	  document.getElementById('gender').style.borderColor="red";
	  		document.getElementById('gendererror').innerHTML="select gender";
	  		return false; 
      }
}
function checkvalidate()
{
	var l1 = document.getElementById('lang1');
	var l2 = document.getElementById('lang2');
	var l3 = document.getElementById('lang3');
	if(l1.checked||l2.checked||l3.checked)
	{
		document.getElementById('checkerror').innerHTML="";
		return true;
	}
	else
	{
		document.getElementById('checkerror').innerHTML="select language";
		return false;
	}
}
