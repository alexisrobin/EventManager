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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-material-datetimepicker.css"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Event Manager</title>
</head>
<body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/material.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/moment-with-locales.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-material-datetimepicker.js"></script>

<%@ include file="header.jsp" %>

<c:if test="${pageContext.request.getAttribute('add-failed') == 'true'}">
    <div id="alert">
        <a class="alert redAlert" href="#alert"><span style="color:white;">Erreur lors de l'ajout de l'évènement. Merci de vérifier que les champs sont renseignés.</span></a>
    </div>
</c:if>


<!-- Form create new event -->
<div class="wrapperCards mdl-shadow--2dp">

    <div class="mdl-typography--title mdl-typography--text-center">Nouvel évènement</div>
    <form method="post">
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" name="eventName" id="eventName">
            <label class="mdl-textfield__label" for="eventName">Nom de l'évènement</label>
        </div><br>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" name="eventAddress" id="eventAddress">
            <label class="mdl-textfield__label" for="eventAddress">Adresse</label>
        </div><br>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" name="eventStartDate" id="start-date-format">
            <label class="mdl-textfield__label" for="eventAddress">Date et heure de départ</label>
        </div><br>
        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
            <input class="mdl-textfield__input" type="text" name="eventEndDate" id="end-date-format">
            <label class="mdl-textfield__label" for="eventAddress">Date et heure de fin</label>
        </div><br>
        <input type="submit" class="submitbutton mdl-button mdl-js-button mdl-button--raised mdl-button--colored"  value="Créer l'évènement"><br><br>
    </form>
</div>

<script type="text/javascript">
    $('#start-date-format').bootstrapMaterialDatePicker({ format : 'DD/MM/YY HH:mm' });
    $('#end-date-format').bootstrapMaterialDatePicker({ format : 'DD/MM/YY HH:mm' });
</script>

</body>
</html>
