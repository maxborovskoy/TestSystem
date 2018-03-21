<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
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
    <title><fmt:message key="test.testpage"/></title>
    <link rel="stylesheet" href="css/catalog.css" type="text/css">
    <script src="js/changeLanguage.js"></script>
</head>
<body>
<form>
    <select id="language" name="language" onchange="changeLanguage()">
        <option value="en" ${sessionScope.locale == 'en' ? 'selected' : ''}><fmt:message key="english"/></option>
        <option value="ru" ${sessionScope.locale == 'ru' ? 'selected' : ''}><fmt:message key="russian"/></option>
    </select>
</form>
<h1>${test.getName()}</h1>
<form action="" method="POST">
<ul>
    <c:forEach items="${test.getQuest()}" var="q">
        <c:set var="correctAnswers" value="0"/><c:forEach items="${q.getAnswers()}" var="a"><c:if test="${a.getRight()}"><c:set var="correctAnswers" value="${correctAnswers+1}"/></c:if></c:forEach>
        <li>
            <p><b>${q.getText()}</b></p>
                <c:forEach items="${q.getAnswers()}" var="a">
                    <c:if test="${correctAnswers == 1}">
                        <p><input name="q${q.getId()}" type="radio" value="${a.getId()}">${a.getText()}</p>
                    </c:if>
                    <c:if test="${correctAnswers > 1}">
                        <p><input name="q${q.getId()}" type="checkbox" value="${a.getId()}">${a.getText()}</p>
                    </c:if>
                </c:forEach>
        </li>
    </c:forEach>
</ul>
<input type="hidden" name="testId" value="${test.getId()}">
<p><input type="submit" value="Отправить"></p>
<button type="submit"><fmt:message key="test.send"/></button>

</form>

</body>
</html>