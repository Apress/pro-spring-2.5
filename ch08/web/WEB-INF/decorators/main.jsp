<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <title>
        <decorator:title default=""/>
    </title>

    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Expires" content="never"/>
    <meta name="Audience" content="Everyone"/>
    <meta name="ROBOTS" content="INDEX,FOLLOW"/>
    <meta name="revisit-after" content="1 days"/>
    <meta name="Rating" content="general"/>

    <decorator:head/>
</head>

<body>
<div id="leftPanel">
    Here comes navigation
</div>
<div id="body">
    <decorator:body/>
</div>
</body>
</html>