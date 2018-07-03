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
					<form>
						<div class="key">
							<i class="fa fa-envelope" aria-hidden="true"></i>
							<input  type="text"  name="Email"  required="" id="email"  placeholder="Email">
							<div class="clearfix"></div>
						</div>
						<div class="key">
							<i class="fa fa-lock" aria-hidden="true"></i>
							<input  type="password"  name="Password"  required="" id="password" placeholder="Password">
							<div class="clearfix"></div>
						</div>
						<div class="key">
							<i class="fa fa-lock" aria-hidden="true"></i>
							<input  type="password" name="Confirm Password" id="confirm-password" required="" placeholder="Confirm Password">
							<div class="clearfix"></div>
						</div>
						<center><input type="button" id="signup-continue-btn" class="btn btn-primary" value="Continue"></center>
					</form>
				</div>
			</div>
		</div>
		
	<jsp:include page="login-footer.jsp"></jsp:include>
</body>
</html>