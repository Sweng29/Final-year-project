<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee | Online Agriculture Market</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<div class="row">
		<div class="col-sm-3"></div>
			<div class="jumbotron col-sm-6" style="background-color: white;">
			<form id="upload-form" >
				<div class="form-group">
					<label for="employee-name">Employee Name<span style="color: red;">*<span></label> 
					<input type="text" class="form-control" id="employee-name" placeholder="Employee Name">
				</div>
				<div class="form-group">
					<label for="contact">Contact<span style="color: red;">*<span></label> 
					<input type="text" class="form-control" id="contact"  placeholder="Contact Number">
				</div>
				<div class="form-group">
					<label for="city-employee">Select City<span style="color: red;">*<span></label>
					<select class="form-control" id="city-employee">
						<option value="none">Select City</option>
					</select>
				</div>
				<div class="form-group">
					<label for="office">Select Office<span style="color: red;">*<span></label>
					<select class="form-control" id="office">
						<option value="none">Select Office</option>
					</select>
				</div>
				<div class="form-group">
					<label for="address">Address</label> 
					<textarea rows="5" cols="63" placeholder="Enter Address" id='address'></textarea>
				</div>
				<div id='employee-id' style="display:none"></div>
				<div class="form-group">
					 <input type="button" id="add-employee" value="Add Employee" class="btn btn-primary form-control" style="background-color:#00e58b;color:white">
				</div>
				<div class="form-group">
					 <input type="button" id="cancel-employee" value="Cancel" class="btn btn-danger form-control">
				</div>
			</form>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<div class="container" style="margin-bottom:40px;margin-top:40px">
		<div class="row">
			<div class="col-sm-12">				
				<table id="employeeTable" class="table table-striped table-bordered" style="width:100%">
			        <thead>
			            <tr>
			                <th>Employee Name</th>
			                <th>Contact</th>
			                <th>Address</th>
			                <th>Office</th>
			                <th>City</th>
			                <th>Province</th>
			                <th>Update Record</th>
			                <th>Delete Record</th>
			            </tr>
			        </thead>
			        <tbody id='employeeTableBody'>
			            
			        </tbody>
			        <tfoot>
			            <tr>
			                <th>Employee Name</th>
			                <th>Contact</th>
			                <th>Address</th>
			                <th>Office</th>
			                <th>City</th>
			                <th>Province</th>
			                <th>Update Record</th>
			                <th>Delete Record</th>
			            </tr>
			        </tfoot>
			    </table>
			</div>
		</div>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>