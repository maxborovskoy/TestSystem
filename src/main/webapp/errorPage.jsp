<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="parts/head.jsp" %>
    <title>ErrorPage</title>
</head>
<body>

    <c:set value="TUTOR TEST SYSTEM" var="headerTitle" />
    <c:set value="Tutor test system has been developed to improve your skills, help you find yourself in one of provided spheres and of course fill enormous satisfaction from your excellent knowledge." var="headerDesc" />
    <%@ include file="parts/header.jsp" %>

        <div class="error">
            <h1>${requestScope.statusCode}</h1>
            <h2>Ooops :(</h2>
            <h2>Something went wrong</h2>
            <a href="/catalog">Go home</a>
        </div>

    <%@ include file="parts/footer.jsp" %>

</body>
</html>
