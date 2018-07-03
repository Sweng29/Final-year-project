<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Product |Online Agriculture Market</title>
<style>
.form-group {
	margin: 30px;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/notify.js"></script>
	<script src="js/bootstrap-notify.js"></script>
	<script>
	$(document).ready(function (){
		
     	$.ajax({
	   url:"SellingProductServlet",
	   method:"post",
	   data:{
		   method:"getAllCategories",
	   },
	   success:function(a){
		   for(x in a){
			   $("#category").append("<option>"+a[x].category+"</option>");
		   }
		   
	   }
   });
   $.ajax({
	  url:"SellingProductServlet",
	  method:"post",
	  data:{
		  method:"getAllQualites"
	  },
	  success:function(a){
		for(x in a){
			$("#quality").append("<option>"+a[x].quality+"</option>");
			
		}
	  }
   });
  
	$("#btn").click(function (){
    	
		
		
 	    if($("#product").val()==""){
 	  		$("#product").notify("Empty Field Not Allowed!!!!",{
 				  
 				  position:"right"
 			  });
 	  	}else if($("#category option:selected").index()==0){
 	  		$("#category").notify("Select Category!!!!",{
 				  
 				  position:"right"
 			  });
 	  	}else if($("#quantity").val()==""){
 	  		$("#quantity").notify("Empty Field Not Allowed!!!!",{
 				  
 				  position:"right"
 			  });
 	  	}else if($("#quality option:selected").index()==0){
 	  		$("#quality").notify("Select Quality!!!!",{
 				  
 				  position:"right"
 			  });	
 	  	}else if($("#date").val()==""){
 	  		$("#date").notify("Empty Field Not Allowed!!!!",{
 				  
 				  position:"right"
 			  });
 	  	}else if($("#price").val()==""){
 	 	  		$("#price").notify("Empty Field Not Allowed!!!!",{
 	 				  
 	 				  position:"right"
 	 			  });
 	  	}else{ 
 	        //stop submit the form, we will post it manually.
 	        event.preventDefault();

 	        
 	        // Get form
 	        var form = $('#upload-form')[0];

 			// Create an FormData object
 	        var data = new FormData(form);
 			// If you want to add an extra field for the FormData
 	        data.append("productName",$("#product").val());
             data.append("category",$("#category option:selected").index());
             data.append("quantity",$("#quantity").val());
             data.append("quality",$("#quality option:selected").index());
             data.append("minprice",$("#price").val());
             data.append("endingdate",$("#date").val());
        	// disabled the submit button
 	        $("#btn").prop("disabled", true);

 	        $.ajax({
 	            type: "POST",
 	            enctype: 'multipart/form-data',
 	            url: "SellingProductServlet",
 	            data:data,
 	            processData: false,
 	            contentType: false,
 	            cache: false,
 	            timeout: 600000,
 	            success: function (data) {
 	            	
 	            	$("#product").val("");
  	                $("#category").val("");
  	                $("#quantity").val("");
  	                $("#quality").val("");
  	                $("#price").val("");
  	                $("#date").val("");
  	                
  	                $("#alert").show();
  	                $("#alert").hide(5000);
 	                console.log("SUCCESS : ", data);
 	                $("#btn").prop("disabled", false);

 	            },
 	            error: function (e) {
 	                console.log("ERROR : ", e);
 	                $("#btn").prop("disabled", false);

 	            }
 	        });
 		
 	  		} 

});
	});
	
	</script>
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="jumbotron col-sm-6" style="background-color: white;">
		<form id="upload-form"  action="SellingProductServlet" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="product">Product Name:</label> <input type="text"
					class="form-control" id="product">
			</div>
			<div class="form-group">
				<label for="category">Category<span style="color: red;">*<span></label>
				<select class="form-control" id="category">
					<option>Select Category</option>
				</select>
			</div>
			<div class="form-group">
				<label for="quantity">Quantity:</label> <input type="text"
					class="form-control" id="quantity">
			</div>
			<div class="form-group">
				<label for="quality">Quality<span style="color: red;">*<span></label>
				<select class="form-control" id="quality">
					<option>Select Quality</option>
				</select>
			</div>
			<div class="form-group">
				<label for="date">End Date</label> <input type="date"
					class="form-control" id="date">
			</div>
			<div class="form-group">
				<label for="price">Minimum Price</label> <input type="text"
					class="form-control" id="price">
			</div>
			 <div class="form-group">
			  <label for="file">Upload Images<span style="color:red;">*<span></label>		       
              <input type="file" id="file" name="file1" accept="image/*"  multiple="muliple" required/><br>
				</div>	
			<div class="form-group">
				 <input type="button" id="btn" value="Post Product" class="btn form-control" style="background-color:#00e58b;color:white">
			</div>
			<div class="alert alert-success" role="alert" style="display:none" id="alert">
  <strong>Success</strong> Posted Successfully
</div>
			</form>
			
			
		</div>

		<div class="col-sm-3"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>