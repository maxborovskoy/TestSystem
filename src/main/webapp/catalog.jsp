<%--
  Created by IntelliJ IDEA.
  User: dmitriy
  Date: 14.03.18
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Catalog</title>
    <link rel="stylesheet" href="css/catalog.css" type="text/css">
    <%--<link rel="stylesheet" href="./css/bootstrap.min.css">--%>
    <%--<script src="js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<header>
    <div class="bg-dark" id="navbarHeader">
        <div class="container">
            <div class="row">
                <div class="col-md-6 py-4">
                    <h4 class="text-white">TUTOR TEST SYSTEM</h4>
                    <p class="text-muted">Tutor test system has been developed to improve your skills,
                        help you find yourself in one of provided spheres and of course fill enormous satisfaction from
                        your excellent knowledge.</p>
                </div>
                <c:if test="${sessionScope.user.getTutor()}">
                    <div class="col-md-5">
                        <form action="addTestForm" method="get" name="createTestForm">
                            <button type="submit" class="btn btn-primary">Create test</button>
                        </form>
                    </div>
                </c:if>
                <div class="col-md-1">
                    <form action="logoutServlet" method="post" name="LogoutForm">
                        <button type="submit" class="btn btn-primary">Log out</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</header>


<c:choose>
    <c:when test="${(requestScope.allTests ne null) && (not empty requestScope.allTests)}">
        <div class="album py-5 bg-light">
            <div class="container">
                <div class="row">
                    <c:forEach items="${requestScope.allTests}" var="test">
                        <div class="col-md-4">
                            <div class="card mb-4 box-shadow">
                                <c:choose>
                                    <c:when test="${test.getType().getName() eq 'Math'}">
                                        <img class="card-img-top test-img"
                                             src="images/math.png"
                                             alt="Card image cap">
                                    </c:when>
                                    <c:when test="${test.getType().getName() eq 'Physics'}">
                                        <img class="card-img-top test-img"
                                             src="images/physics.png"
                                             alt="Card image cap">
                                    </c:when>
                                    <c:when test="${test.getType().getName() eq 'Russian'}">
                                        <img class="card-img-top test-img"
                                             src="images/russian.png"
                                             alt="Card image cap">
                                    </c:when>
                                    <c:when test="${test.getType().getName() eq 'English'}">
                                        <img class="card-img-top test-img"
                                             src="images/english.png"
                                             alt="Card image cap">
                                    </c:when>
                                </c:choose>
                                <div class="card-body">
                                    <h5 class="card-title">${test.getName()}</h5>
                                    <p class="card-text">This is a wider card with supporting text below as a
                                        natural lead-in to
                                        additional content. This content is a little bit longer.</p>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <a href="<c:url value="/test?id=${test.getId()}"/>" class="btn btn-primary">Start
                                            test</a>
                                        <small class="text-muted">9 mins</small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container">
            <div class="row">
                <div class="<col-md-3"></div>
                <div class="<col-md-6">
                    <h1 class="mt-5">There is no tests yet</h1>
                    <p class="lead">We haven't created any test yet. Please come later, may be something will
                        change soon.</p>
                </div>
                <div class="<col-md-3"></div>
            </div>
        </div>
    </c:otherwise>
</c:choose>


<footer class="text-muted">
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
