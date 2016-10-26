<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 24/10/2016
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
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
<div class="wrapperCards mdl-shadow--2dp">
    <div>${event.name}</div>
    <div>${event.address}</div>
    <div>${event.startDate}</div>
    <div>${event.endDate}</div>
</div>
<br/>
<c:choose>
    <c:when test="${isManageable}">
        <div class="wrapperCards mdl-shadow--2dp">
            <ul class="mdl-list">
                <c:forEach var="registrant" items="${registrants}">
                    <li class="mdl-list__item">
                        <span class="mdl-list__item-primary-content">${registrant.getFullName()}</span>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:when>
    <c:otherwise>
        <button class="submitbutton mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
            S'inscrire à l'évènement
        </button>
    </c:otherwise>
</c:choose>
</body>
</html>
