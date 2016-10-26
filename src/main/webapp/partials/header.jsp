<%--
  Created by IntelliJ IDEA.
  User: il-es
  Date: 26/10/2016
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <div class="mdl-layout--fixed-header  eventManager-header">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <!-- TODO TSZ revoir icone en version propre -->
                <span class="mdl-layout-title"><img src="${pageContext.request.contextPath}/images/logo.png" /> EventManager</span>
                <div class="mdl-layout-spacer"></div>
                <!-- TODO TSZ changer déconnexion / reconnexion selon la session + ne rien mettre dans login -->
                <span>Deconnexion <img src="${pageContext.request.contextPath}/images/logout.png" /></span>
            </div>
        </header>
    </div>
</body>
</html>
