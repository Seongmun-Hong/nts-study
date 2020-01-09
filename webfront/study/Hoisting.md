
## 호이스팅이란 !?

### 함수 선언문과 함수 표현식의 차이를 먼저 이해

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

### 호이스팅

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

### 같은 이름의 var 변수 선언과 함수 선언에서의 호이스팅

```javascript
var myName = "Heee"; // 값 할당 
var yourName; // 값 할당 X

function myName() { // 같은 이름의 함수 선언
    console.log("myName Function");
}
function yourName() { // 같은 이름의 함수 선언
    console.log("yourName Function");
}

console.log(typeof myName); // > "string"
console.log(typeof yourName); // > "function"
```

### 정리

- 코드의 가독성과 유지보수를 위해 호이스팅이 일어나지 않도록 선언문의 순서를 유의하자.