<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 19.03.18
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/addQuestionForm.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <div class="bg-dark" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-md-7 py-2">
                        <h4 class="text-white">TUTOR TEST EDITOR</h4>
                        <p class="text-muted">Add question</p>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <main role="main" class="container">
    <div class="jumbotron">
        <form action="addQuestionForm" method="post" name="addQuestionForm">
        <h2>Add question form</h2>
            <div class="form-group">
                <label for="exampleInputEmail1">Question text:</label>
                    <input type="question" class="form-control" placeholder="Enter text">
                <small id="emailHelp" class="form-text text-muted"></small>
            </div>
        <button type="submit" class="btn btn-primary">Add answer</button>
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
