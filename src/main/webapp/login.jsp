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
<form action="LoginServlet" method="post" name="loginForm">
    <table boreder = "0">
        <tr>
            <td><b>Login</b></td>
            <td><input type="text" name="j_username" placeholder="User name" size="50"></td></tr>
        <tr>
            <td><b>Password:</b></td>
            <td><input type="password" name="j_password" size="50"></td></tr>
    <tr><td>
        <input type="submit" value="Log in"></td>
        <td>
        <input type="registration" value="New user"></td></tr>
    </table>
</form>

</body>
</html>
