<%--
  Created by IntelliJ IDEA.
  User: il-es
  Date: 26/10/2016
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <div class="mdl-layout--fixed-header  eventManager-header">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row headerText">
                <span class="mdl-layout-title"><img src="${pageContext.request.contextPath}/images/logo.png" /> EventManager</span>
                <div class="mdl-layout-spacer"></div>
                <c:if test="${pageContext.request.getAttribute('isLogged') == 'true'} && ${pageContext.request.getAttribute('isOnEvents') == 'false'}">
                    <span id="myEvents"><a href="${pageContext.request.contextPath}/action/events">Mes évènements<img src="${pageContext.request.contextPath}/images/calendar.png" /></a>&nbsp;&nbsp;&nbsp;</span>
                </c:if>
                <!-- TODO TSZ changer déconnexion / reconnexion selon la session + ne rien mettre dans login -->
                <c:if test="${pageContext.request.getAttribute('isLogged') != null}">
                    <c:if test="${pageContext.request.getAttribute('isLogged') == 'false'}">
                        <span id="connect">
                            <a href="${pageContext.request.contextPath}/action/login">Connexion <img src="${pageContext.request.contextPath}/images/login.png" /></a>
                        </span>
                    </c:if>
                    <c:if test="${pageContext.request.getAttribute('login-failed') == 'true'}">
                        <span id="disconnect">
                            <a href="${pageContext.request.contextPath}/action/logout">Deconnexion <img src="${pageContext.request.contextPath}/images/logout.png" /></a>
                        </span>
                    </c:if>
                </c:if>
            </div>
        </header>
    </div>
</body>
</html>
