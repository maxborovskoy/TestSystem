var questionId = 0;
var answerId = 0;

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

        var answerContainer = document.getElementById("answer-container".concat(containerId));
        answerContainer.appendChild(answerDiv);
        answerContainer.appendChild(answerCheckBoxDiv);
        answerContainer.appendChild(hr);
    };
    answerContainer.appendChild(addAnswerButton);

    var parrent = document.getElementById("question-parent");
    parrent.appendChild(questionDiv);

}


function generateNextQuestionId() {
    console.log("next question id =", questionId);
    return questionId++;
}


function generateNextAnswerId() {
    console.log("next answer id =", answerId);
    return answerId++;
}

