## MVC란?

- MVC는 Model-View-Controller의 약자

    - Model : 모델은 뷰가 렌더링하는데 필요한 데이터입니다. 예를 들어 사용자가 요청한 상품 목록이나, 주문 내역이 이에 해당합니다.
    - View : 웹 애플리케이션에서 뷰(View)는 실제로 보이는 부분이며, 모델을 사용해 렌더링을 합니다. 뷰는 JSP, JSF, PDF, XML등으로 결과를 표현합니다.
    - Controller : 컨트롤러는 사용자의 액션에 응답하는 컴포넌트입니다. 컨트롤러는 모델을 업데이트하고, 다른 액션을 수행합니다.


## MVC1 vs MVC2

- MVC1
    - JSP페이지가 요청을 받고 비지니스 로직을 실행
        - JSP페이지가 Controller와 View의 역할을 모두 수행
- MVC2
    - Servlet이 Controller역할을 수행하며 비지니스로직을 처리하고 JSP페이지를 View로 활용하여 응답을 줌

- Spring MVC 에서는 MVC2 패턴을 사용

## Spring MVC 기본 동작 흐름

1. 브라우저로부터의 요청을 Dispatcher Servlet이 받는다.
2. 해당 요청을 처리하기 위한 Controller를 Handler Mapping을 통하여 알아낸다.
3. 실제 요청을 전달하기 위하여 Handler Adapter를 통해 처리할 Controller로 전달한다.
4. 전달된 요청에 대한 비지니스 로직을 수행한 후 해당 결과를 출력할 View의 이름과 Model을 리턴한다.
5. 결과를 출력할 View를 View Resolver를 통하여 얻는다.
6. Dispatcher Servlet은 Model의 데이터를 View에 바인딩하여 사용자에게 응답한다.


## Dispatcher Servlet

- Front Controller
- 클라이언트의 모든 요청을 받은 후 이를 처리할 핸들러에게 넘기고 핸들러가 처리한 결과를 받아 사용자에게 응답 결과를 보여준다.
- Dispatcher Servlet은 여러 컴포넌트를 이용해 작업을 처리한다.

### Dispatcher Servlet내부 동작 흐름

1. 요청이 들어오면 요청에 대한 선처리 작업을 한다.
    - 선처리 작업이란??
        1. Locale 결정(Spring은 지역화 기능을 제공)
            - 각 사용자 브라우저의 언어세팅 등을 기반으로
        2. RequestContextHolder에 요청을 저장
            - Thread Local 객체
            - 요청을 받아 응답을 줄 때 까지 Request와 Response 등을 스프링이 관리하는 객체 안에서 사용할 수 있게 해주는 작업
        3. FlashMap 복원
            - Redirect로 값을 전달할 때 사용됨
            - Redirect시 RequestParam을 1번 값을 유지할 수 있게 해줌
        4. 사용자가 File Upload를 했을 경우 파일정보를 읽는 특수한 형태의 Request객체가 필요하다. 이러한 경우 Multipart Resolver가 멀티파트를 결정한다.
        5. 실제 요청을 처리하는 핸들러를 결정핟고 실행한다.
2. 선처리 작업이 끝나면 HandlerExcutionChain을 결정한다.
3. HandlerExcutionChain을 실행한다.
    - 실행하는 과정에서 예외가 발생하면 예외를 처리한다
4. 뷰를 렌더링한다.
5. 요청 처리를 종료한다.

### 요청 전달

1. HandlerMapping으로 HandlerExcutionChain을 결정
2. HandlerExcutionChain을 발견하지 못하면 Http 404를 전달한다.
3. Handler Adapter를 결정한다.
4. Handler Adapter를 발견하지 못하면 ServletException 발생
5. 요청 처리

### 요청 처리 

1. 사용 가능한 인터셉터가 존재하면 인터셉터의 preHandler를 호출하여 요청을 처리
2. 핸들러를 실행
3. 리턴하는 결과가 ModelAndView 객체이고 그 ModelAndView 객체가 View를 가지고 있지 않다면 RequestToViewNameTranslator가 동작한다.
4. 가지고 있다면 Interceptor의 postHandle을 호출하여 요청을 처리한다.
5. 뷰를 랜더링한다.

### 예외 처리

1. 예외가 발생하면 HandlerExceptionResolver에 문의
2. ModelAndView가 있다면 요청처리를 재개
3. 없다면 예외를 다시 던짐

### 뷰 렌더링 과정

1. 뷰가 String이라면 ViewResolver로 구현체를 찾는다.
    - 그 과정에서 View가 존재하지 않으면 ServletException을 던짐
