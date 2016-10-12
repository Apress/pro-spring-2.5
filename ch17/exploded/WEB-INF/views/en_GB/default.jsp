<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<title>Pro Spring</title>
<link rel="stylesheet" href="<spring:theme code="css"/>">
</head>
<body>
<h1><spring:message code="greeting"/></h1>
<spring:message code="greetings" text="missing me, eh?"/>
</body>
</html>