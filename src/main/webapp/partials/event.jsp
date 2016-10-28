<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 24/10/2016
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/eventManager.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/material.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/dialog-polyfill.css"/>

    <title>Event Manager</title>
</head>
<body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/material.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/dialog-polyfill.js"></script>


<script>
    $(document).ready(function () {
        $('.modal-trigger').leanModal();
    });
</script>

<%@ include file="header.jsp" %>

<div class="wrapperCards mdl-shadow--2dp">
    <div class="mdl-typography--title">${event.name}</div>
    <div class="eventAddress">${event.address}</div>
    <div class="eventDate">Début : ${startDate}</div>
    <div class="eventDate">Fin : ${endDate}</div>
<c:choose>
    <c:when test="${!isManageable}">
            <button type="button"
                    class="submitbutton mdl-button mdl-js-button mdl-button--raised mdl-button--colored show-modal">
                S'inscrire à l'évènement
            </button>
        </div>
        <dialog class="mdl-dialog">
            <form method="post" action="${pageContext.request.contextPath}/action/eventregister">
                <div class="mdl-dialog__content">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" name="lastName" id="lastName" required>
                        <label class="mdl-textfield__label" for="lastName">Nom</label>
                    </div>
                    <br>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" name="firstName" id="firstName" required>
                        <label class="mdl-textfield__label" for="firstName">Prénom</label>
                    </div>
                    <br>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="email" name="mail" id="mail" required>
                        <label class="mdl-textfield__label" for="mail">Adresse mail</label>
                    </div>
                    <br>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input class="mdl-textfield__input" type="text" name="companyName" id="companyName">
                        <label class="mdl-textfield__label" for="companyName">Société</label>
                    </div>
                </div>
                <div class="mdl-dialog__actions mdl-dialog__actions--full-width">
                    <input type="hidden" name="eventId" value="${event.id}">
                    <input type="submit" class="mdl-button" value="Confirmer">
                </div>
            </form>
        </dialog>
        <script>
            var dialog = document.querySelector('dialog');
            var showModalButton = document.querySelector('.show-modal');
            if (!dialog.showModal) {
                dialogPolyfill.registerDialog(dialog);
            }
            showModalButton.addEventListener('click', function () {
                dialog.showModal();
            });
            dialog.querySelector('.close').addEventListener('click', function () {
                dialog.close();
            });
        </script>
    </c:when>
    <c:otherwise>
        </div>
        <div class="wrapperCards mdl-shadow--2dp">
            <div class="mdl-typography--title mdl-typography--text-center">Inscriptions</div>
            <ul class="mdl-list">
                <c:forEach var="registrant" items="${registrants}">
                    <div class="mdl-card mdl-shadow--4dp">
                        <div class="mdl-card__title">
                            <h3 class="mdl-card__title-text">
                                ${registrant.getFullName()}
                            </h3>
                        </div>
                        <div class="mdl-card__supporting-text">
                            ${registrant.getMail()}<br>
                            Société ${registrant.getCompanyName()}
                        </div>
                    </div>
                    <br><br><br>
                </c:forEach>
            </ul>
        </div>
    </c:otherwise>
</c:choose>
<br/>
<c:if test="${message}" >
    <div class="wrapperCards">
            ${message}
    </div>
</c:if>
</body>
</html>
