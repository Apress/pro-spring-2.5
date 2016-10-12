<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Web Flow Book Shop</title>
</head>
<body>
  <h1>Sample Book Shop</h1>
  <table>
    <tr>
     <td><a href="${flowExecutionUrl}&amp;_eventId=all">All</a></td>
     <td><a href="${flowExecutionUrl}&amp;_eventId=computer">Computer</a></td>
     <td><a href="${flowExecutionUrl}&amp;_eventId=children">Children</a></td>
    </tr>
  </table>
  <div id="bookTable">
  <p>This page lists all available books:</p>
  <table>
    <thead>
      <tr>
       <td><b>Author</b></td>
       <td><b>Title</b></td>
       <td><b>Price</b></td>
       <td><b>Adding Date</b></td>
       <td></td>
      </tr>
    </thead>
    <form:form id="bookList">
    <c:forEach items="${books}" var="book">
    <tr>
     <td>${book.author}</td>
     <td>${book.title}</td>
     <td>${book.price}</td>
     <td>${book.addingDate}</td>
     <td><a href="${flowExecutionUrl}&_eventId=view&bookId=${book.id}">View</a></td>     
    </tr>
    </c:forEach>
  </form:form>
  </table>
  </div>
</body>
</html>