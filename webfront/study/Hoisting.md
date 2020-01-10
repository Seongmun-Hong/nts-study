
## 호이스팅이란 !?

### 1. 함수 선언문과 함수 표현식의 차이를 먼저 이해

- 함수 선언문 

```javacript
function func() {
    ...
}
```

- 함수 표현식

```javascript
var func = function() {
    ...
}
```

### 2. 호이스팅

```javascript
function printName2(firstname) {

    var inner = function() {
        return "inner value";
    }

    var result = inner();
    console.log("name is " + result);

}
```

위의 경우 정상 동작

```javascript
function printName3(firstname) {

    var result = inner();
    console.log("name is " + result);

    var inner = function() { 
        return "inner value";
    }

}
```

위의 경우 오류가 발생한다.

```javascript
function printName3(firstname) {

    console.log(inner); 

    var inner = function() { 
        return "inner value";
    }

}
```

위와 같이 메서드를 수정해 보면 undefine이 출력되는 것을 확인할 수 있다. 따라서 아직 함수로 인식되지 않았다는 사실을 확인할 수 있다.

하지만 아래의 코드는 정상적을 동작한다.

```javascript
function printName5(firstname) {

    var result = inner();
    console.log("name is " + result);
    console.log(typeof inner);

    function inner() { 
        return "inner value";
    }

}
```

이러한 이유가 호이스팅 때문이다.

호이스팅이란 함수 안에 있는 선언들을 모두 끌어올려서 해당 함수 유효 범위의 최상단에 선언하는 것을 말한다.

### 2-1. 같은 이름의 var 변수 선언과 함수 선언에서의 호이스팅

#### 변수 선언이 함수 선언보다 위로 끌어올려진다.

```javascript
var myName = "hi";

function myName() {
    console.log("yuddomack");
}
function yourName() {
    console.log("everyone");
}

var yourName = "bye";

console.log(typeof myName);
console.log(typeof yourName);
```

위의 코드는 아래와 같이 호이스팅이 이루어진다.

```javascript
/** --- JS Parser 내부의 호이스팅(Hoisting)의 결과 --- */
// 1. [Hoisting] 변수값 선언 
var myName; 
var yourName; 

// 2. [Hoisting] 함수선언문
function myName() {
    console.log("yuddomack");
}
function yourName() {
    console.log("everyone");
}

// 3. 변수값 할당
myName = "hi";
yourName = "bye";

console.log(typeof myName); // > string
console.log(typeof yourName); // > string
```

### 2-2. 값이 할당되어있지 않은 변수와 할당되어있는 변수에서 호이스팅

```javascript
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
```

2-1에서 확인하였듯 변수값 할당이 마지막으로 진행되기 때문에 myName은 변수값 할당이 마지막에 이루어져 string이 되고 yourName은 변수값 할당이 없기 때문에 함수가 된다. 또한 myName은 string이 되었기 때문에 myName()을 호출하면 오류가 발생한다.

### 정리

- 코드의 가독성과 유지보수를 위해 호이스팅이 일어나지 않도록 하는 것이 좋다. 
    - 함수와 변수를 가급적 코드 상단부에 선언하면 호이스팅으로 인한 스코프 꼬임 현상은 방지할 수 있다.