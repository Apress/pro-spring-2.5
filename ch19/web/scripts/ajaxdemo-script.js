function checkUsernameAvailability(username) {
	DwrService.usernameAvailability(username, displayStatus);
	return false;
}

function displayStatus(nameStatus){
	if (!nameStatus) {
		$("user_message").style.visibility = "visible";
	} else {
		$("user_message").style.visibility = "hidden";
	}
}