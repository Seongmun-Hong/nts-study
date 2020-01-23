## 컨테이너란 ?

- 인스턴스의 생명주기를 관리
- 생성된 인스턴스들에게 추가적인 기능을 제공

## IoC란 ?

- Inversion of Control의 약어
- 제어의 역전
- 개발자는 프로그램의 흐름을 제어하는 코드를 작성하지만 이 흐름의 제어를 개발자가 아닌 다른 프로그램이 해주는 것을 IoC라고 한다.

## DI란 ?

- Dependency Injection의 약자, 의존성 주입
- 클래스 사이의 의존관계를 Bean 설정 정보를 바탕으로 컨테이너가 자동으로 연결해주는 것을 말한다.

## Spring에서 제공하는 IoC/DI 컨테이너

- BeanFactory : IoC/DI에 대한 기본 기능을 가지고 있다.
- ApplicationContext : BeanFactory의 모든 기능을 포함하며, 일반적으로 BeanFactory보다 추천된다.
    - 트랜잭션 처리, AOP에 대한 처리를 할 수 있다.
    - BeanPostProcessor, BeanFactoryPostProcessor 등을 자동으로 등록하고, 국제화 처리, 어플리케이션 이벤트 등을 처리할 수 있다.
        - BeanPostProcessor
            - 컨테이너의 기본 로직을 오버라이딩하여 인스턴스화 와 의존성 처리 로직 등을 개발자가 원하는 대로 구현 할 수 있도록 한다.
        - BeanFactoryPostProcessor
            - 설정 메타데이터를 커스터마이징 할 수 있게 해준다.

## Spring에서 Bean 생성 순서

기본적으로 매개변수가 없는 생성 메서드를 먼저 호출한 후 매개변수가 있는 메서드의 경우 해당 인자의 타입이 생성된 Bean일 경우 해당 Bean을 인자로 주입해준다.

Java config를 이용한 설정을 위한 어노테이션

@Configuration

## 스프링 설정 클래스를 선언하는 어노테이션
- @Bean
    - bean을 정의하는 어노테이션

- @ComponentScan
    - @Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록

- @Component
    - 컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션

- @Autowired
    - 주입 대상이되는 bean을 컨테이너에 찾아 주입하는 어노테이션