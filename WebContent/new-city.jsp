<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>City | Online Agriculture Market</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
		<div class="jumbotron col-sm-6" style="background-color: white;">
		<form id="upload-form">
			<div class="form-group">
				<label for="city">City Name:</label> 
				<input type="text" class="form-control" id="city-name" placeholder="City Name">
			</div>
			<div id='city-id' style="display:none"></div>
			<div class="form-group">
				<label for="category">Province<span style="color: red;">*<span></label>
				<select class="form-control" id="province" required>
					<option value='none'>Select Province</option>
				</select>
			</div>
			<div class="form-group">
				 <input type="button" id="add-city" value="Add City" class="btn btn-primary form-control" style="background-color:#00e58b;color:white">
			</div>
			<div class="form-group">
				 <input type="button" id="cancel-city" value="Cancel" class="btn btn-danger form-control">
			</div>
			<div class="alert alert-success" role="alert" style="display:none" id="alert">
 					 <strong>Success</strong> Added Successfully
			</div>
			</form>
		</div>
		<div class="col-sm-3"></div>
		</div>
	</div>

	<div class="container" style="margin-bottom:40px;margin-top:40px">
		<div class="row">
			<div class="col-sm-12">				
				<table id="cityTable" class="table table-striped table-bordered" style="width:100%">
			        <thead>
			            <tr>
			                <th>City Name</th>
			                <th>Province</th>
			                <th>Update Record</th>
			                <th>Delete Record</th>
			            </tr>
			        </thead>
			        <tbody id='cityTableBody'>
			            
			        </tbody>
			        <tfoot>
			            <tr>
							<th>City Name</th>
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