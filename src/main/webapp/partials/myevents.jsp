<%--
  Created by IntelliJ IDEA.
  User: il-es
  Date: 17/10/2016
  Time: 14:18
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

<%@ include file="header.jsp" %>

<!-- TODO TSZ AJOUTER STYLE -->
<c:if test="${pageContext.request.getAttribute('login-failed') == 'false'}">
    <p style="color:blue"> Welcome !</p>
</c:if>


<div class="mdl-typography--title">Mes évènements</div>

<div class="wrapperCards mdl-shadow--2dp">
    <div>
        <ul class="mdl-list">
            <c:forEach var="event" items="${events}">
                <li class="mdl-list__item">
                    <a href="event/${event.id}" class="mdl-list__item-primary-content">${event.name}</a>
                </li>
            </c:forEach>
        </ul>
        <div class="lowerButton">
            <a href="new" class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored">
                <i class="material-icons">+</i>
            </a>
        </div>
    </div>
</div>

</body>
</html>
