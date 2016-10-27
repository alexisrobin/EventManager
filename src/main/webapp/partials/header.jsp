<%--
  Created by IntelliJ IDEA.
  User: il-es
  Date: 26/10/2016
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <div class="mdl-layout--fixed-header  eventManager-header">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row headerText">
                <!-- TODO TSZ revoir icone en version propre -->
                <span class="mdl-layout-title"><img src="${pageContext.request.contextPath}/images/logo.png" /> EventManager</span>
                <div class="mdl-layout-spacer"></div>
                <span id="myEvents"><a href="${pageContext.request.contextPath}/action/events">Mes évènements<img src="${pageContext.request.contextPath}/images/calendar.png" /></a>&nbsp;&nbsp;&nbsp;</span>
                <!-- TODO TSZ changer déconnexion / reconnexion selon la session + ne rien mettre dans login -->
                <span id="disconnect"><a href="${pageContext.request.contextPath}/action/logout">Deconnexion <img src="${pageContext.request.contextPath}/images/logout.png" /></a></span>
            </div>
        </header>
    </div>
</body>
</html>
