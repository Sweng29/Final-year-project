$(document).ready(function()
{
	// Masking
		 $('.cnic').mask('00000-0000000-0',{placeholder: "41201-5512435-6"},{clearIfNotMatch: true});
		 $('.mobile-number').mask('+92-000-0000000',{placeholder: "+92-343-5512435"},{clearIfNotMatch: true});
		 $('.phone-number').mask('+92-21-00000000',{placeholder: "+92-21-5512435"},{clearIfNotMatch: true});		 
		 
		//Login work : 
			
		$('#continue-login').click(function(event)
		{
			//event.preventDefault();
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
									window.location = "account-security.jsp";
								}else{
									 alertify.error('Provided email is not registered.');
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
				 alertify.error('Email or password field is empty.');
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
								if(result!="false")
								{
									alertify.success('Successfully logged in.');
									window.location = "index.jsp";
								}else if(result=="false"){
									 alertify.error('Password does not match.');
								}
							}
					});
			}
		});
	//
		
		// <<<<<<<<< =========================Sign UP================================= >>>>>>>>>>>>>>>>>>>>>>>>>
		
			$("#signup-continue-btn").click(function()
			{
				event.preventDefault();
				var emailAddress = $.trim($("#email").val());
				var password = $.trim($("#password").val());
				var confirmPassword = $.trim($("#confirm-password").val());
				if(emailAddress=="" || password=="" || confirmPassword=="")
				{
					 alertify.error('Some fields are missing.');
				}else if(password!=confirmPassword)
				{
					 alertify.error('Password and Confirm password fields does not match.');					
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
									if(result=="false")
									{
										alertify.error('Email already exists.');
									}else if(result=="record added")
									{
										window.location = "farmer-trader-form.jsp";										
									}else if(result=="error")
									{
										alertify.error('Could not regiter right now.');
									}
									
								}
						});
				}
			});
			
			$('#signup-farmer-trader-btn').click(function()
			{
				var userName = $('#userName').val();
				var cnic = $('#cnic').cleanVal();
				var province = $('#province').val();
				var city = $('#city').val();
				var mobileNumber = $('#mobileNumber').cleanVal();
				var phoneNumber = $('#phoneNumber').cleanVal();
				var address = $('#address').val();
				
				$.ajax({
					url : "FarmerTraderServlet",
					type : "POST",
					data : 
					{
						action : "addFarmer",
						userName : userName,
						cnic : cnic,
						province : province,
						city : city,
						mobileNumber : mobileNumber,
						phoneNumber : phoneNumber,
						address : address
					},
					success : function(result)
					{
						alert(result);
					}
				})
				
				
			});
			
		// <<<<<<<<< =========================Sign UP END================================= >>>>>>>>>>>>>>>>>>>>>>>>>
			
		// <<<<<<<<< =========================View Products================================= >>>>>>>>>>>>>>>>>>>>>>>>>	
		getAllSellingProducts();
		function getAllSellingProducts()
		{
			alert("Getting all products.");
			$.ajax(
			{
				url : "SellingProductServlet",
				type : "POST",
				data : 
				{
					method : "getAllSellingProducts"
				},
				success : function(result)
				{
					var r = "";
					for(c in result)
					{
						r+"<div class='women-set1'>";
						r+="<div class='col-md-4 women-grids wp1 animated wow slideInUp' data-wow-delay='.5s'>";
						r+="<a href='single.html'><div class='product-img'>";
						//for(i in result[c].images)
						//{
							r+="<img src='"+result[c].images[0].imagePath+"' alt='' />";
						//}
						r+="<div class='p-mask'>";
						r+="<form action='#' method='post'>";
						r+="<input type='hidden' name='cmd' value='_cart' />";
						r+="<input type='hidden' name='add' value='1' /> ";
						r+="<input type='hidden' name='w3ls1_item' value='Casual shirt' />";
						r+="<input type='hidden' name='amount' value='50.00' />";
						r+="<button type='submit' class='w3ls-cart pw3ls-cart'><i class='fa fa-cart-plus' aria-hidden='true'></i> Add to cart</button>";
						r+="</form>";
						r+="</div>";
						r+="</div></a>";
						r+="<i class='fa fa-star yellow-star' aria-hidden='true'></i>";
						r+="<i class='fa fa-star yellow-star' aria-hidden='true'></i>";
						r+="<i class='fa fa-star yellow-star' aria-hidden='true'></i>";
						r+="<i class='fa fa-star yellow-star' aria-hidden='true'></i>";
						r+="<i class='fa fa-star gray-star' aria-hidden='true'></i>";
						r+="<h4>"+result[c].productName+"</h4>";
						r+="<h5>"+result[c].minPrice+"</h5>";
						r+="</div>";
						
					}
					r+="<div class='clearfix'></div>";
					r+="</div>";
					$( "#test" ).append(r);
				}
			});
		}
			
		// <<<<<<<<< =========================View Products END================================= >>>>>>>>>>>>>>>>>>>>>>>>>		
});