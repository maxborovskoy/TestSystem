<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19.03.18
  Time: 20:20
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
        <c:set var="locale" scope="session" value="en"/>
    </c:if>
    <c:if test="${sessionScope.locale eq 'en'}">
        <fmt:setLocale value="en"/>
    </c:if>
    <c:if test="${sessionScope.locale eq 'ru'}">
        <fmt:setLocale value="ru"/>
    </c:if>

    <fmt:setBundle basename="internationalization"/>
    <title>Login</title>
    <script src="js/changeLanguage.js"></script>
    <link rel="stylesheet" href="css/language.css">
    <link rel="stylesheet" href="css/addAnswerForm.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<div id="lang" class="lang ${sessionScope.locale}" onclick="changeLanguage()"><div></div></div>

    <header>
        <div class="bg-dark" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-2">
                        <h4 class="text-white">TUTOR TEST EDITOR</h4>
                        <p class="text-muted">Add answer</p>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <main role="main" class="container">
    <div class="jumbotron">
        <form action="addAnswerForm" method="post" name="addAnswerForm">
        <h2>Add answer form</h2>
            <div class="form-group">
                <label for="exampleInputEmail1">Answer text:</label>
                    <input type="question" class="form-control" placeholder="Enter text">
                <small id="emailHelp" class="form-text text-muted"></small>
            </div>
        <div class="form-check">
          <label class="form-check-label">
            <input class="form-check-input" type="checkbox" value="">
            It's right answer?
          </label>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="submit" class="btn btn-danger">Cancel</button>
        </form>
    </div>
    </main>

    <footer class="footer">
        <div class="container">
            <p>Test tutor system 2018</p>
        </div>
    </footer>

</body>
</html>
