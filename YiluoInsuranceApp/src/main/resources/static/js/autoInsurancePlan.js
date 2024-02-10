$(document).ready(function () {
  
  var standardplanclicked = false;
  var premiumplanclicked = false;
  var supremeplanclicked = false;

  // Get a reference to the button
  $("#StandardPlanChoosePlanBtn").click(function () {
    standardplanclicked = true;
    window.location = "/standardPlan";
  });
  
  // Get a reference to the button
  $("#PremiumPlanChoosePlanBtn").click(function () {
    premiumplanclicked = true;
    window.location = "/premiumPlan";
  });
  
  // Get a reference to the button
  $("#SupremePlanChoosePlanBtn").click(function () {
    supremeplanclicked = true;
    window.location = "/supremePlan";
  });
	
		
  $("#autoInsurancePlanUserRegistrationSubmit").click(function () {
    var user = new Object();
    var address = new Object();

    user.userName = $("#customerName").val();
    user.userAge = $("#customerAge").val();
    user.userGender = $("#customerGender").val();
    user.userDOB = $("#customerDOB").val();
    user.userMobile = $("#customerMobile").val();
    user.userEmail = $("#customerEmail").val();

    address.addressLine = $("#customerAddressLine").val();
    address.city = $("#customerCity").val();
    address.state = $("#customerState").val();
    address.country = $("#customerCountry").val();
    address.zipcode = $("#customerZipcode").val();

    user.userAddress = address;
    console.log(user);

    /* add the new user info */
    $.ajax({
      url: "http://localhost:8282/addUser",
      type: "POST",
      data: JSON.stringify(user),
      dataType: "json",
      contentType: "application/json",
      success: function () {
        alert("You have submitted your information successfully! Now directing you to the plan.");
        if (standardplanclicked) {
			window.location = "/standardPlan";
		} else if (premiumplanclicked) {
			window.location = "/premiumPlan";
		} else if (supremeplanclicked){
			window.location = "/supremePlan";
		} else {
			window.location = "/autoInsurancePlan";
		}
      },
      error: function () {
        alert("Something went wrong.");
      },
    });
  });
  
  /* this part is for individual plan */
  
  
   $("#StandardPlanUserSignUp").click(function () {
	   location.href = "/signup";
   })
   
   $("#PremiumPlanUserSignUp").click(function () {
	   window.location = "/signup";
   })
   
   $("#SupremePlanUserSignUp").click(function () {
	   window.location = "/signup";
   })
   
  $("#StandardPlanPurchaseConfirmBtn").click(function () {
	var standardPlan = new Object()
	standardPlan.startDate = $("#insurancePlanStartDate").val();
	standardPlan.endDate = $("#insurancePlanEndDate").val();
	standardPlan.deductables = 99
	standardPlan.price = 999;
	standardPlan.insuranceType = "STANDARD"
	
	function monthDiff(d1, d2) {
	    var months;
	    d1 = new Date(d1)
	    d2 = new Date(d2)
	    months = (d2.getFullYear() - d1.getFullYear()) * 12;
	    months -= d1.getMonth();
	    months += d2.getMonth();
	    return months <= 0 ? 0 : months;
	}
	
	standardPlan.duration = monthDiff(standardPlan.startDate, standardPlan.endDate)
	standardPlan.finalCharges = standardPlan.duration * standardPlan.price - standardPlan.deductables
	//console.log(standardPlan)
	
	/* add the new insurance plan info */
    $.ajax({
      url: "http://localhost:8282/addPlan",
      type: "POST",
      data: JSON.stringify(standardPlan),
      dataType: "json",
      contentType: "application/json",
      success: function () {
        alert("You have submitted your information .");
        location.href = "/planPayment"
      },
      error: function () {
        alert("Something went wrong.");
      },
    });
  });
  
  
  $("#PremiumPlanPurchaseConfirmBtn").click(function () {
	var premiumPlan = new Object()
	premiumPlan.startDate = $("#insurancePlanStartDate").val();
	premiumPlan.endDate = $("#insurancePlanEndDate").val();
	premiumPlan.deductables = 299
	premiumPlan.price = 1999;
	premiumPlan.insuranceType = "PREMIUM"
	
	function monthDiff(d1, d2) {
	    var months;
	    d1 = new Date(d1)
	    d2 = new Date(d2)
	    months = (d2.getFullYear() - d1.getFullYear()) * 12;
	    months -= d1.getMonth();
	    months += d2.getMonth();
	    return months <= 0 ? 0 : months;
	}
	
	premiumPlan.duration = monthDiff(premiumPlan.startDate, premiumPlan.endDate)
	premiumPlan.finalCharges = premiumPlan.duration * premiumPlan.price - premiumPlan.deductables
	//console.log(standardPlan)
	
	/* add the new insurance plan info */
    $.ajax({
      url: "http://localhost:8282/addPlan",
      type: "POST",
      data: JSON.stringify(premiumPlan),
      dataType: "json",
      contentType: "application/json",
      success: function () {
        alert("You have submitted your information .");
        location.href = "/planPayment"
      },
      error: function () {
        alert("Something went wrong.");
      },
    });
  });
  
  
  $("#SupremePlanPurchaseConfirmBtn").click(function () { 
  	var supremePlan = new Object()
	supremePlan.startDate = $("#insurancePlanStartDate").val();
	supremePlan.endDate = $("#insurancePlanEndDate").val();
	supremePlan.deductables = 599
	supremePlan.price = 3999;
	supremePlan.insuranceType = "SUPREME"
	
	function monthDiff(d1, d2) {
	    var months;
	    d1 = new Date(d1)
	    d2 = new Date(d2)
	    months = (d2.getFullYear() - d1.getFullYear()) * 12;
	    months -= d1.getMonth();
	    months += d2.getMonth();
	    return months <= 0 ? 0 : months;
	}
	
	supremePlan.duration = monthDiff(supremePlan.startDate, supremePlan.endDate)
	supremePlan.finalCharges = supremePlan.duration * supremePlan.price - supremePlan.deductables
	//console.log(supremePlan)
	
	/* add the new insurance plan info */
  	$.ajax({
      url: "http://localhost:8282/addPlan",
      type: "POST",
      data: JSON.stringify(supremePlan),
      dataType: "json",
      contentType: "application/json",
      success: function () {
        alert("You have submitted your information .");
        location.href = "/planPayment"
      },
      error: function () {
        alert("Something went wrong.");
      },
    });
  });
  
});
