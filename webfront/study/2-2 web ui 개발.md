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


## CORS(Cross Origin Resource Sharing)

도메인 또는 포트가 다른 서버의 자원을 요청하는 매커니즘이다.
이때 요청을 할 때는 cross-origin HTTP에 의해 요청된다.
하지만 동일 출처 정책(same origin policy) 때문에 CORS 같은 상황이 발생하면 외부서버에 요청한 데이터를 브라우저에서 보안목적으로 차단한다.

- 동일 출처 정책(same-origin policy)
    - 불러온 문서나 스크립트가 다른 출처에서 가져온 리소스와 상호작용하는 것을 제한하는 중요한 보안 방식이다. 이것은 잠재적 악성 문서를 격리하여, 공격 경로를 줄이는데 도움이 된다.

### GET 이외의 요청 시 OPTIONS가 날라가던 이유 ?

사용자 데이터 상에서 부수 효과를 일으킬 수 있는 HTTP 요청 메서드에 대해 스펙은 브라우저가 요청을 "preflight"(사전 전달)하도록 강제하는데, 이는 HTTP OPTIONS 요청 메서드를 이용해 서버로부터 지원 중인 메서드들을 내려 받은 뒤, 서버에서 "approval"(승인) 시에 실제 HTTP 요청 메서드를 이용해 실제 요청을 전송한다.

-> 

CORS prefight를 트리거 하지 않는 요청들
- GET
- HEAD
- 