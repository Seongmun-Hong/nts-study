# CORS(Cross Origin Resource Sharing)

도메인 또는 포트가 다른 서버의 자원을 요청하는 매커니즘이다.
이때 요청을 할 때는 cross-origin HTTP에 의해 요청된다.
하지만 동일 출처 정책(same origin policy) 때문에 CORS 같은 상황이 발생하면 외부서버에 요청한 데이터를 브라우저에서 보안목적으로 차단한다.

- 동일 출처 정책(same-origin policy)
    - 불러온 문서나 스크립트가 다른 출처에서 가져온 리소스와 상호작용하는 것을 제한하는 중요한 보안 방식이다. 이것은 잠재적 악성 문서를 격리하여, 공격 경로를 줄이는데 도움이 된다.

### 1. 요청 시 OPTIONS가 날라가던 이유 ?

사용자 데이터 상에서 부수 효과를 일으킬 수 있는 HTTP 요청 메서드에 대해 스펙은 브라우저가 요청을 "preflight"(사전 전달)하도록 강제하는데, 이는 HTTP OPTIONS 요청 메서드를 이용해 서버로부터 지원 중인 메서드들을 내려 받은 뒤, 서버에서 "approval"(승인) 시에 실제 HTTP 요청 메서드를 이용해 실제 요청을 전송한다.

>https://developer.mozilla.org/ko/docs/Web/HTTP/Access_control_CORS 해당 링크에 자세한 설명이 더 많이 나와있다. 꼭 다시 공부해 볼 것!

## 2. Servlet에서 CROS문제 해결하기

CROS문제를 해결해보기 위한 html, javascript를 생성하자.

#### cros.html
```html
<html>
<header></header>
<body>
    <div class="outside">outside element</div>
</body>
<script src="cors.js"></script>
</html>
```

#### cors.js

```javascript
var oReq = new XMLHttpRequest();
oReq.addEventListener("load", function() {
    console.log(this.responseText);
});    

oReq.open("POST", "http://localhost:8080/cors/");

oReq.send();
```

또한 요청을 보낼 서블릿을 만들었다.

#### Cors.java
```java
@WebServlet("/cors")
public class Cors extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HTML_CODE = "<html><head></head><body>CORS TEST</body></html>";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("GET");
        PrintWriter writer = response.getWriter();

		writer.print(HTML_CODE);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("POST");
        PrintWriter writer = response.getWriter();

		writer.print("{ \r\n" +
			"\"apple\":1000\r\n" +
			"}");
	}

	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("OPTIONS");
		response.setContentType("text/html");
	}

}
```

위와 같이 설정한 후 html 페이지를 실행시키면

아래와 같은 콘솔 로그를 확인할 수 있다.

```text
Access to XMLHttpRequest at 'http://localhost:8080/cors/' from origin 'null' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
cors.js:23 Cross-Origin Read Blocking (CORB) blocked cross-origin response http://localhost:8080/cors/ with MIME type application/json. See https://www.chromestatus.com/feature/5629709824032768 for more details.
```

### TODO: 서버에서 POST 로그는 왜 떴을까 ?? 서버는 정상 응답을 주는 것이나 브라우저에서 막는다 ??

브라우저 콘솔 로그에서 메세지를 준것과 같이 서버에서 response header에 'Access-Control-Allow-Origin'를 추가시켜 보자.

#### Cors.java - doPost

```java 
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    System.out.println("POST");
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin", "*");

    PrintWriter writer = response.getWriter();

    writer.print("{ \r\n" +
        "\"apple\":1000\r\n" +
        "}");
}
```

위와 같이 설정한 후 html페이지를 새로고침하면 아래와 같이 정상 응답을 얻을수 있다.

```json
{ 
"apple":1000
}
```

### 간단 정리 

크롬 개발자도구에서 network탭을 통하여 확인해 보면 request header의 origin이 null이다. 이렇듯 origin이 null로 왔기 때문에 서버에서는 이러한 null로 온 origin을 허용하기 위하여 *(모두 허용)을 사용하였다. 특정 호스트만 허용하고자 할때 요청 header의 origin값을 확인하여 해당 사용자만 허용할 수 있다.

## 3. 데이터를 포함한 요청...?

cors.js파일을 아래와 같이 수정하여 데이터를 포함하여 요청을 보낸다.

```javascript
var oReq2 = new XMLHttpRequest();
oReq2.addEventListener("load", function() {
    console.log(this.responseText);
});    

oReq2.open("POST", "http://localhost:8080/cors/");
oReq2.setRequestHeader('Content-Type', 'application/json');

var data = "{ 'name': 'Seongmun' }"
oReq2.send(data);
```

브라우저 콘솔 결과는 아래와 같다.

```text
Access to XMLHttpRequest at 'http://localhost:8080/cors/' from origin 'null' has been blocked by CORS policy: Request header field content-type is not allowed by Access-Control-Allow-Headers in preflight response.
```

하지만 조금 다른 사실은 개발자 모드의 Network탭을 확인하면 요청을 POST가 아닌 OPTIONS로 보냈으며 서버 로그에도 OPTIONS가 출력 된 것을 확인할 수 있다.

이렇듯 데이터를 주는 경우가 위에서 봤던 **부수 효과를 일으킬 수 있는 HTTP 요청 메서드** 를 뜻하는 것 같다...? 

우선 요청을 해결하기 위해 다시 OPTIONS에도 Access-Control-Allow-Headers에 Content-Type을 추가해 보자.

> 추가하고 보내도 Access-Control-Allow-Origin 오류가 뜬다. origin allow도 함께 추가해준다.

#### Cors.java - doOptions

```java
@Override
protected void doOptions(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    System.out.println("OPTIONS");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
    response.setHeader("Access-Control-Allow-Origin", "*");
}
```

다시 html페이지를 실행해 결과를 확인해 보면 응답을 재대로 받은 것을 확인할 수 있다.


### 정리


아직 조금 헷갈리는 부분도 많긴 하나. 클라이언트에서 보내는 data type을 정의하기 위하여 header에 Content-Type을 추가하였다. 하지만 이는 CORS에서 허용된 아래 3개의 Content-Type
- application/x-www-form-urlencoded
- multipart/form-data
- text/plain

이외의 타입으로 요청하였기 때문에 "Request header field content-type is not allowed by Access-Control-Allow-Headers in preflight response."와 같은 응답을 받았다. 따라서 Access-Control-Allow-Headers에 Content-Type을 넣어주어 허용해 주었다.

또한 2번 예제에서와 같이 origin도 allow 해주면 CORS 문제를 해결할 수 있다.


> Filter에서 Request 별로 header와 origin을 허용해준다면 더욱 쉽게 문제를 해결할 수 있다.

> 또한 보안 이슈인 만큼 더 생각해보고 신중히 사용해야 할 것 같다.

### 다시 읽어볼것!
https://developer.mozilla.org/ko/docs/Web/HTTP/Access_control_CORS#Examples_of_access_control_scenarios