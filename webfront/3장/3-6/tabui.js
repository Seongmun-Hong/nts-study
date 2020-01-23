function makeTemplate({name, favorites}) {
    var resultHTML = "";
    var html = document.querySelector("#tabcontent").innerHTML;
        resultHTML += html.replace("${name}", name)
                         .replace("${favorites}", favorites);
    // console.log(resultHTML)
    const content = document.querySelector(".content");
    content.innerHTML = resultHTML;
}

let data = null;

function sendAjax(url, clickedName) {
    // const oReq = new XMLHttpRequest();
    // oReq.addEventListener("load", function() {
    //     var data = JSON.parse(oReq.responseText);
    // });
    // oReq.open("GET", url)
    // oReq.send();
    if(!data) {
        data = [
            {
                name: "crong",
                favorites: ["golf", "facebook"]
            },
            {
                name: "jk",
                favorites: ["soccer", "apple"]
            },
            {
                name: "honux",
                favorites: ["game", "orange"]
            },
            {
                name: "pobi",
                favorites: ["book", "youtube"]
            }
        ];
        console.log("data load");
    }
    data.forEach(function(data) {
        if(data.name === clickedName) {
            makeTemplate(data)
        }
    })
}

var tabMenu = document.querySelector(".tabmenu");

tabMenu.addEventListener("click", function(event) {
    sendAjax(null, event.target.innerText);
})