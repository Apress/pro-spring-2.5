<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

Esta página se enumeran todos los productos disponibles:<br>
<c:forEach items="${products}" var="product">
    <c:out value="${product.name}"/>
    <a href="view.html?id=<c:out value="${product.id}"/>">[Ver]</a>&nbsp;
    <a href="edit.html?id=<c:out value="${product.id}"/>">[Editar]</a>&nbsp;<br>
    <hr>
</c:forEach>
<br>
<a href="edit.html">[Añadir]</a>
