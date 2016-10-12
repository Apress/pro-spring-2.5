<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Web Flow Book Shop</title>
</head>
<body>
  <h1>Shipping Address Details</h1>
  <p>Please enter your shipping address details:</p>
    <form:form id="shippingDetails" modelAttribute="address">
      <table>
      <tr>
       <td>Address 1: </td>
       <td><form:input path="address1"/></td>
      </tr>
      <tr>
       <td>Address 2: </td>
       <td><form:input path="address2"/></td>
      </tr>
      <tr>
       <td>Post code: </td>
       <td><form:input path="postcode"/></td>
      </tr>
      <tr>
       <td>Town/City: </td>
       <td><form:input path="town"/></td>
      </tr>
      <tr>
       <td><input type="submit" name="_eventId" value="next"></td>
       <td><input type="submit" name="_eventId" value="admin"></td>
      </tr>
    </table>
  </form:form>
</body>
</html>