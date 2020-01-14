var resetButton = document.querySelector(".reset_button");

resetButton.addEventListener("click", function (e) {
	document.getElementsByClassName("name")[0].value = "";
	document.getElementsByClassName("title")[0].value = "";
    var radioButtons = document.getElementsByClassName("priority");
    
    for (var i = 0; i < radioButtons.length; i++) {
        if (radioButtons[i].checked) {
        	radioButtons[i].checked = false;
        	return;
        }
    }
})