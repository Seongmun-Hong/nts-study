var oReq = XMLHttpRequest();
oReq.addEventListener("load", function () {
    const jsonObj = JSON.parse(this.responseText);
    console.log(jsonObj);
})

oReq.open("GET", "url")
oReq.send();