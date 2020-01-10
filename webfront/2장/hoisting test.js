var myName = "Hong"; // 값 할당 
var yourName; // 값 할당 X

function myName() { // 같은 이름의 함수 선언
    console.log("myName Function");
}
function yourName() { // 같은 이름의 함수 선언
    console.log("yourName Function");
}

console.log(myName) // Hong
console.log(yourName) // [Function: yourName]
// console.log(myName()) 오류!
console.log(yourName()) // > undefined

console.log(typeof myName); // > string
console.log(typeof yourName); // > function