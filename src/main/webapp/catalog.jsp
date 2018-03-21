<%--
  Created by IntelliJ IDEA.
  User: dmitriy
  Date: 14.03.18
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><fmt:message key="catalog.catalog"/> </title>
    <link rel="stylesheet" href="css/catalog.css" type="text/css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/changeLanguage.js"></script>
</head>
<body>

<header>
    <div class="bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-md-7 py-4">
                    <h4 class="text-white"><fmt:message key="catalog.tts"/> </h4>
                    <p class="text-muted"><fmt:message key="catalog.description"/> </p>
                </div>
            </div>
        </div>
    </div>
</header>
<form>
    <select id="language" name="language" onchange="changeLanguage()">
        <option value="en" ${sessionScope.locale == 'en' ? 'selected' : ''}><fmt:message key="english"/></option>
        <option value="ru" ${sessionScope.locale == 'ru' ? 'selected' : ''}><fmt:message key="russian"/></option>
    </select>
</form>

<div class="album py-5 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/math.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><fmt:message key="catalog.math"/></h5>
                        <p class="card-text"><fmt:message key="catalog.typedescription"/></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=1" class="btn btn-primary"><fmt:message key="catalog.start"/></a>
                            <small class="text-muted">9 <fmt:message key="catalog.mins"/></small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/physics.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><fmt:message key="catalog.phisics"/> </h5>
                        <p class="card-text"><fmt:message key="catalog.typedescription"/></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=2" class="btn btn-primary"><fmt:message key="catalog.start"/></a>
                            <small class="text-muted">9 <fmt:message key="catalog.mins"/></small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/russian.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><fmt:message key="catalog.russian"/> </h5>
                        <p class="card-text"><fmt:message key="catalog.typedescription"/></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=3" class="btn btn-primary"><fmt:message key="catalog.start"/></a>
                            <small class="text-muted">9 <fmt:message key="catalog.mins"/></small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/english.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><fmt:message key="catalog.english"/> </h5>
                        <p class="card-text"><fmt:message key="catalog.typedescription"/></p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=4" class="btn btn-primary"><fmt:message key="catalog.start"/></a>
                            <small class="text-muted">9 <fmt:message key="catalog.mins"/></small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#"><fmt:message key="catalog.back"/> </a>
        </p>
        <p><fmt:message key="catalog.developdescription"/> </p>
        <p><fmt:message key="catalog.students"/> </p>
        <p><fmt:message key="catalog.mentors"/> </p>
    </div>
</footer>

</body>
</html>
