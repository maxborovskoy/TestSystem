<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%--<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">--%>
    <%--<script src="js/bootstrap.min.js" type="text/javascript"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/login.css" type="text/css">
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
                    <input type="password" id="passwordInput" name="password" class="form-control"
                           placeholder="Enter password">
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
                <a href="/registration.jsp">Sign up</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>