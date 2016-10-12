<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <c:set var="css"><spring:theme code="css"/></c:set>
   	<c:if test="${not empty css}"><link rel="stylesheet" href="<c:url value="${css}"/>" type="text/css" /></c:if>
		
	<tiles:insertAttribute name="meta"/>
	<title><tiles:getAsString name="title"/></title>
</head>
<body>
<table cellspacing="1" cellpadding="1" border="1" width="700px" align="center" bgcolor="#ffffff">
	<tr>
		<td colspan="2"><tiles:insertAttribute name="header"/></td>
	</tr>
	<tr>
		<td colspan="2"><tiles:insertAttribute name="toolbar"/></td>
	</tr>
	<tr height="400px">
		<td width="150px" valign="top"><tiles:insertAttribute name="menu"/></td>
		<td width="550px" valign="top"><tiles:insertAttribute name="body"/></td>
	</tr>
	<tr>
		<td colspan="2"><tiles:insertAttribute name="footer"/></td>
	</tr>
</table>

</body>
</html>
