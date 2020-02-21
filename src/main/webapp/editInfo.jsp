<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 20.02.2020
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Info</title>
</head>
<body>
<form action="/editInfo" method="POST">
    Name: <input type="text" name="name" minlength="2" maxlength="15" autocomplete="on" pattern=".*[a-zA-Z]"/><br/><br/>
    Age: <input type="text" name="age" minlength="1" maxlength="3" autocomplete="on" min="1" max="1" pattern=".*[0-9]"/><br/><br/>
    City: <input type="text" name="city" minlength="2" maxlength="15" autocomplete="on" pattern=".*[a-zA-Z]"/><br/><br/>
    <input type="submit" value="ok"/>
</form>
</body>
</html>
