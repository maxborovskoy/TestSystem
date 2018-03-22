<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><fmt:message key="test.testpage"/></title>
    <link rel="stylesheet" href="css/catalog.css" type="text/css">
    <script src="js/changeLanguage.js"></script>
    <link rel="stylesheet" href="css/language.css">
    <title>${test.getName()}</title>
    <link rel="stylesheet" href="css/test.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

</head>
<body>
<div id="lang" class="lang ${sessionScope.locale}" onclick="changeLanguage()"><div></div></div>

<div class="mainContent">
    <header>
        <div class="bg-dark">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-10 py-4">
                        <h4 class="text-white">${test.getName()}</h4>
                        <p class="text-muted">
                            The test consists of questions with with choice of answer. There can be one or more right
                            answers. Pay attention to wordings.
                            After the test don't close browser or redirect into another web-site.
                        </p>
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
        <form action="testpage" method="POST" name="testpageForm">
            <c:set var="qNumber" value="0"/>
            <c:forEach items="${test.getQuest()}" var="q">
                <c:set var="qNumber" value="${qNumber+1}"/>
                <c:set var="correctAnswers" value="0"/>
                <c:forEach items="${q.getAnswers()}" var="a">
                    <c:if test="${a.getRight()}">
                        <c:set var="correctAnswers" value="${correctAnswers+1}"/>
                    </c:if>
                </c:forEach>

                <div class="row justify-content-md-center">
                    <div class="col-6.col-md-1 order-first">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="badge badge-secondary badge-pill">${qNumber}</span>
                        </h4>
                    </div>
                    <div class="col-md-8 order-md-1">
                        <h5 class="d-flex justify-content-between align-items-center mb-3">
                                ${q.getText()}
                        </h5>
                        <c:forEach items="${q.getAnswers()}" var="a">
                            <c:if test="${correctAnswers == 1}">
                                <div>
                                    <input name="q${q.getId()}" type="radio" value="${a.getId()}">
                                        ${a.getText()}
                                </div>
                            </c:if>
                            <c:if test="${correctAnswers > 1}">
                                <div>
                                    <input name="q${q.getId()}" type="checkbox" value="${a.getId()}">
                                        ${a.getText()}
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
                <hr class="mb-4">
            </c:forEach>

            <div class="row justify-content-md-center">
                <div class="col-md-4">
                    <input type="hidden" name="testId" value="${test.getId()}">
                    <button class="btn btn-primary" type="submit"><fmt:message key="test.send"/></button>
                    <a href="/catalog">Close without saving</a>
                </div>
            </div>
        </form>
    </div>
</div>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>Test tutor system has been developed by: </p>
        <p>Students: Dmitrii Guba, Elena Okhrimenko, Maksim Borovskoi,
            Dmitrii Dementev, Andrei Zakomornyi,
            Boris Korotetskii </p>
        <p>Mentors: Evgenii Aleksandrov, Arsenii Nazarov, Konstantin Evstafev </p>
    </div>
</footer>
</body>
</html>