2. View의 구현체로 렌더링


### 요청 처리 종료

1. HandlerExcutionChain이 존재하면 인터셉터의 afterCompletion 메소드 실행
2. RequestHandleEvent 발생



### 요청 선처리 작업시 사용된 컴포넌트

- org.springframework.web.servlet.LocaleResolver
    - 지역 정보를 결정해주는 전략 오브젝트이다.
    - 디폴트인 AcceptHeaderLocalResolver는 HTTP 헤더의 정보를 보고 지역정보를 설정해준다.

- org.springframework.web.servlet.FlashMapManager
    - FlashMap객체를 조회(retrieve) & 저장을 위한 인터페이스
    - RedirectAttributes의 addFlashAttribute메소드를 이용해서 저장한다.
    - 리다이렉트 후 조회를 하면 바로 정보는 삭제된다.

- org.springframework.web.context.request.RequestContextHolder

    - 일반 빈에서 HttpServletRequest, HttpServletResponse, HttpSession 등을 사용할 수 있도록 한다.
    - 해당 객체를 일반 빈에서 사용하게 되면, Web에 종속적이 될 수 있다.

- org.springframework.web.multipart.MultipartResolver   
    - 멀티파트 파일 업로드를 처리하는 전략


### 요청 전달시 사용된 컴포넌트

- org.springframework.web.servlet.HandlerMapping
    - HandlerMapping구현체는 어떤 핸들러가 요청을 처리할지에 대한 정보를 알고 있다.
    - 디폴트로 설정되는 있는 핸들러매핑은   - BeanNameHandlerMapping과 DefaultAnnotationHandlerMapping 2가지가 설정되어 있다.

- org.springframework.web.servlet.HandlerExecutionChain
    - HandlerExecutionChain구현체는 실제로 호출된 핸들러에 대한 참조를 가지고 있다.
    - 즉, 무엇이 실행되어야 될지 알고 있는 객체라고 말할 수 있으며, 핸들러 실행전과 실행후에 수행될 HandlerInterceptor도 참조하고 있다.

- org.springframework.web.servlet.HandlerAdapter
    - 실제 핸들러를 실행하는 역할을 담당한다.
    - 핸들러 어댑터는 선택된 핸들러를 실행하는 방법과 응답을 ModelAndView로 변화하는 방법에 대해 알고 있다.
    - 디폴트로 설정되어 있는 핸들러어댑터는 HttpRequestHandlerAdapter, SimpleControllerHandlerAdapter, AnnotationMethodHanlderAdapter 3가지이다.
    - @RequestMapping과 @Controller 애노테이션을 통해 정의되는 컨트롤러의 경우 DefaultAnnotationHandlerMapping에 의해 핸들러가 결정되고, 그에 대응되는 AnnotationMethodHandlerAdapter에 의해 호출이 일어난다.
    
### 요청 처리시 사용된 컴포넌트

- org.springframework.web.servlet.ModelAndView
    - ModelAndView는 Controller의 처리 결과를 보여줄 view와 view에서 사용할 값을 전달하는 클래스이다.

- org.springframework.web.servlet.RequestToViewNameTranslator
    - 컨트롤러에서 뷰 이름이나 뷰 오브젝트를 제공해주지 않았을 경우 URL과 같은 요청정보를 참고해서 자동으로 뷰 이름을 생성해주는 전략 오브젝트이다. 디폴트는 DefaultRequestToViewNameTranslator이다.


### 예외 처리시 사용된 컴포넌트

- org.springframework.web.servlet.handlerexceptionresolver
    - 기본적으로 DispatcherServlet이 DefaultHandlerExceptionResolver를 등록한다.
    - HandlerExceptionResolver는 예외가 던져졌을 때 어떤 핸들러를 실행할 것인지에 대한 정보를 제공한다.

### 뷰 렌더링 과정시 사용된 컴포넌트

- org.springframework.web.servlet.ViewResolver
    - 컨트롤러가 리턴한 뷰 이름을 참고해서 적절한 뷰 오브젝트를 찾아주는 로직을 가진 전략 오프젝트이다.
    - 뷰의 종류에 따라 적절한 뷰 리졸버를 추가로 설정해줄 수 있다.




## DispatcherServlet을 FrontContoller로 설정하기

- web.xml 파일에 설정
- javax.servlet.ServletContainerInitializer 사용
    - 서블릿 3.0 스펙 이상에서 web.xml파일을 대신해서 사용할 수 있다.
- org.springframework.web.WebApplicationInitializer 인터페이스를 구현해서 사용