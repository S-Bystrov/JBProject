<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Сергей
  Date: 28.01.2020
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored ="false"%>
<html>
<head>
    <title>Information</title>
</head>
<body>
    Login:${user.login}<br/>
    Name: ${user.infoUser.name}<br/>
    Age:  ${user.infoUser.age}<br/>
    City: ${user.infoUser.city}<br/>
  <%--  <c:if test="${user.admin}">
        <table border="1" cellpadding="1" cellspacing="1" style="width: 500px">
            <caption><h4>Info</h4></caption>
            <tbody>
            <tr>
                <td>№</td>
                <td>Login</td>
                <td>Name</td>
                <td>Age</td>
            </tr>
            <c:forEach var="user" items="${users}" varStatus="сounter">
                <tr>
                    <td>${сounter.count}</td>
                    <td><c:out value="${user.login}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.age}"/></td>
                    </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if> --%>
<form action="/logout " method="POST">
    <input type="submit" value="logout" />
</form>
<a href="/editInfo.jsp">Edit Info</a>
</body>
</html>
