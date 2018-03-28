<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="parts/head.jsp" %>
    <title>Profile</title>
</head>
<body>

    <fmt:message key="catalog.tts" var="headerTitle" />
    <fmt:message key="catalog.description" var="headerDesc" />
    <%@ include file="parts/header.jsp" %>

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
                    <td>${f:dateFormat(tR.getDate())}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <%@ include file="parts/footer.jsp" %>

</body>
</html>