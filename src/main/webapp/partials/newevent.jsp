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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/datepicker.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/calendar.css"/>
    <title>Event Manager</title>
</head>
<body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/material.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/material-datepicker.min.js"></script>

<%@ include file="header.jsp" %>

<div class="mdl-typography--title">Nouvel évènement</div>

<!-- Form create new event -->
<div class="wrapperCards mdl-shadow--2dp">
    <form method="post">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" name="eventName" id="eventName">
            <label class="mdl-textfield__label" for="eventName">Nom de l'évènement</label>
        </div><br>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" name="eventAddress" id="eventAddress">
            <label class="mdl-textfield__label" for="eventAddress">Adresse</label>
        </div><br>

        <input class="mdl-datepicker__input" type="text" id="date-input" value="" />
        <input type="submit" class="submitbutton mdl-button mdl-js-button mdl-button--raised mdl-button--colored"  value="Créer l'évènement"><br><br>
    </form>
</div>

<script type="text/javascript">

</script>

</body>
</html>
