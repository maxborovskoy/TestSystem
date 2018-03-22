function changeLanguage()
{
    var select = document.getElementById("lan");
    var language = select.options[select.selectedIndex].value;
    var url = document.URL;
    if(!url.includes("?"))
        document.location.href = document.URL + "?language=" + language;
    else if(url.match("language="))
        document.location.href = url.replace(/language=../, "language=" + language);
    else
        document.location.href = url + "&language=" + language;
}

function changeImage(){
    el = document.getElementById("lang");
    console.log(document.getElementById("lang").src);
    if(el.dataset.lang === "en") {
        el.dataset.lang = "ru";
        document.getElementById("lang").src = "images/ru.ico";
    }else {
        el.dataset.lang = "en";
        document.getElementById("lang").src = "images/en.ico";
    }
}

function languageFocus(){
    el = document.getElementById("lang");
    console.log(document.getElementById("lang").src);
    if(el.dataset.lang === "en") {
        document.getElementById("lang").src = "images/ru.ico";
    }else {
        document.getElementById("lang").src = "images/en.ico";
    }
}