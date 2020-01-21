### javascript event type

https://developer.mozilla.org/en-US/docs/Web/Events


## JSON

표준적인 데이터 포멧을 결정하기 위해서 주로 사용한다.


## AJAX

```javascript
function ajax(data) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
        console.log(this.responseText);
    });    
    oReq.open("GET", "http://www.example.org/getData?data=data");//parameter를 붙여서 보낼수있음. 
    oReq.send();
}
```
XMLHttpRequest 객체를 생성하고 open 메서드로 요청을 준비하고 send 메서드로 서버로 요청을 보낸다.

요청 처리가 완료되면 load 이벤트가 발생하고, 콜백 함수가 실행된다.

비동기 로직이다.


