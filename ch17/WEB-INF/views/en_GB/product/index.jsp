<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

This page lists all available products:<br>
<c:forEach items="${products}" var="product">
    <c:out value="${product.name}"/>
    <a href="view.html?id=<c:out value="${product.id}"/>">[View]</a>&nbsp;
    <a href="edit.html?id=<c:out value="${product.id}"/>">[Edit]</a>&nbsp;<br>
    <hr>
</c:forEach>
<br>
<a href="edit.html">[Add]</a>
