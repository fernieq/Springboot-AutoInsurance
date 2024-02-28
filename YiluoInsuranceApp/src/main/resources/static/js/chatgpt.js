$(document).ready(function () {
	
	$("#askgpt").click(function (e) {
		 e.preventDefault();
		 if ($("#question").val() == '') {
			 alert("Please Write A Question!")
			 return false
		 } else {
			 $.get("http://localhost:8282/chat?prompt=" + $("#question" ).val(), function (responseText) {
		 	console.log(responseText)
		 	$("#answer").val(responseText);

			})
		}
		 
	})
});
