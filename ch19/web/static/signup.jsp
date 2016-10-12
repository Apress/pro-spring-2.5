<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="content-type"  content="text/html;charset=utf-8" />
	<title>Simple jsp page</title>
	<link rel="stylesheet" type="text/css" href="/styles/main.css" />
</head>
<body>
<h1>Sign Up</h1>
<form action="signup.jsp">
	<p>
		<label for="user">User</label>
		<input type="text" id="user" name="user" />
	</p>
	<p class="message" id="user_message">User name already exists</p>
	<p>
		<label for="password">Password</label>
		<input type="password" id="password" name="password" />
	</p>
	<p class="message strong" id="password_message">Strong</p>
	<p>
		<label for="confirm_password">Confirm Password</label>
		<input type="password" id="confirm_password" name="confirm_password" />
	</p>
	<p class="message" id="confirm_password_message">Passwords do not match</p>
	<p>
		<input type="submit" value="Register" id="register" class="button" />
		<input type="reset" value="Clear" class="button cancel" />
	</p>
</form>
</body>
</html>