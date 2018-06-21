<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<jsp:include page="login-header.jsp"></jsp:include>
	
		<div class="login">
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>Register</h3>
					<div class="row">
							<div class="col-sm-3"></div>
								<div class="jumbotron col-sm-12" style="background-color: white;">
									<div class="form-group" >
										<label for="email">Email Address:</label> 
										<input type="email" name="Email" id="email" class="form-control" placeholder="Email Address">
									</div>
									<div class="form-group">
										<label for="password">Password:</label> 
										<input class="form-control" type="password"  name="Password"  required="" id="password" placeholder="Password">
									</div>
									<div class="form-group fieldsSpacing">
										<label for="">Confirm Password:</label> 
										<input class="form-control" type="password" name="Confirm Password" id="confirm-password" required="" placeholder="Confirm Password">
									</div>
									<center><input type="submit" id="signup-continue-btn" class="btn btn-primary" value="Continue"></center>
								</div>
							</div>
						</div>
					</div>
				</div>
	<jsp:include page="login-footer.jsp"></jsp:include>
</body>
</html>