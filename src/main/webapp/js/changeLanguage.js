function changeLanguage()
{
    var select = document.getElementById("language");
    var language = select.options[select.selectedIndex].value;
    document.location.href = "?language=" + language;
}