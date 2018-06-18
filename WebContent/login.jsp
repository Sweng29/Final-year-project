<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Agriculture Market || Login</title>
</head>
<body>
	<jsp:include page="login-header.jsp"></jsp:include>
	<div class="login" style="margin-top:8%">
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>Login</h3>
					<form action="account-security.jsp" method="post">
						<div class="key">
							<i class="fa fa-envelope" aria-hidden="true"></i>
							<input  type="text" name="Email" id="emailAddress" required="" placeholder="Email">
							<div class="clearfix"></div>
						</div>
						<center>
							<input type="button" value="Continue" id="continue-login" class="btn btn-info">
							<br/><br/>
							<a href="#" class="forg forg-left">Not you?</a>
						</center>
					</form>
				</div>
				<div class="forg" style="margin-top:8%">
					<a href="#" class="forg-left">Forgot Password</a>
					<a href="register.html" class="forg-right">Register</a>
				<div class="clearfix"></div>
				</div>
			</div>
		</div>
		
	<jsp:include page="login-footer.jsp"></jsp:include>
</body>
</html>