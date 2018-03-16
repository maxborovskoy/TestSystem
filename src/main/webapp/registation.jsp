<%--
  Created by IntelliJ IDEA.
  User: El
  Date: 14.03.2018
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Registration</h1>
<form action="registrationServlet" method="post" name="registrationForm">
    <table border="0">
        <tr>
            <td><b>Login:</b></td>
            <td><input type="text" name="user" placeholder="User name" size="50"></td>
        </tr>
        <tr>
            <td><b>Password:</b></td>
            <td><input type="password" name="password" size="50"></td>
        </tr>
        <tr>
            <td><b>Retype password:</b></td>
            <td><input type="password" name="passwordRepeat" size="50"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"></td>
        </tr>
        <tr>
            <td><a href="/login.jsp">Sign in</a></td>
        </tr>
    </table>
</form>

</body>
</html>
