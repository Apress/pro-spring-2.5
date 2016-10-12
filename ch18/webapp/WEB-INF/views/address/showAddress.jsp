<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Web Flow Book Shop</title>
</head>
<body>
  <h1>Shipping Address Details</h1>
 <p>Your shipping address details:</p>
 <form:form modelAttribute="address" >
  <table>
      <tr>
       <td>Address 1: </td>
       <td>${order.shippingAddress.address1}</td>
      </tr>
      <tr>
       <td>Address 2: </td>
       <td>${order.shippingAddress.address2}</td>
      </tr>
      <tr>
       <td>Post code: </td>
       <td>${order.shippingAddress.postcode}</td>
      </tr>
      <tr>
       <td>Town/City: </td>
       <td>${order.shippingAddress.town}</td>
      </tr>
  </table>
</form:form>
</body>
</html>