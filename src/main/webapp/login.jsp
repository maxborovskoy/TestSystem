<%--
  Created by IntelliJ IDEA.
  User: El
  Date: 14.03.2018
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/tld/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    ${f:getCurrentDate()}
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <c:if test="${not empty param.language}">
        <c:set var="locale" scope="session" value="${param.language}"/>
    </c:if>
    <c:if test="${empty sessionScope.locale}">
        <fmt:setLocale value="en"/>
        <c:set var="locale" scope="session" value="en"/>
    </c:if>
    <c:if test="${sessionScope.locale eq 'en'}">
        <fmt:setLocale value="en"/>
    </c:if>
    <c:if test="${sessionScope.locale eq 'ru'}">
        <fmt:setLocale value="ru"/>
    </c:if>
    <fmt:setBundle basename="internationalization"/>
    <title><fmt:message key="login.login"/></title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/language.css">
    <script src="js/changeLanguage.js"></script>

</head>
<body>

<div id="lang" class="lang ${sessionScope.locale}" onclick="changeLanguage()"><div></div></div>

<div class="container login-form">
    <form action="loginServlet" method="post" name="loginForm">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2><fmt:message key="login.authorization"/></h2>
                <hr>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="emailInput"><fmt:message key="login.email"/></label>
                    <input type="email" class="form-control" name="user" id="emailInput"
                           placeholder="<fmt:message key="login.enteremail"/>">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="passwordInput"><fmt:message key="login.password"/></label>
                    <input type="password" name="password" id="passwordInput" class="form-control"
                           placeholder="<fmt:message key="login.enterpassword"/>">
                    <small id="passwordWarn" class="form-text text-muted">
                        <fmt:message key="login.passwordAdvice"/>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-primary" id="loginBtn"><fmt:message key="login.login"/></button>
                <a href="/registration.jsp"><fmt:message key="login.singup"/> </a>
            </div>
        </div>
    </form>
</div>
</body>
</html>