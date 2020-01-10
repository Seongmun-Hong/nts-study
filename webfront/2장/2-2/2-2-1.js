function run() {
    setTimeout(function() {
        var msg = "hello";
        console.log(msg);  //이 메시지는 즉시 실행되지 않습니다.
    }, 1000);
}

// run();



function run2() {
    console.log("run start")
    setTimeout(function() {
        var msg = "hello";
        console.log(msg);  //이 메시지는 즉시 실행되지 않습니다.
    }, 1000);
    console.log("run end")
}

// run2();

/*
run start
run end
hello
*/


function run3() {
    setTimeout(function() {
        var msg = "hello";
        console.log(msg);  //이 메시지는 즉시 실행되지 않습니다.
    }, 1000);
}

console.log("run start");
run3();
console.log("run end");

/*
run start
run end
hello
*/

// 비동기이기 때문