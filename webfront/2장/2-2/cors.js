var oReq = new XMLHttpRequest();
oReq.addEventListener("load", function() {
    console.log(this.responseText);
});    

oReq.open("GET", "http://localhost:8080/cors/");

oReq.send();

var oReq2 = new XMLHttpRequest();
oReq2.addEventListener("load", function() {
    console.log(this.responseText);
});    

oReq2.open("POST", "http://localhost:8080/cors/");
oReq2.setRequestHeader('Content-Type', 'application/json');

var data = "{ 'name': 'Seongmun' }"
oReq2.send(data);