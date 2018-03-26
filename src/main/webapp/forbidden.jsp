<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>403</title>
    <link rel="stylesheet" href="css/error.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>

<body>

<div class="mainContent">
    <header>
        <div class="bg-dark">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-4">
                        <h4 class="text-white">TUTOR TEST SYSTEM</h4>
                        <p class="text-muted">Tutor test system has been developed to improve your skills,
                            help you find yourself in one of provided spheres and of course fill enormous satisfaction from
                            your excellent knowledge.</p>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class = "container">

        <div class="main">
                <h1>403</h1>
                <h2>Sorry, request is denied</h2>
                <div class="more_w3ls">
                    <a href="/catalog">Go home</a>
                </div>
        </div>

    </div>
</div>

<footer class="text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#"><fmt:message key="catalog.back"/> </a>
        </p>
        <p><fmt:message key="catalog.developdescription"/></p>
        <p><fmt:message key="catalog.students"/></p>
        <p><fmt:message key="catalog.mentors"/></p>
    </div>
</footer>
</body>
</html>
