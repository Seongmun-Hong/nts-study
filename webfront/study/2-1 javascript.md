## javascript Type Check

Javascript는 타입을 체크하는 또렷한 방법은 없다. 정확하게 toString.call 을 이용해서 그 결과를 매칭하곤 하는데, 문자, 숫자와 같은 기본 타입은 typeof 키워드를 사용해서 체크할 수 있다.

배열과 같은 경우에는 isArray함수가 표준으로 존재한다.

## for 구문

```javascript
var arr = [1, 2, 3];
```

위와 같은 배열이 존재

```javascript
for(var i=0, ; i<arr.length; i++) {
    ...
}
```

일반적인 for구문 하지만 length를 계속 호출하므로 아래와 같이 변경

```javascript
for(var i=0, len = arr.length; i<len; i++) {
    ...
}
```

### for구문은 reverse 루프를 도는 것이 더 빠르다 ?

- 사실은 둘다 똑같이 빠르다.

```javascript
for(var i = 1; i <= array.length; i++)
```

``` javascript
for(var i = array.length; i>=0; i--;)
```

length를 여러번 확인하게 되어 이러한 말이 나온 것 같다.

따라서 length를 한번만 호출하게 해주면 될 것 같다.

https://stackoverflow.com/questions/1340589/are-loops-really-faster-in-reverse

https://arnaudroger.github.io/blog/2017/06/15/forward-vs-backward-loop.html

## 함수 - arguments 속성

함수가 실행되면 그 안에는 arguments라는 특별한 지역변수가 자동으로 생성된다. arguments의 타입은 객체이다.

```javascript
function a() {
 console.log(arguments);
}
a(1,2,3);
```

위와 같이 실행하면 

```text
[Arguments] { '0': 1, '1': 2, '2': 3 }
```
와 같이 출력된다.

자바스크립트의 가변인자를 받아서 처리하는 함수를 만들때 등에서 유용하게 사용할 수 있다.

### ex

```javascript
function a() {
    for(var i=0; i<arguments.length; i++) {
        console.log(arguments);
    )
}
a(1, 2, "my name is seongmun");
```

출력 결과 

```text
1
2
my name is seongmun
```

## Arrow function

```javascript
function getName(name) {
   return "Kim " + name ;
}
```

위 함수는 아래 arrow함수와 같다.

```javascript
var getName = (name) => "Kim " + name;
```

읽어보기 ~
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions


