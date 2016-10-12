<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
        http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Chapter 18 Sample App</title>
</head>
<body>
  <h1>Web Flow Book Shop</h1>
  <form:form>
    <input type="hidden" name="execution" value="${flowExecutionKey}" />
    <p>Please make your choice:</p>
  
    <p><input type="submit" name="_eventId_admin" value="Enter Admin Area" /></p>
  
    <p><input type="submit" name="_eventId_shop" value="Visit Book Shop" /></p>
  </form:form>
</body>
</html>