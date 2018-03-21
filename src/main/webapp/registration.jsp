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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <%--<link rel="stylesheet" href="css/register.css">--%>
    <%--<script src="js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<div class="container register-form">
    <form action="registrationServlet" method="post" name="registrationForm">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2>Registration</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="emailInput">Email address</label>
                    <input type="email" class="form-control" id="emailInput" name="user" placeholder="Enter email">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="passwordFirst">Password</label>
                    <input type="password" id="passwordFirst" class="form-control" placeholder="Enter password"
                           name="password">
                    <label for="passwordSecond"></label>
                    <input type="password" id="passwordSecond" class="form-control pass-repeat" placeholder="Repeat password"
                           name="passwordRepeat">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-primary">Register</button>
                <a href="/login.jsp">Sign in</a>
            </div>
        </div>
    </form>
</div>


</body>
</html>
