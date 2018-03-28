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

    <h2>All users</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>User</th>
            </tr>
        </thead>
        <tbody>
              <c:forEach items="${requestScope.users}" var="use">
                  <tr>
                  <td>
                      <a href="profileServlet?user=${use.getName()}">${use.getName()}</a>
                  </td>
                  </tr>
              </c:forEach>
        </tbody>
    </table>

    <%@ include file="parts/footer.jsp" %>

</body>
</html>