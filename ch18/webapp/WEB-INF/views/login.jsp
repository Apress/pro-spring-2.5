<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Web Flow Book Shop</title>
</head>
<body>
  <h1>Admin login</h1>
  <!-- 
  <div id="usernames">
    <c:choose>
      <c:when test="${empty users}">
        <p><a href="${flowExecutionUrl}&amp;_eventId=cheat">cheat</a></p>
      </c:when>
      <c:otherwise>
        <p>Existing username / password combinations:</p>
        <ul>
        <c:forEach var="user" items="${users}">
          <li>${user.username}/${user.password}</li>
        </c:forEach>
        </ul>
      </c:otherwise>
    </c:choose>
  </div> -->
  
  <form:form id="login" method="post" action="/ch18/j_spring_security_check">
    <table>
      <tr>
        <td><label>Username: </label></td>
        <td><input type="text" id="j_username" name="j_username"/></td>
      </tr>
      <tr>
        <td><label>Password: </label></td>
        <td><input type="text" id="j_password" name="j_password"/></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" name="submit" value="Login"/></td>
      </tr>
    </table>
  </form:form>
</body>
</html>