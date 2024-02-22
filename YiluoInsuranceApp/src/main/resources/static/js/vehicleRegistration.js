$(document).ready(function () {
	
	$("#vehicleRegistrationForm").submit(function(e) {
    	e.preventDefault();
	})	
	
   	$("#vehicleVIN").val(localStorage.getItem('vehicleVIN'))
	$("#vehicleModel").val(localStorage.getItem('vehicleModel'))
	$("#vehicleMade").val(localStorage.getItem('vehicleMade'))
	$("#vehicleMileage").val(localStorage.getItem('vehicleMileage'))
	$("#vehicleAlarmType").val(localStorage.getItem('vehicleAlarmType'))
	$("#vehicleDealer").val(localStorage.getItem('vehicleDealer'))	
   	
	
  		
  $("#vehicleRegistrationSubmit").click(function () {
    var vehicle = new Object();

    vehicle.vin = $("#vehicleVIN").val();
    vehicle.model = $("#vehicleModel").val();
    vehicle.year = $("#vehicleMade").val();
    vehicle.dealer = $("#vehicleDealer").val();
    vehicle.alarmType = $("#vehicleAlarmType").val();
    vehicle.mileage = $("#vehicleMileage").val();
    
    localStorage.setItem("vehicleVIN", vehicle.vin)
    localStorage.setItem("vehicleModel", vehicle.model)
    localStorage.setItem("vehicleMade", vehicle.year)
    localStorage.setItem("vehicleMileage", vehicle.mileage)
    localStorage.setItem("vehicleAlarmType", vehicle.alarmType)
	localStorage.setItem("vehicleDealer", vehicle.dealer)

    console.log(vehicle);

    /* add the new vehicle info */
    $.ajax({
      url: "http://localhost:8282/addVehicle",
      type: "POST",
      data: JSON.stringify(vehicle),
      dataType: "json",
      contentType: "application/json",
      success: function () {
		alert("Vehicle information has been captured.")
	
		if (localStorage.getItem('standardplanclicked')) {
			window.location = "/standardPlan";
		} else if (localStorage.getItem('premiumplanclicked')) {
			window.location = "/premiumPlan";
		} else if (localStorage.getItem('supremeplanclicked')){
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
  
});
