<%--
  Created by IntelliJ IDEA.
  User: dmitriy
  Date: 14.03.18
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Catalog</title>
    <link rel="stylesheet" href="css/catalog.css" type="text/css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<header>
    <div class="bg-dark" id="navbarHeader">
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


<div class="album py-5 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/math.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Test Math</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=1" class="btn btn-primary">Start test</a>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/physics.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Test Physics</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=2" class="btn btn-primary">Start test</a>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/russian.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Test Russian</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=3" class="btn btn-primary">Start test</a>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card mb-4 box-shadow">
                    <img class="card-img-top test-img"
                         src="images/english.png"
                         alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Test English</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to
                            additional content. This content is a little bit longer.</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <a href="/test?id=4" class="btn btn-primary">Start test</a>
                            <small class="text-muted">9 mins</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
