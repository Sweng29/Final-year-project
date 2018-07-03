<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<jsp:include page="login-header.jsp"></jsp:include>
	<div class="login"  style="margin-top:8%">
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>Welcome</h3>
					<center><h5></h5></center>
					<form style="margin-top:10%">
						
						<div class="key">
							<i class="fa fa-lock" aria-hidden="true"></i>
							<input  type="password" name="Password" id="pass" required="" placeholder="Password">
							<div class="clearfix"></div>
						</div>
						<div style="display:none" id="emailAdrress"><%=request.getParameter("email")%></div>
						<center><input type="button" value="Login" id="loginButton" class="btn btn-info btn-block"></center>
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