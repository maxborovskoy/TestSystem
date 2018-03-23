<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title><fmt:message key="registration.registration"/></title>
    <link rel="stylesheet" href="css/register.css">
    <script src="js/changeLanguage.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body>
<form>
    <select id="lan" onchange="changeLanguage()">
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
                    <input type="email" class="form-control" id="emailInput" name="user"
                           placeholder="<fmt:message key="registration.enteremail"/>">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="passwordFirst"><fmt:message key="registration.password"/> </label>
                    <input type="password" id="passwordFirst" class="form-control"
                           placeholder="<fmt:message key="registration.enterpassword"/>"
                           name="password">
                    <label for="passwordSecond"></label>
                    <input type="password" id="passwordSecond" class="form-control pass-repeat"
                           placeholder="<fmt:message key="registration.repeatpassword"/>"
                           name="passwordRepeat">
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-primary"><fmt:message key="registration.register"/></button>
                <a href="/login.jsp"><fmt:message key="registration.login"/> </a>
            </div>
        </div>
    </form>
</div>


</body>
</html>
