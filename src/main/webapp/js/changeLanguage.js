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