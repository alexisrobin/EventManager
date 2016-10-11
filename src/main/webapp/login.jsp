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
    <title>Title</title>
</head>
<body>
<p1 value="${name}">HAPPY BIRTHDAY <%= (String)request.getSession().getAttribute("name") %> !</p1>

</body>
</html>
