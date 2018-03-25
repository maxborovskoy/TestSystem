<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><fmt:message key="result.result"/></title>
    <script src="js/changeLanguage.js"></script>
    <title>Result</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/test.css" type="text/css"/>
</head>

<body>

<div class="mainContent">
    <header>
        <div class="bg-dark">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-4">
                        <h3 class="text-white"><fmt:message key="result.testresults"/></h3>
                        <h3 class="text-muted"> ${test.getName()}</h3>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <form>
        <select id="lan" onchange="changeLanguage()">
            <option value="en" ${sessionScope.locale == 'en' ? 'selected' : ''}><fmt:message key="english"/></option>
            <option value="ru" ${sessionScope.locale == 'ru' ? 'selected' : ''}><fmt:message key="russian"/></option>
        </select>
    </form>

    <div class="container">
        <c:if test="${result.getScore() > 60}">
            <div class="row green"><fmt:message key="result.success"/>.</div>
        </c:if>
        <c:if test="${result.getScore() <= 60}">
            <div class = "row red"><fmt:message key="result.fail"/>.</div>
        </c:if>
        <div class="row">
            <fmt:message key="result.res1"/> ${result.getCorrectAnswers()} <fmt:message
                key="result.res2"/> ${result.getCountAnswers()} <fmt:message key="result.res3"/>. <fmt:message key="result.yourresult"/> ${result.getScore()}%
        </div>
    </div>
    <div class="d-flex justify-content-md-center">
        <div class="low-btn">
            <a href="<c:url value="/catalog"/>" class="btn btn-primary"><fmt:message key="result.return"/></a>
        </div>
    </div>
</div>

<footer class="text-muted footer">
    <div class="container">
        <p>Test tutor system has been developed by: </p>
        <p>Students: Dmitrii Guba, Elena Okhrimenko, Maksim Borovskoi,
            Dmitrii Dementev, Andrei Zakomornyi,
            Boris Korotetskii </p>
        <p>Mentors: Evgenii Aleksandrov, Arsenii Nazarov, Konstantin Evstafev </p>
    </div>
</footer>
</body>
</html>