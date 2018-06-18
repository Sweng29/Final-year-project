$(document).ready(function()
{
	//Login work : 
	
		$('#continue-login').click(function()
		{
			var emailAddress = $.trim($("#emailAddress").val());			
			if(emailAddress=="")
			{
				alert("Please enter a valid email.");
			}else{
					
				$.ajax(
						{
							url : "LoginServlet",
							type : "POST",
							data : 
							{
								action : "validateEmail",
								email : emailAddress
							},
							success:function(result)
							{
								if(result=="true")
								{
									window.location = "account-security.jsp?email="+emailAddress;
								}else{
									alert("New user? Sign up now.");
								}
							}
					});
			}
		});
		
		$('#loginButton').click(function()
		{
			var emailAddress = $.trim($("#emailAdrress").text());
			var password = $.trim($("#pass").val());
			if(emailAddress=="" || password=="")
			{
				alert("Password field is empty.");
			}else{
					
				$.ajax(
						{
							url : "LoginServlet",
							type : "POST",
							data : 
							{
								action : "validateEmailWithPassword",
								email : emailAddress,
								password : password
							},
							success:function(result)
							{
								if(result!="true")
								{
									alert("Success.");
									//window.location = "account-security.jsp?email="+emailAddress;
								}else{
									alert("New user? Sign up now.");
								}
							}
					});
			}
		});
	//
		
		// <<<<<<<<< =========================Sign UP================================= >>>>>>>>>>>>>>>>>>>>>>>>>
		
			$("#signup-continue-btn").click(function()
			{
				var emailAddress = $.trim($("#email").val());
				var password = $.trim($("#password").val());
				var confirmPassword = $.trim($("#confirm-password").val());
				if(emailAddress=="" || password=="" || confirmPassword=="")
				{
					alert("Some fields are missing.");
				}else if(password!=confirmPassword)
				{
					alert("Password does not match.");					
				}else{
						
					$.ajax(
							{
								url : "LoginServlet",
								type : "POST",
								data : 
								{
									action : "registerUser",
									email : emailAddress,
									password : password,
									confirmPassword : confirmPassword
								},
								success:function(result)
								{
									alert(result);
								}
						});
				}
			});
			
		// <<<<<<<<< =========================Sign UP END================================= >>>>>>>>>>>>>>>>>>>>>>>>>
});