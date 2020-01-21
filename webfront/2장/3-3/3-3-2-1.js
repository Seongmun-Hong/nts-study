// 2번 실습
var parent = document.querySelector("ul");
var banana = document.querySelector("li:nth-child(3)")

var mango = document.createElement("li");
var mangoText = document.createTextNode("망고");

mango.appendChild(mangoText);
parent.insertBefore(mango, banana);




// 3번 실습 -1
var banana = document.querySelector("li:nth-child(3)")
banana.insertAdjacentHTML("beforebegin", "<li>망고</li>");


// 3번 실습 -2
var parent = document.querySelector("ul");
var apple = document.querySelector("li:nth-child(1)");
var strawberry = document.querySelector("li:nth-child(5)")

parent.insertBefore(apple, strawberry)
