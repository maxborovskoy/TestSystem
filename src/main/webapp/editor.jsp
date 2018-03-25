<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title></title>
    <link rel="stylesheet" href="css/editor.css">
    <link rel="stylesheet" href="css/test.css">
    <script src="js/onePageEditor.js"></script>
    <!--<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">-->
    <!--<script src="js/bootstrap.min.js"></script>-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="js/jquery.redirect.js"></script>

</head>
<body>
<div class="mainContent">
    <header>
        <div class="bg-dark" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-2">
                        <h4 class="text-white">TUTOR TEST EDITOR</h4>
                        <p class="text-muted">Edit test</p>
                    </div>
                </div>
            </div>
        </div>
    </header>


    <main role="main" class="container">
        <div class="jumbotron">
            <!--<form action="addTestForm" method="post" name="addTestForm">-->
            <h2>Edit test form</h2>
            <div class="form-group">
                <label for="testNameInput">Test title: </label>
                <input type="text" class="form-control" id="testNameInput" value="${test.getName()}">
            </div>
            <label for="testTheme">Choose theme:</label>
            <select class="form-control" id="testTheme">
                <option>Math</option>
                <option>Physics</option>
                <option>Russian</option>
                <option>English</option>
            </select>

            <button type="submit" class="btn btn-primary create-question-button" onclick="addQuestionField()">Add
                question
            </button>
            <c:if test="${not empty problem}">
                <c:choose>
                    <c:when test="${problem eq 'TEST_EXISTS'}">
                        <small id="editorWarn" class="form-text text-danger">Test with same name and type is already
                            exists
                        </small>
                    </c:when>
                    <c:when test="${problem eq 'TEST_NO_NAME'}">
                        <small id="editorWarn" class="form-text text-danger">You forgot set test name</small>
                    </c:when>
                    <c:when test="${problem eq 'EMPTY_QUESTIONS'}">
                        <small id="editorWarn" class="form-text text-danger">You didn't add any question to you test
                        </small>
                    </c:when>
                    <c:when test="${problem eq 'QUESTION_EXISTS'}">
                        <small id="editorWarn" class="form-text text-danger">There is duplicate question in that test
                        </small>
                    </c:when>
                    <c:when test="${problem eq 'QUESTION_NO_TEXT'}">
                        <small id="editorWarn" class="form-text text-danger">You left some question fields without
                            text
                        </small>
                    </c:when>
                    <c:when test="${problem eq 'QUESTION_NO_ANSWERS'}">
                        <small id="editorWarn" class="form-text text-danger">You left some questions without answers
                        </small>
                    </c:when>
                    <c:when test="${problem eq 'ANSWER_EXISTS'}">
                        <small id="editorWarn" class="form-text text-danger">Some of your questions have duplicate
                            answers
                        </small>
                    </c:when>
                    <c:when test="${problem eq 'ANSWER_NO_TEXT'}">
                        <small id="editorWarn" class="form-text text-danger">You left some answer fields without text
                        </small>
                    </c:when>
                </c:choose>
            </c:if>
            <div class="question-container" id="question-parent">
                <c:if test="${not empty test}">
                    <c:set var="contId" value="10"/>
                    <c:forEach items="${test.getQuest()}" var="q">
                        <div class="question form-group form-control">
                            <button type="button" class="close" aria-label="Close"
                                    onclick="deleteQuestion('${contId}')">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <input type="question" placeholder="Enter question" class="form-control question-text"
                                   value="${q.getText()}">
                            <div class="answer-container col-md-8" id="answer-container${contId}">
                                <button type="submit" class="btn btn-primary create-answer-button"
                                        onclick="addAnswerField('${contId}')">Add answer
                                </button>
                                <c:set var="contId" value="${contId+1}"/>
                                <c:forEach items="${q.getAnswers()}" var="a">
                                    <div class="answer-group">
                                        <div class="answer form-group">
                                            <button type="button" class="close" aria-label="Close"
                                                    onclick="deleteAnswer('${contId}')">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                            <label></label>
                                            <input type="question" placeholder="Enter answer"
                                                   class="form-control answer-text" value="${a.getText()}">
                                        </div>
                                        <div class="form-check">
                                            <label class="form-check-label">
                                                <c:if test="${a.getRight()}">
                                                    <input class="form-check-input" type="checkbox" checked>
                                                </c:if>
                                                <c:if test="${not a.getRight()}">
                                                    <input class="form-check-input" type="checkbox">
                                                </c:if>
                                                "It's right answer?"
                                            </label>
                                        </div>
                                        <hr>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${test.getId() == -1}">
                            <input type="hidden" id="edit" value="0">
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" id="edit" value="1">
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </div>
            <button type="submit" class="btn btn-primary" onclick="biuldTest()">Save</button>
            <a href="<c:url value="/catalog"/>" class="btn btn-danger">Cancel</a>
            <!--</form>-->
        </div>
    </main>

</div>

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
