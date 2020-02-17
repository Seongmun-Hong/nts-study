## Spring JDBC

- JDBC 프로그래밍을 보면 반복되는 개발 요소가 많다. 개발하기 지루한 JDBC의 모든 저수준 세부사항을 스프링 프레임워크가 처리준다.

## Spring JDBC 패키지

- org.springframework.jdbc.core
    - JdbcTemplate 및 관련 Helper 객체 제공

- org.springframework.jdbc.datasource
    - DataSource를 쉽게 접근하기 위한 유틸 클래스, 트랜젝션매니져 및 다양한 DataSource 구현을 제공

- org.springframework.jdbc.object
    - RDBMS 조회, 갱신, 저장등을 안전하고 재사용 가능한 객제 제공

- org.springframework.jdbc.support
    - jdbc.core 및 jdbc.object를 사용하는 JDBC 프레임워크를 지원


## JdbcTemplate외의 접근방법

- NamedParameterJdbcTemplate
    - JdbcTemplate에서 JDBC statement 인자를 ?를 사용하는 대신 파라미터명을 사용하여 작성하는 것을 지원

- SimpleJdbcTemplate
    - JdbcTemplate과 NamedParameterJdbcTemplate 합쳐 놓은 템플릿 클래스
    - 이제 JdbcTemplate과 NamedParameterJdbcTemplate에 모든 기능을 제공하기 때문에 삭제 예정될 예정(deprecated)

- SimpleJdbcInsert
    - 테이블에 쉽게 데이터 insert 기능을 제공


## DTO란?

- DTO란 Data Transfer Object의 약자입니다.
- 계층간 데이터 교환을 위한 자바빈즈입니다.
- 여기서의 계층이란 컨트롤러 뷰, 비지니스 계층, 퍼시스턴스 계층을 의미합니다.
- 일반적으로 DTO는 로직을 가지고 있지 않고, 순수한 데이터 객체입니다.
- 필드와 getter, setter를 가진다. 추가적으로 toString(), equals(), hashCode()등의 Object 메소드를 오버라이딩 할 수 있습니다.


## DAO란?

- DAO란 Data Access Object의 약자로 데이터를 조회하거나 조작하는 기능을 전담하도록 만든 객체입니다.
- 보통 데이터베이스를 조작하는 기능을 전담하는 목적으로 만들어집니다.