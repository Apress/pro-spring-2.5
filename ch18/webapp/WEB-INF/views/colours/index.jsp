<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
        http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Chapter 18 Sample</title>
</head>
<body>
  <h1>Events</h1>
  <p>Links</p>
  <p>Click here for <a href="${flowExecutionUrl}&_eventId=red">RED</a></p>

  <p>Forms</p>  
  <form:form action="${flowExecutionUrl}">
    <p>Please make your choice:</p>
    <p><input type="submit" name="_eventId" value="blue" /></p>
  
    <p><input type="submit" name="_eventId_green" value="Go green!" /></p>
  </form:form>
</body>
</html>