<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
          "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yes or No?</title>
</head>
<body>
<h1>Are you sure?</h1>
<form:form id="yesno">
<input type="submit" name="_eventId" value="Yes" />
<br/>
<br/>
<input type="submit" name="_eventId" value="No" />
</form:form>
</body>
</html>