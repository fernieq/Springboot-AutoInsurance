$(document).ready(function () {
	
  var user = new Object();
    
  $("#signUpForm").submit(function(e) {
    	e.preventDefault();
	})	
	
  $("#UserSignUpBtn").click(function () {
	    user.userName = $("#customerName").val();
	    user.userPassword = $("#customerPassword").val();
	    user.userGender = $("#customerGender").val();
	    user.userDOB = $("#customerDOB").val();
	    user.userMobile = $("#customerMobile").val();
	    user.userEmail = $("#customerEmail").val();
	
	    /* i could add some validation here */
	
	    /* add the new user info */
	    $.ajax({
	      url: "http://localhost:8282/addUser",
	      type: "POST",
	      data: JSON.stringify(user),
	      dataType: "json",
	      contentType: "application/json",
	      success: function () {
			  alert("user has been added successfully")
	        //window.location("/signin")
	      },
	      error: function () {
	        alert("Something went wrong.");
	      },
	    });
  })
  
});
