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
</head>
<body>
<form>
    <select id="language" name="language" onchange="changeLanguage()">
        <option value="en" ${sessionScope.locale == 'en' ? 'selected' : ''}><fmt:message key="english"/></option>
        <option value="ru" ${sessionScope.locale == 'ru' ? 'selected' : ''}><fmt:message key="russian"/></option>
    </select>
</form>
<h2><fmt:message key="result.testresults"/> </h2>
<div><fmt:message key="result.res1"/> ${result.getCorrectAnswers()} <fmt:message key="result.res2"/> ${result.getCountAnswers()} <fmt:message key="result.res3"/></div>
<div><fmt:message key="result.yourresult"/> ${result.getScore()}%</div>

</body>
</html>