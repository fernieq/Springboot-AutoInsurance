$(document).ready(function () {

	
	$("#insurancePlanType").val(localStorage.getItem('insurancePlanType'))
	$("#insuranceStartDate").val(localStorage.getItem('insuranceStartDate'))
	$("#insuranceEndDate").val(localStorage.getItem('insuranceEndDate'))
	$("#insuranceDeductables").val(localStorage.getItem('insuranceDeductables'))
	$("#insuranceDuration").val(localStorage.getItem('insuranceDuration'))
	$("#insuranceFinalCharges").val(localStorage.getItem('insuranceFinalCharges'))
	$("#insurancePoductName").val(localStorage.getItem('insurancePoductName'))
	
	$("#vehicleVIN").val(localStorage.getItem('vehicleVIN'))
	$("#vehicleModel").val(localStorage.getItem('vehicleModel'))
	$("#vehicleMade").val(localStorage.getItem('vehicleMade'))
	$("#vehicleMileage").val(localStorage.getItem('vehicleMileage'))
	$("#vehicleAlarmType").val(localStorage.getItem('vehicleAlarmType'))
	$("#vehicleDealer").val(localStorage.getItem('vehicleDealer'))
	
	
	$("#vehicleInformationModalEditBtn").click(function () {
		
		window.location("/vehicleRegistration")
	
	})
	
	
})