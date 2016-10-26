<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 24/10/2016
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/eventManager.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/material.css"/>
    <title>Event Manager</title>
</head>
<body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/material.js"></script>

<div class="mdl-typography--title">${event.name}</div>

</body>
</html>
