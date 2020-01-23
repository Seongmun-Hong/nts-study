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