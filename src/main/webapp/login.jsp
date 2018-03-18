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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container login-form">
    <form action="loginServlet" method="post" name="loginForm">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Autorization</h2>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="emailInput">Email address</label>
                    <input type="email" class="form-control" name="user" id="emailInput" placeholder="Enter email">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="passwordInput">Password</label>
                    <input type="password" id="passwordInput" class="form-control" placeholder="Enter password">
                    <small id="passwordWarn" class="form-text text-muted">Never share you password with anyone else
                    </small>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-primary">Log in</button>
                <a href="/registation.jsp">Sign up</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>