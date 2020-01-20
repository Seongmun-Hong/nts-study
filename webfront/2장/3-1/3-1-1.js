var a = [1,2,3,"hello", null, true, []];
console.log(a.length);


var a = [4];
a[1000] = 3;
console.log(a.length);
console.log(a[500]);


var origin = [1, 2, 3, 4];
var changedArray = [...origin, 2, 3];

// changedArray.forEach(function(v, i, o) {
//    console.log(v); 
// });

var fun = function(v, i, o) {
    // console.log(v); 
}

changedArray.forEach(fun);



var mapped = changedArray.map(function (v) {
    return v * 2;
})

console.log(changedArray, mapped);