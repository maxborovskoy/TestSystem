<%--
  Created by IntelliJ IDEA.
  User: El
  Date: 14.03.2018
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Autorization</h1>
<form action="loginServlet" method="post" name="loginForm">
    <table boreder = "0">
        <tr>
            <td><b>Login</b></td>
            <td><input type="text" name="user" placeholder="User name" size="50"></td>
        </tr>
        <tr>
            <td><b>Password:</b></td>
            <td><input type="password" name="password" size="50"></td>
        </tr>
        <tr>
        <td><input type="submit" value="Log in"></td>
        </tr>
        <tr>
            <td><a href="/registation.jsp">Sign up</a></td>
        </tr>
    </table>
</form>

</body>
</html>
