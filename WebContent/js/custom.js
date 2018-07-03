$(document).ready(function()
{
	//====================================Employee CRUD ==================================================>>
	fillEmployeeTable();
	$('#employeeTable').DataTable();
	
	$('#city-employee').on('change',function()
	{
		var val = $('#city-employee').val();
		if(val=="Select City")
		{
			alert("Please select a city.");
		}else{
			$.ajax(
			{
				url : "CityServlet",
				type : "POST",
				data : {
					method : "getOfficeByCity",
					cityName : val
				},
				success : function(result)
				{
					
					var v = "";
					$("#office").find("option:not(:first)").remove();
					for(r in result)
					{
						v+="<option value='"+result[r].officeName+"'>"+result[r].officeName+"</option>";
					}
					$('#office').append(v);
				}
			});
		}
	});
	
	$('#add-employee').click(function()
	{
		var val = $('#add-employee').val();
		if(val=="Add Employee")
		{
			var employeeName = $('#employee-name').val();
			var contact = $('#contact').val();
			var address = $('#address').val();
			var cityName = $('#city-employee').val();
			var officeName = $('#office').val();
			if(cityName=="none")
			{
				alert("Please select city.");
			}else if(officeName=="none")
			{
				alert("Please select office.");
			}else{
				$.ajax(
				{
					url : "EmployeeServlet",
					type : "POST",
					data : {
						method : "addEmployee",
						employeeName : employeeName,
						contact : contact,
						address : address,
						cityName : cityName,
						officeName : officeName
					},
					success : function(result)
					{
						if(result>0)
						{
							alert("Record has been added successfully.");
							clearEmployeeFields();
						}else{
							alert("Could not add record,try again.");
						}
					}
				});
			}
		}else if(val=="Update Employee")
		{
			var employeeName = $('#employee-name').val();
			var contact = $('#contact').val();
			var address = $('#address').val();
			var cityName = $('#city-employee').val();
			var officeName = $('#office').val();
			
			if(cityName=="none")
			{
				alert("Please select city.");
			}else if(officeName=="none")
			{
				alert("Please select office.");
			}else{
				var employeeId = $('#employee-id').val();
				$.ajax(
				{
					url : "EmployeeServlet",
					type : "POST",
					data : {
						method : "updateEmployee",
						employeeName : employeeName,
						contact : contact,
						address : address,
						cityName : cityName,
						officeName : officeName,
						employeeId : employeeId
					},
					success : function(result)
					{
						if(result>0)
						{
							alert("Record has been updated successfully.");
							clearEmployeeFields();
						}else{
							alert("Could not update record,try again.");
						}
					}
				});
			}
		}
	});
	
	function clearEmployeeFields()
	{
		$('#employee-name').val("");
		$('#contact').val("");
		$('#address').val("");
		$('#city-employee option:first-child').attr("selected", "selected");
		$('#office option:first-child').attr("selected", "selected");
		$("#office").find("option:not(:first)").remove();
		$("#city-employee").find("option:not(:first)").remove();
		$('#add-employee').val("Add Employee");
		fillEmployeeTable();
	}
	
	function fillEmployeeTable()
	{
		$.ajax
		({
			url : "EmployeeServlet",
			type : "POST",
			data : {
				method : "getAllEmployees"
			},
			success : function(result)
			{
				
				var v = "";
				var t = $('#employeeTable').DataTable();
				t.clear();
				for(r in result)
				{
					var updateRow = "<td><button value='"+result[r].employeeId+"' style='background-color:#00e58b;color:white' class='btn btn-info' id='updateEmployee'>Update Record</button></td>";
					var deleteRow = "<td><button value='"+result[r].employeeId+"' class='btn btn-danger' id='deleteEmployee'>Delete Record</button></td></tr>";
					var row = [result[r].employeeName,result[r].contact,result[r].address,result[r].officeDTO.officeName,result[r].cityDTO.cityName,result[r].cityDTO.provinceDTO.provinceName,updateRow,deleteRow];
					t.row.add(row).draw();
				}
			}
		});
	}
	
	$(document).on('click','#updateEmployee',function()
			{
				var employeeId = $(this).val();
				$.ajax(
				{
					url : "EmployeeServlet",
					type : "POST",
					data : {
						method : "getEmployeeById",
						employeeId : employeeId
					},
					success : function(result)
					{
						$('#employee-name').val(result.employeeName);
						$('#contact').val(result.contact);
						$('#address').val(result.address);
						$("#city-employee").find("option:not(:first)").remove();
						fillCityComboBox();
						//$('#office option:first-child').attr("selected", "selected");
						$("#office").find("option:not(:first)").remove();
						$('#add-employee').val("Update Employee");
						$('#employee-id').val(result.employeeId);
					}
				});
			});
			
			$(document).on('click','#deleteEmployee',function()
			{
				var employeeId = $(this).val();
				$.ajax(
				{
					url : "EmployeeServlet",
					type : "POST",
					data : {
						method : "deleteEmployee",
						employeeId : employeeId
					},
					success : function(result)
					{
						if(result>0)
						{
							alert("Record has been deleted");
							fillOfficeTable();
						}else{
							alert("Record could not be deleted,try again.");
						}
					}
				});		
			});
			
			$('#cancel-employee').click(function()
			{
				clearEmployeeFields();
			});

	
	//====================================End of Employee CRUD ===========================================>>
	//====================================Office CRUD =====================================================>>
	fillProvinceComboBox();
	$('#officeTable').DataTable();
	
	
	$('#add-office').click(function()
	{
		var val = $('#add-office').val();
		var cityName = $('#city-combo').val();
		var officeName = $('#office-name').val();
		var provinceName = $('#provinces').val();
		
		if(val=="Add Office")
		{
			$.ajax(
			{
				url : "OfficeServlet",
				type : "POST",
				data : 
				{
					method : "addOffice",
					cityName : cityName,
					officeName : officeName,
					provinceName : provinceName
				},
				success : function(result)
				{
					if(result>0)
					{
						alert("Record has been added successfully.");
						clearOfficeFields();
					}else{
						alert("Could not add record,try again");
					}
				}
			});
		}
		else{
			var officeId = $('#office-id').val();
			$.ajax(
					{
						url : "OfficeServlet",
						type : "POST",
						data : 
						{
							method : "updateOffice",
							cityName : cityName,
							officeName : officeName,
							provinceName : provinceName,
							officeId : officeId
						},
						success : function(result)
						{
							if(result>0)
							{
								alert("Record has been update successfully.");
								clearOfficeFields();
							}else{
								alert("Could not add update,try again");
							}
						}
					});
		}
	});
	
	function clearOfficeFields()
	{
		$('#office-name').val("");
		$('#provinces option:first-child').attr("selected", "selected");
		$("#city-combo").find("option:not(:first)").remove();
		$('#add-office').val("Add Office");
		fillOfficeTable();
	}
	
	function fillProvinceComboBox()
	{
		$.ajax(
				{
					url : "ProvinceServlet",
					type : "POST",
					data : 
					{
						method : "getAllProvinces"
					},
					success : function(result)
					{
						var v = "";
						for(r in result)
						{
							v+="<option value='"+result[r].provinceName+"'>"+result[r].provinceName+"</option>";
						}
						$('#provinces').append(v);
					}
				});
	}
	
	$('#provinces').on('change',function()
	{
		fillCityWithProvince();
	});
	
	function fillCityWithProvince()
	{
		var province = $('#provinces').val();
		if(province=="Select Province")
		{
			alert("Please select a province.");
		}else{
		
			$.ajax
			({
				url : "CityServlet",
				type : "POST",
				data : {
					method : "getAllCitiesByProvince",
					provinceName : province
				},
				success : function(result)
				{
					
					var v = "";
					$("#city-combo").find("option:not(:first)").remove();
					for(r in result)
					{
						v += "<option value='"+result[r].cityName+"'>"+result[r].cityName+"</option>";
					}
					$('#city-combo').append(v);
				}
			});
		}
	}
	
	fillCityComboBox();
	function fillCityComboBox()
	{
		var province = $('#provinces').val();
		if(province=="Select Province")
		{
			alert("Please select a province.");
		}else{
		
			$.ajax
			({
				url : "CityServlet",
				type : "POST",
				data : {
					method : "getAllCities"
				},
				success : function(result)
				{
					
					var v = "";
					for(r in result)
					{
						v += "<option value='"+result[r].cityName+"'>"+result[r].cityName+"</option>";
					}
					$('#city').append(v);
					$('#city-employee').append(v);
				}
			});
		}
	}
	
	fillOfficeTable();
	function fillOfficeTable()
	{
		$.ajax
		({
			url : "OfficeServlet",
			type : "POST",
			data : {
				method : "getAllOffices"
			},
			success : function(result)
			{
				
				var v = "";
				var t = $('#officeTable').DataTable();
				t.clear();
				for(r in result)
				{
					var updateRow = "<td><button value='"+result[r].officeId+"' style='background-color:#00e58b;color:white' class='btn btn-info' id='updateOffice'>Update Record</button></td>";
					var deleteRow = "<td><button value='"+result[r].officeId+"' class='btn btn-danger' id='deleteOffice'>Delete Record</button></td></tr>";
					var row = [result[r].officeName,result[r].cityDTO.cityName, result[r].cityDTO.provinceDTO.provinceName,updateRow,deleteRow];
					t.row.add(row).draw();
				}
			}
		});
	}
	
	$(document).on('click','#updateOffice',function()
			{
				var officeId = $(this).val();
				$.ajax(
				{
					url : "OfficeServlet",
					type : "POST",
					data : {
						method : "getOfficeById",
						officeId : officeId
					},
					success : function(result)
					{
						$('#office-name').val(result.officeName);
						$('#city-combo').val(result.cityDTO.cityName);
						$('#provinces').val(result.cityDTO.provinceDTO.provinceName);
						$('#add-office').val('Update Office');
						$('#office-id').val(result.officeId);
						fillCityWithProvince();
					}
				});
			});
			
			$(document).on('click','#deleteOffice',function()
			{
				var officeId = $(this).val();
				$.ajax(
				{
					url : "OfficeServlet",
					type : "POST",
					data : {
						method : "deleteOffice",
						officeId : officeId
					},
					success : function(result)
					{
						if(result>0)
						{
							alert("Office has been deleted");
							fillOfficeTable();
						}else{
							alert("City could not be deleted,try again.");
						}
					}
				});		
			});
			
			$('#cancel-office').click(function()
			{
				clearOfficeFields();
			});
	//=====================================Office CRUD END ================================================>>
	//=====================================Province CRUD ==================================================>>
	fillProvince();
	$('#cityTable').DataTable();
	
	function fillProvince()
	{
		$.ajax(
		{
			url : "ProvinceServlet",
			type : "POST",
			data : 
			{
				method : "getAllProvinces"
			},
			success : function(result)
			{
				var v = "";
				for(r in result)
				{
					v+="<option value='"+result[r].provinceName+"'>"+result[r].provinceName+"</option>";
				}
				$('#province').append(v);
			}
		});
	}
	
	
	
	//=====================================City CRUD ==================================================>>
	
	$('#add-city').click(function()
	{
		var val = $('#add-city').val();
		var cityName = $('#city-name').val();
		var provinceName = $('#province').val();
		if(val=="Add City")
		{
			$.ajax(
					{
						url : "CityServlet",
						type : "POST",
						data : {
							method : "addCity",
							cityName : cityName,
							province : provinceName
						},
						success : function(result)
						{
							if(result>0)
							{
								alert("Record has been added.");
								clearCityFields();
								fillCityTable();
							}else{
								alert("Record could not be added,try again.");
							}
						}
					});
		}else if(val=="Update City")
		{
			cityId = $('#city-id').val();
			$.ajax(
					{
						url : "CityServlet",
						type : "POST",
						data : {
							method : "updateCity",
							cityName : cityName,
							province : provinceName,
							cityId : cityId
						},
						success : function(result)
						{
							if(result>0)
							{
								alert("Record has been updated.");
								clearCityFields();
								fillCityTable();
							}else{
								alert("Record could not be updated,try again.");
							}
						}
					});
		}
		
	});
	fillCityTable();
	function fillCityTable()
	{
		$.ajax
		({
			url : "CityServlet",
			type : "POST",
			data : {
				method : "getAllCities"
			},
			success : function(result)
			{
				
				var v = "";
				var t = $('#cityTable').DataTable();
				t.clear();
				for(r in result)
				{
					var updateRow = "<td><button value='"+result[r].cityId+"' style='background-color:#00e58b;color:white' class='btn btn-info' id='updateCity'>Update Record</button></td>";
					var deleteRow = "<td><button value='"+result[r].cityId+"' class='btn btn-danger' id='deleteCity'>Delete Record</button></td></tr>";
					var row = [result[r].cityName, result[r].provinceDTO.provinceName,updateRow,deleteRow];
					t.row.add(row).draw();
				}
			}
		});
	}
	
	$(document).on('click','#updateCity',function()
	{
		var cityId = $(this).val();
		$.ajax(
		{
			url : "CityServlet",
			type : "POST",
			data : {
				method : "getCityById",
				cityId : cityId
			},
			success : function(result)
			{
				//alert(result);
				$('#city-name').val(result.cityName);
				$('#province').val(result.provinceDTO.provinceName);
				$('#add-city').val('Update City');
				$('#city-id').val(result.cityId);
			}
		});
	});
	
	$(document).on('click','#deleteCity',function()
	{
		var cityId = $(this).val();
		$.ajax(
		{
			url : "CityServlet",
			type : "POST",
			data : {
				method : "deleteCity",
				cityId : cityId
			},
			success : function(result)
			{
				if(result>0)
				{
					alert("City has been deleted");
					fillCityTable();
				}else{
					alert("City could not be deleted,try again.");
				}
			}
		});		
	});
	
	$('#cancel-city').click(function()
	{
		clearCityFields();
	});
	
	function clearCityFields()
	{
		$('#city-name').val("");
		//$('#province').attr("Select");
		$('add-city').val("Add City");
	}
	// ====================================END of City CRUD ===========================================>>
	
	
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