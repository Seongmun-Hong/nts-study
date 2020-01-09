function printName(firstname) {
    var myname = "Seongmun";
    return myname + ", " +  firstname;
}

function run(firstname) {
   firstname = firstname || "Kim";
   var result = printName(firstname);
   console.log(result);
}

run("Hong")
run()