### Filter Interceptor AOP

스프링에서 사용되는 Filter, Interceptor, AOP 세 가지 기능은 모두 무슨 행동을 하기전에 먼저 실행하거나, 실행한 후에 추가적인 행동을 할 때 사용되는 기능들이다.

1. Filter
    - 일반적으로 인코딩 변환 처리, XSS방어 등의 요청에 대한 처리

2. Interceptor
    - 인터셉터는 여러 개를 사용할 수 있고 로그인 체크, 권한체크, 프로그램 실행시간 계산작업 로그확인 등의 업무처리

3. AOP
    - OOP를 보완하기 위해 나온 개념
    - 주로 로깅, 트랜잭션, 에러 처리 등 비즈니스단의 메서드에서 조금 더 세밀하게 조정하고 싶을 때 사용합니다


- Interceptor나 Filter와는 달리 메소드 전후의 지점에 자유롭게 설정이 가능하다.

- Interceptor와 Filter는 주소로 대상을 구분해서 걸러내야하는 반면, AOP는 주소, 파라미터, 애노테이션 등 다양한 방법으로 대상을 지정할 수 있다.

- AOP의 Advice와 HandlerInterceptor의 가장 큰 차이는 파라미터의 차이다.
    - Advice의 경우 JoinPoint나 ProceedingJoinPoint 등을 활용해서 호출한다.
    - HandlerInterceptor는 Filter와 유사하게 HttpServletRequest, HttpServletResponse를 파라미터로 사용한다.
