## EL

### 문법

${expr}

### 기본 객체

- pageContext
    - JSP의 page 기본 객체와 동일하다.
- pageScope
    - pageContext 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체
- requestScope
    - request 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체
- sessionScope
    - session 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체
- applicationScope
    - application 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체
- param
    - 요청 파라미터의 <파라미터이름, 값> 매핑을 저장한 Map 객체. 파라미터 값의 타입은 String으로서, request.getParameter(이름)의 결과와 동일하다.
- paramValues
    - 요청 파라미터의 <파라미터이름, 값배열> 매핑을 저장한 Map 객체.
    - 값의 타입은 String[]으로서, request.getParameterValues(이름)의 결과와 동일하다.
- header
    - 요청 정보의 <헤더이름, 값> 매핑을 저장한 Map 객체, request.getHeader(이름)의 결과와 동일하다.
- headerValues
    - 요청 정보의 <헤더이름, 값 배열> 매핑을 저장한 Map 객체.
    - request.getHeaders(이름)의 결과와 동일하다.
- cookie
    - <쿠키 이름, Cookie> 지정한 Map 객체.
    - request.getCookies()로 구한 Cookie배열로부터 매핑을 생성한다.
- initParam
    - 초기화 파라미터의 <이름, 값> 매핑을 저장한 Map 객체,
    - application.getInitParameter(이름)의 결과와 동일하다.


Servlet 2.5부터는 자동 탑재
EL을 무시하고 싶다면

```jsp
<%@ page isELIgnored = "true" %> 
```

와 같이 선언하면 된다.