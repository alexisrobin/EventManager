<%--
  Created by IntelliJ IDEA.
  User: il-es
  Date: 17/10/2016
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/eventManager.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/material.css"/>
    <title>Event Manager</title>
</head>
<body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/material.js"></script>
<script type="text/javascript">
    var event1 = {};
    event1.name = "Manger des moignons chez Maman";
    var event2 = {};
    event2.name = "Soirée raclette chez Jacquie et Michel";
    var event3 = {};
    event3.name = "FESTIVAL DE MALADE TECHNO TECHNO"
    var events = [];
    events.push(event1, event2, event3);
    console.log(events);
</script>

<div class="mdl-typography--title">Mes évènements</div>

<div class="wrapperEvents mdl-shadow--2dp">
    <div>
        <ul>
            <c:forEach var="event" items="${events}">
                <li>${event.nom}</li>
            </c:forEach>
        </ul>
        <div class="lowerButton">
            <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored">
                <i class="material-icons">+</i>
            </button>
        </div>
    </div>
</div>

</body>
</html>
