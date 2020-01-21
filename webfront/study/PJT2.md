## Class.forName("xxx")

JVM에게 해당 클래스의 정보를 로드한다.
즉 한번 JVM에 로드된다면 그 이후 다시 호출할 필요가 없다.
https://kyun2.tistory.com/23

## JSP/Servlet 개발 시 .jsp 파일 경로

JSP/Servlet 컨테이너는 WEB-INF 디렉토리 이하를 보안상의 문제로 웹 브라우저를 통한 접근을 금지하고 있다. 하지만 포워딩을 통한 접근은 웹 브라우저를 통하지 않기 때문에 가능하다.

따라서 JSP 페이지를 WEB-INF 아래 두는 것을 권장한다. 웹 브라우저를 통한 직접 엑세스가 불가능하므로 컨트롤러를 통해 엑세스 됨을 보장할 수 있기 때문에 EL ,JSTL 등을 사용하여 모델을 화면에 출력할 경우 view 표현할 모델이 Servlet을 통해 저장되는 것을 보장할 수 있다.

http://egloos.zum.com/kwon37xi/v/2850553
https://ui.toast.com/weekly-pick/ko_20160826/