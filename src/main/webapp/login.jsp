<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored ="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="POST">
    <div style="color: red">${errorMessage}</div><br/>
    Login: <input type="text" name="login" minlength="5" maxlength="15" pattern=".*[a-zA-Z0-9]"/><br/><br/>
    Password: <input type="password" name="password" minlength="5" maxlength="15" pattern=".*[a-zA-Z0-9]"/><br/><br/>
    <input type="submit" name="ok" value="ok"/>
</form>
<a href="/registration.jsp">Registration</a>
</body>
</html>
