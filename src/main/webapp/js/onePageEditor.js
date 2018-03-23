var questionId = 0;
var answerId = 0;

var testObject = {
    name: "",
    type: "",
    quest: [
        {
            text: "",
            answer: [
                {
                    text: "",
                    isRight: true
                }
            ]
        }

    ]
};


function addQuestionField() {
    console.log("addQuestion");

    var questionDiv = document.createElement("div");
    questionDiv.className = "question";
    questionDiv.classList.add("form-group");


    var questionLabel = document.createElement("label");
    var labelText = document.createTextNode("Question text:");
    var questionInput = document.createElement("input");

    questionInput.type = "question";
    questionInput.placeholder = "Enter question";
    questionDiv.classList.add("form-control");
    questionInput.classList.add("form-control");
    questionInput.classList.add("question-text");

    questionDiv.appendChild(questionLabel);
    questionDiv.appendChild(questionInput);


    var answerContainer = document.createElement("div");
    answerContainer.className = "answer-container col-md-8";
    var containerId = generateNextQuestionId();
    console.log("generatedId=", containerId);
    answerContainer.id = "answer-container".concat(containerId);
    questionDiv.appendChild(answerContainer);
    var addAnswerButton = document.createElement("button");
    var addAnswerButtonText = document.createTextNode("Add answer");
    addAnswerButton.appendChild(addAnswerButtonText);
    addAnswerButton.value = "Add button";
    addAnswerButton.className = "btn btn-primary create-answer-button";
    addAnswerButton.onclick = function () {
        console.log("addAnswer");
        var answerDiv = document.createElement("div");
        answerDiv.className = "answer form-group";
        var answerInput = document.createElement("input");
        answerInput.type = "question";
        answerInput.placeholder = "Enter answer";
        answerInput.classList.add("form-control");
        answerInput.classList.add("answer-text");
        answerDiv.appendChild(answerInput);

        var answerCheckBoxDiv = document.createElement("div");
        answerCheckBoxDiv.className = "form-check";
        var checkboxLabel = document.createElement("label");
        checkboxLabel.className = "form-check-label";
        var checkBoxInput = document.createElement("input");
        checkBoxInput.className = "form-check-input";
        checkBoxInput.type = "checkbox";
        var checkBoxText = document.createTextNode("It's right answer?");
        checkboxLabel.appendChild(checkBoxInput);
        checkboxLabel.appendChild(checkBoxText);
        answerCheckBoxDiv.appendChild(checkboxLabel);

        var hr = document.createElement("hr");

        var answerGroup = document.createElement("div");
        answerGroup.className = "answer-group";
        answerGroup.appendChild(answerDiv);
        answerGroup.appendChild(answerCheckBoxDiv);
        answerGroup.appendChild(hr);


        var answerContainer = document.getElementById("answer-container".concat(containerId));
        answerContainer.appendChild(answerGroup);

    };
    answerContainer.appendChild(addAnswerButton);

    var parrent = document.getElementById("question-parent");
    parrent.appendChild(questionDiv);

}


function getQuestionById(id) {
    for (var i = 0; i < questions.length; i++) {
        console.log(questions[i]);
        if (questions[i]["id"] === id.toString()) {
            console.log(questions[i]);
            return questions[i];
        }
    }
    console.log("no such question");
    return null;
}

function getAnswerById() {

}

function getAnswerByQuestionId(id) {

}

function generateNextQuestionId() {
    console.log("next question id =", questionId);
    return questionId++;
}


function generateNextAnswerId() {
    console.log("next answer id =", answerId);
    return answerId++;
}


function biuldTest() {
    var test = {};
    test.name = $("#testNameInput").val();
    test.type = $("#testTheme").val();
    test.quest = [];
    var questions = $(".question");
    Array.from(questions).forEach(function (question) {
        var newQuestion = {};
        newQuestion.Qtext = question.childNodes.item(1).value;
        newQuestion.answers = [];
        var answerGroups = question.getElementsByClassName("answer-container")[0].getElementsByClassName("answer-group");
        Array.from(answerGroups).forEach(function (answer) {
            var newAnswer = {};
            newAnswer.Atext = answer.getElementsByClassName("answer-text")[0].value;
            newAnswer.isRight = answer.getElementsByClassName("form-check-input")[0].checked;
            newQuestion.answers.push(newAnswer);
        });
        test.quest.push(newQuestion);
    });

    console.log(test);


    $.redirect("/addTest", {test: JSON.stringify(test)});
}

