<%--
  Created by IntelliJ IDEA.
  User: Alexis
  Date: 11/10/2016
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css"/>
    <title>Title</title>
</head>
<body>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<h1>Authentification</h1>

<!-- Wrapper qui contient le bloc total sur lequel on applique le CSS pour centrer -->

<div class="wrapperAuth">

    <!-- Onglets -->
    <div class="tabs">
        <h2 class="connexionTab">Connexion</h2>
        <h2 class="inscriptionTab">Inscription</h2>
    </div>


    <!-- Onglet connexion -->
    <div class="tabConnexion">
        <form>
            Adresse e-mail : <input type="text" name="mail" value="Adresse e-mail"><br>
            Mot de passe : <input type="text" name="pwd" value="Mot de passe"><br>
            <input type="submit" class="btn btn-default"  value="Connexion"><br>
            <input type="checkbox" name="remember"> Se souvenir de moi <br>
        </form>
        <a>Mot de passe oublié ?</a>
    </div>


    <!-- Onglet inscription -->
    <div class="tabInscription">
        <form>
            Nom : <input type="text" name="nom" value="Nom"><br>
            Prenom : <input type="text" name="prenom" value="Prénom"><br>
            Nom : <input type="text" name="societe" value="Société"><br>
            Adresse e-mail : <input type="text" name="mail" value="Adresse e-mail"><br>
            Mot de passe : <input type="text" name="pwd" value="Mot de passe"><br>
            Confirmez le mot de passe : <input type="text" name="pwd2" value="Confirmez le mot de passe"><br>
            <input type="submit" value="S'inscrire"><br>
        </form>
    </div>


</div>

</body>
</html>
