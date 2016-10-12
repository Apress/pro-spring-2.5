<%@ include file="/WEB-INF/views/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="styles/main.css" type="text/css" media="screen,projection" />
		<title>Ajax Demo: </title>
		<script type='text/javascript' src='/dwr/interface/DwrService.js'></script>
		<script type='text/javascript' src='/dwr/engine.js'></script>
		<script type='text/javascript' src='/dwr/util.js'></script>
		<script type='text/javascript' src='/scripts/ajaxdemo-script.js'></script>
		<script type="text/javascript">
			<!-- all scripts go here -->
		</script>
    </head>
	<body>
	<h1>Sign Up</h1>
	<form action="index.html">
		<p>
			<label for="user">User</label>
			<input type="text" id="user" name="user" onblur="checkUsernameAvailability(this.value)"/>
		</p>
		<p class="message" id="user_message">User name already exists</p>
		<p>
			<label for="password">Password</label>
			<input type="password" id="password" name="password" />
		</p>
		<!--<p class="message strong" id="password_message">Strong</p>-->
		<p>
			<label for="confirm_password">Confirm Password</label>
			<input type="password" id="confirm_password" name="confirm_password" />
		</p>
		<!--<p class="message" id="confirm_password_message">Passwords do not match</p>-->
		<p>
			<input type="submit" value="Register" id="register" class="button" />
			<input type="reset" value="Clear" class="button cancel" />
		</p>
	</form>
	</body>
</html>
