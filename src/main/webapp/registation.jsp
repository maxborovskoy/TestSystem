<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title><fmt:message key="registration.registration"/></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/register.css">
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
<div class="container register-form">
    <form action="registrationServlet" method="post" name="registrationForm">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h2><fmt:message key="registration.registration"/></h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="emailInput"><fmt:message key="registration.email"/> </label>
                    <input type="email" class="form-control" id="emailInput" name="user" placeholder="Enter email">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="passwordFirst"><fmt:message key="registration.password"/> </label>
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
                <button type="submit" class="btn btn-primary"><fmt:message key="registration.register"/> </button>
                <a href="/login.jsp"><fmt:message key="registration.login"/> </a>
            </div>
        </div>
    </form>
</div>


</body>
</html>
