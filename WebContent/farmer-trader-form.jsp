<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="login-header.jsp"></jsp:include>
	
	<div class="login">
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>Personal Information</h3>
						<div class="row">
							<div class="col-sm-3"></div>
								<div class="jumbotron col-sm-12" style="background-color: white;">
									<div class="form-group">
										<label for="userName">User Name<span style="color: red;">*<span></label> 
										<input type="text" class="form-control" id="userName">
									</div>
									<div class="form-group">
										<label for="cnic">CNIC Number<span style="color: red;">*<span></label> 
										<input type="text" class="form-control cnic" id="cnic">
									</div>
									<div class="form-group">
										<label for="province">Province<span style="color: red;">*<span></label>
										<select class="form-control" id="province">
											<option>Select Province</option>
											<option>Sindh</option>
											<option>Punjab</option>
											<option>KPK</option>
											<option>Balochistan</option>
										</select>
									</div>
									<div class="form-group">
										<label for="city">City<span style="color: red;">*<span></label>
										<select class="form-control" id="city">
											<option>Select City</option>
											<option>Dadu</option>
											<option>Hyderabad</option>
											<option>Karachi</option>
											<option>Sukkur</option>
										</select>
									</div>
									<div class="form-group">
										<label for="">Mobile Number </label> 
										<input type="text" class="form-control mobile-number" id="mobileNumber">
									</div>
									<div class="form-group">
										<label for="">Phone Number </label> 
										<input type="text" data-mask="+92-000-0000000" class="form-control phone-number" id="phoneNumber">
									</div>
									<div class="form-group">
										<label for="">Address:</label> 
										<textarea class="form-control" rows="5" id="address"></textarea>
									</div>
									<div class="form-group">
										<center><input style="margin-top : 25px" type="submit" id="signup-farmer-trader-btn" class="btn btn-primary" value="Continue"></center>
									</div>
								</div>
							</div>	
					</div>
			</div>
		</div>
	<jsp:include page="login-footer.jsp"></jsp:include>
</body>
</html>