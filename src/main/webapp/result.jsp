<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Result</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="css/test.css" type="text/css">
    <script src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="mainContent">
    <header>
        <div class="bg-dark">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-4">
                        <h3 class="text-white">Test results</h3>
                        <p class="text-muted"></p>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class = "container">
        <div  class="row">
            Right answers: ${result.getCorrectAnswers()} from ${result.getCountAnswers()}
        </div>
        <div  class="row">
            Final result: ${result.getScore()}%
        </div>
    </div>
</div>

<footer class="text-muted footer">
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