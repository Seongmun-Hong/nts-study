if(true) {
    console.log(true)   
} else {
    console.log(false)
}



var a = true;

var result = (a) ? "ok" : "not ok";

console.log(result)

a = "";

result = (a) ? "ok" : "not ok";

console.log(result)



var arr = [1, 2, 3];

for(var i=0; i<arr.length; i++) {

}

for(var i=0, len = arr.length; i<len; i++) {

}



result = "ab:cd".replace(":", "$"); // "ab$cd"

console.log(result)
 

// 이외의 javascript 문법이 많다. MDN 사이트에서 찾아볼것 ~