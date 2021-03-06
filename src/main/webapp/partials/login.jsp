<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 11/10/2016
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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

<c:if test="${pageContext.request.getAttribute('login-failed') == 'true'}">
    <div id="alert">
        <a class="alert redAlert" href="#alert"><span style="color:white;">Connexion échouée. Merci de réessayer ou de vous inscrire.</span></a>
    </div>
</c:if>

<c:if test="${pageContext.request.getAttribute('register-failed') == 'true'}">
    <div id="alert">
        <a class="alert redAlert" href="#alert"><span style="color:white;">Register failed.</span></a>
    </div>
</c:if>

<c:if test="${pageContext.request.getAttribute('register-failed') == 'false'}">
    <div id="alert">
        <a class="alert blueAlert" href="#alert"><span style="color:white;">Utilisateur inscrit. Vous pouvez vous connecter.</span></a>
    </div>
</c:if>

<c:if test="${pageContext.request.getAttribute('login-needed') == 'true'}">
    <div id="alert">
        <a class="alert redAlert" href="#alert"><span style="color:white;">Vous devez être enregistré pour acceder à cette page.</span></a>
    </div>
</c:if>

<!-- Wrapper qui contient le bloc total sur lequel on applique le CSS pour centrer -->

<div class="wrapperAuth mdl-shadow--2dp">
    <p class="mdl-typography--title EMsectionTitle">Authentification</p>

    <div class="mdl-tabs mdl-js-tabs">


        <div class="mdl-tabs__tab-bar">
            <!-- Onglets -->
            <a href="#tab1-panel" class="mdl-tabs__tab is-active">Connexion</a>
            <a href="#tab2-panel" class="mdl-tabs__tab">Inscription</a>
        </div>

        <div class="mdl-tabs__panel is-active" id="tab1-panel">

            <!-- Onglet connexion -->
            <form action="${pageContext.request.contextPath}/action/login" method="post">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="email" name="mailConnexion" id="mailConnexion" required>
                    <label class="mdl-textfield__label" for="mailConnexion">Adresse e-mail</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input pattern=".{6,}" title="Le mot de passe doit contenir au moins 6 caracteres" class="mdl-textfield__input" type="password" name="pwdConnexion" id="pwdConnexion" required>
                    <label class="mdl-textfield__label" for="pwdConnexion">Mot de passe</label>
                </div><br>
                <div>
                    <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect" for="checkbox-1">
                        <input type="checkbox" name="checkbox-1" id="checkbox-1" class="mdl-checkbox__input" checked>
                        <span class="mdl-checkbox__label">Se souvenir de moi</span>
                    </label>
                </div>
                <div>
                    <a class="forgotten">Mot de passe oublié ?</a>
                </div>
                <div>
                    <input type="submit" class="submitbutton mdl-button mdl-js-button mdl-button--raised mdl-button--colored"  value="Connexion" onclick="rememberMe()"><br><br>
                </div>
            </form>
        </div>


        <div class="mdl-tabs__panel" id="tab2-panel">

            <!-- Onglet inscription -->
            <form action="${pageContext.request.contextPath}/action/register" method="post">

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="email" name="mailInscription" id="mailInscription" required>
                    <label class="mdl-textfield__label" for="mailInscription">Adresse mail</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="password" name="pwdInscription" id="pwdInscription" required pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Le mot de passe doit contenir au moins 6 caracteres' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;">
                    <label class="mdl-textfield__label" for="pwdInscription">Mot de passe</label>
                </div><br>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="password" name="pwdInscription2" id="pwdInscription2" required pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Les deux mots de passe doivent être identques' : '');">
                    <label class="mdl-textfield__label" for="pwdInscription2">Confirmer le mot de passe</label>
                </div><br>


                <input type="submit" class="submitbutton mdl-button mdl-js-button mdl-button--raised mdl-button--colored"  value="S'inscrire" ><br><br>
            </form>
        </div>
    </div>
    <script >
        function setCookie(cname, cvalue, exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays*24*60*60*1000));
            var expires = "expires="+d.toUTCString();
            document.cookie = cname + "=" + document.getElementById(cvalue).value + ";" + expires + ";path=/";
        }

        function getCookie(cname) {
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for(var i = 0; i < ca.length; i++) {
                var c = ca[i];
                while (c.charAt(0) == ' ') {
                    c = c.substring(1);
                }
                if (c.indexOf(name) == 0) {
                    return c.substring(name.length, c.length);
                }
            }
            return "";
        }
        function rememberMe(){
            if (document.getElementById("checkbox-1").checked)
            {
                setCookie('mail','mailConnexion');
                setCookie('pwd','pwdConnexion');
            }
        }
        if (getCookie("pwd") != "" && getCookie("mail") != "")
            {
                document.getElementById("mailConnexion").value = getCookie("mail");
                document.getElementById("pwdConnexion").value = getCookie("pwd");
            }

    </script>
</div>
</body>
</html>