<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 28.01.2020
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored ="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/registration" method="POST">
    <div style="color: red">${errorMessage}</div><br/>
    Login: <input type="text" name="login" pattern=".*[a-zA-Z0-9]" minlength="5" maxlength="15"/><br/><br/>
    Password: <input type="password" name="password" pattern=".*[a-zA-Z0-9]" minlength="5" maxlength="15"/><br/><br/>
    Confirm password: <input type="password" name="confirmpassword" pattern=".*[a-zA-Z0-9]" minlength="5" maxlength="15"/><br/><br/>
    <%--
    <label><input type="checkbox" name="admin" value="true"/> Admin</label><br/>
    --%>
    <input type="submit" value="ok"/>
</form>

</body>
</html>
