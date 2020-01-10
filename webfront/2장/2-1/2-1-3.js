function printName(firstname) {
    var myname = "seongmun";
    return "name is " + myname + " " +  firstname;
}

console.log(printName())
// 선언되어있고 할당되지 않은 변수는 undefine
// 인자가 덜있고 더있고 등 오류가 발생하지 않음

console.log(printName("hong"));



function printName2(firstname) {

    // 함수 표현식 - 변수값에 함수의 표현을 담아 놓은 것
    var inner = function() {
        return "inner value";
    }

    var result = inner();
    console.log("name is " + result);

}

printName2();


function printName3(firstname) {

    var result = inner();
    console.log("name is " + result);

    var inner = function() { 
        return "inner value";
    }

}

// printName3();



function printName4(firstname) {

    console.log(inner); // undefine
    // 아직 함수로 인식되지 않음

    var inner = function() { 
        return "inner value";
    }

}

printName4();

function printName5(firstname) {

    var result = inner();
    console.log("name is " + result);
    console.log(typeof inner);

    function inner() { 
        return "inner value";
    }

}

printName5();

/* 
printName4와 5의 차이와 같이
함수 표현식이 함수 선언문으로 변경되자
정상적으로 동작함

이유 : 스크립트 언어라 한줄한줄 실행될것이라고 생각하나
실제로 함수로 선언되어있는 문구들을 먼저 확인하는 작업이 있다.
그래서 기억하고 있다가 함수로 인식하는 것

-> 같은 depth의 메서드들만인듯 ??
그래서 실제로 동작할 때 메서드 선언문이 끌어 올려진다고 생각하면 된다.
실제로 아래와 같은 코드로 동작
또한 실제로 함수 선언문만 끌어올려지는 것이 아니라
변수 선언문도 끌어올려진다.

이것을 호이스팅이라고 한다.(Hoisting)
*/ 

function printName6(firstname) {

    function inner() { 
        return "inner value";
    }

    var result = inner();

    console.log("name is " + result);
    console.log(typeof inner);

}

function printName7(firstname) {

    var a;

    a = function() {};

}


function funA() {
    
}

console.log(funA());

// undefine

// javascript 메서드는 void는 없고 리턴값이 없어도 undefine 을 반환한다



function c() {
    console.log(arguments);
   }
   c(1,2,3);