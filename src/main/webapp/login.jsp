<%--
  Created by IntelliJ IDEA.
  User: El
  Date: 14.03.2018
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <c:if test="${not empty param.language}">
        <c:set var="locale" scope="session" value="${param.language}"/>
    </c:if>
    <c:if test="${empty sessionScope.locale}">
        <fmt:setLocale value="en"/>
    </c:if>
    <c:if test="${sessionScope.locale eq 'en'}">
        <fmt:setLocale value="en"/>
    </c:if>
    <c:if test="${sessionScope.locale eq 'ru'}">
        <fmt:setLocale value="ru"/>
    </c:if>
    <fmt:setBundle basename="internationalization"/>
    <title><fmt:message key="login.login"/></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/changeLanguage.js"></script>

</head>
<body>
<form>
    <select id="language" name="language" onchange="changeLanguage()">
        <option value="en" ${sessionScope.locale == 'en' ? 'selected' : ''}><fmt:message key="english"/></option>
        <option value="ru" ${sessionScope.locale == 'ru' ? 'selected' : ''}><fmt:message key="russian"/></option>
    </select>
</form>
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
                    <input type="email" class="form-control" name="user" id="emailInput" placeholder="Enter email">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="passwordInput"><fmt:message key="login.password"/></label>
                    <input type="password" id="passwordInput" class="form-control" placeholder="Enter password">
                    <small id="passwordWarn" class="form-text text-muted"><fmt:message key="login.passwordAdvice"/>
                    </small>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-primary"><fmt:message key="login.login"/> </button>
                <a href="/registation.jsp"><fmt:message key="login.singup"/> </a>
            </div>
        </div>
    </form>
</div>
</body>
</html>