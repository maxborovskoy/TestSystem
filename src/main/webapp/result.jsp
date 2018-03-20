<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Result</title>
</head>
<body>

<h2>Результаты теста</h2>
<div>Верно отвечено на ${result.getCorrectAnswers()} из ${result.getCountAnswers()} вопросов</div>
<div>Ваш результат: ${result.getScore()}%</div>

</body>
</html>