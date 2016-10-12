<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Web Flow Book Shop</title>
</head>
<body>
  <h1>View book details</h1>
  <table>
    <thead>
      <tr>
       <td>Author</td>
       <td>Title</td>
       <td>Price</td>
       <td>Adding Date</td>
      </tr>
    </thead>
    <form:form id="viewBook">
    <tr>
     <td>${book.author}</td>
     <td>${book.title}</td>
     <td>${book.price}</td>
     <td>${book.addingDate}</td>
    </tr>
    <tr>
     <td colspan="4">
     ${book.description}
     </td>
    </tr>
    <tr>
     <td><input type="submit" name="_eventId_shop" value="Back to Shop" /></td>
     <td><input type="hidden" name="bookId" value="${book.id}" /></td>
     <td></td>
     <td><input type="submit" name="_eventId_buy" value="Buy" /></td>
    </tr>
  </form:form>
  </table>
</body>
</html>