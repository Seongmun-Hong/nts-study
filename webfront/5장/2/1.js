console.log("1".match(/1/));
console.log("1".match(/1/)[0]);
console.log("1".match(/2/));
console.log("11".match(/12/));

console.log("a52b".match(/52/));
console.log("a99b".match(/\d\d/));

var target = "abc35zzz";
var regex = /\d\d/;
var result = target.match(regex);
console.log(result && result[0]);