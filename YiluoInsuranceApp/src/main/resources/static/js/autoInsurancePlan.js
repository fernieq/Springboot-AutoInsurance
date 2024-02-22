$(document).ready(function () {
  
  var standardplanclicked = false;
  var premiumplanclicked = false;
  var supremeplanclicked = false;
  var standardPlan = new Object()
	
  // Get a reference to the button
  $("#StandardPlanChoosePlanBtn").click(function () {
    standardplanclicked = true;
    localStorage.setItem('standardplanclicked', standardplanclicked);  
    localStorage.removeItem('premiumplanclicked');
    localStorage.removeItem('supremeplanclicked'); 
    window.location = "/vehicleRegistration";
  });
  
  // Get a reference to the button
  $("#PremiumPlanChoosePlanBtn").click(function () {
    premiumplanclicked = true;
    localStorage.removeItem('standardplanclicked');  
    localStorage.setItem('premiumplanclicked', premiumplanclicked);
    localStorage.removeItem('supremeplanclicked');

    window.location = "/vehicleRegistration";
  });
  
  // Get a reference to the button
  $("#SupremePlanChoosePlanBtn").click(function () {
    supremeplanclicked = true;
    localStorage.removeItem('standardplanclicked');  
    localStorage.removeItem('premiumplanclicked');
    localStorage.setItem('supremeplanclicked', supremeplanclicked);
    window.location = "/vehicleRegistration";
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
  
  
   $("#standardPlanUserSignInBtn").click(function () {
	   window.location = "/signin"
   })
   
   $("#premiumPlanUserSignInBtn").click(function () {
	   window.location = "/signin";
   })
   
   $("#supremePlanUserSignInBtn").click(function () {
	   window.location = "/signin";
   })
   
  $("#StandardPlanPurchaseConfirmBtn").click(function () {
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
	
	localStorage.setItem("insuranceStartDate", standardPlan.startDate);
	localStorage.setItem("insuranceEndDate", standardPlan.endDate);
	localStorage.setItem("insuranceDeductables", standardPlan.deductables);
	localStorage.setItem("insurancePlanType", standardPlan.insuranceType);
	localStorage.setItem("insuranceDuration", standardPlan.duration);
	localStorage.setItem("insuranceFinalCharges", standardPlan.finalCharges);
	localStorage.setItem("insurancePoductName", 
			"Autoinsurance" + " " + 
			standardPlan.insuranceType + "  Plan, " + standardPlan.duration + " month(s).");
	
	window.location = "/payment"
	
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
	
	localStorage.setItem("insuranceStartDate", premiumPlan.startDate);
	localStorage.setItem("insuranceEndDate", premiumPlan.endDate);
	localStorage.setItem("insuranceDeductables", premiumPlan.deductables);
	localStorage.setItem("insurancePlanType", premiumPlan.insuranceType);
	localStorage.setItem("insuranceDuration", premiumPlan.duration);
	localStorage.setItem("insuranceFinalCharges", premiumPlan.finalCharges);
	localStorage.setItem("insurancePoductName", 
			"Autoinsurance" + " " + 
			premiumPlan.insuranceType + "  Plan, " + premiumPlan.duration + " month(s).");
	
	window.location = "/payment"
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
	
	localStorage.setItem("insuranceStartDate", supremePlan.startDate);
	localStorage.setItem("insuranceEndDate", supremePlan.endDate);
	localStorage.setItem("insuranceDeductables", supremePlan.deductables);
	localStorage.setItem("insurancePlanType", supremePlan.insuranceType);
	localStorage.setItem("insuranceDuration", supremePlan.duration);
	localStorage.setItem("insuranceFinalCharges", supremePlan.finalCharges);
	localStorage.setItem("insurancePoductName", 
			"Autoinsurance" + " " + 
			supremePlan.insuranceType + "  Plan, " + supremePlan.duration + " month(s).");
	
	window.location = "/payment"
  });
  
});
