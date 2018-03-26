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
<%@ taglib prefix="f" uri="/WEB-INF/tld/tags" %>

<html>
<head>
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

    <c:if test="${not empty param.theme}">
        <c:set var="theme" scope="session" value="${param.theme}"/>
    </c:if>
    <c:if test="${empty sessionScope.theme}">
        <c:set var="theme" scope="session" value="All"/>
    </c:if>
    <c:set var="tests" scope="session" value="${f:getAllTestsByTheme(sessionScope.theme)}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Profile</title>
    <link rel="stylesheet" href="css/profile.css" type="text/css">
    <script src="js/changeLanguage.js"></script>
    <link rel="stylesheet" href="css/language.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body>
<div id="lang" class="lang ${sessionScope.locale}" onclick="changeLanguage()"><div></div></div>

<header>
    <div class="bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-md-9 py-4">
                    <h4 class="text-white"><fmt:message key="catalog.tts"/></h4>
                    <p class="text-muted"><fmt:message key="catalog.description"/></p>
                </div>

                <div class="col-md-1">
                    <form action="logoutServlet" method="post" name="LogoutForm">
                        <button type="submit" class="btn btn-primary">Log out</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="container">
<h2>Your results</h2>
  <p>Here is final results of your passed tests:</p>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Test</th>
        <th>Result</th>
        <th>Percentage</th>
        <th>Date</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${requestScope.testResults}" var="tR">
                  <tr>
                  <td>${f:getTestName(tR.getTestId())}</td>
                  <td>${tR.getCorrectAnswers()}/${tR.getCountAnswers()}</td>
                  <td>${f:getPercents(tR)}</td>
                  <td>${tR.getDate()}</td>
                  </tr>
              </c:forEach>
    </tbody>
  </table>
</div>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
                    <a href="catalog.jsp"><fmt:message key="catalog.back"/> </a>
                </p>
        <p><fmt:message key="catalog.developdescription"/></p>
        <p><fmt:message key="catalog.students"/></p>
        <p><fmt:message key="catalog.mentors"/></p>
    </div>
</footer>

</body>
</html>