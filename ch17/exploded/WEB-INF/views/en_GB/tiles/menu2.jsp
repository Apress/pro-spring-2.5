<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:forEach items="${menu}" var="item">
	<a href="<c:out value="${item.value}"/>"><c:out value="${item.key}"/></a><br>
</c:forEach>
