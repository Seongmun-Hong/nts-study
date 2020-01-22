var myFriend = { 
    key : "value", 
    addition : [
        { name : "hong" },
        { age : 2 }
    ]
};

console.log(myFriend.key);
// console.log(myFriend[key]);  Error
console.log(myFriend["key"]);
console.log(myFriend.addition[0].name);


for(key in myFriend) {
    console.log(myFriend[key]);
}


console.log(Object.keys(myFriend));
Object.log(myFriend).forEach(function (v) {
    console.log(myFriend[v])
});