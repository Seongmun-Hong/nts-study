## SQL이란 ?

http://www.ciokorea.com/print/35385
위 링크 꼭 읽어보기 !

- SQL은 데이터를 보다 쉽게 검색하고 추가, 삭제, 수정 같은 조작을 할 수 있도록 고안된 컴퓨터 언어입니다.
- 관계형 데이터베이스에서 데이터를 조작하고 쿼리하는 표준 수단입니다.
- DML (Data Manipulation Language): 데이터를 조작하기 위해 사용합니다.
    - INSERT, UPDATE, DELETE, SELECT 등이 여기에 해당합니다.
- DDL (Data Definition Language): 데이터베이스의 스키마를 정의하거나 조작하기 위해 사용합니다.
    - CREATE, DROP, ALTER 등이 여기에 해당합니다.
- DCL (Data Control Language) : 데이터를 제어하는 언어입니다.
권한을 관리하고, 테이터의 보안, 무결성 등을 정의합니다.
    - GRANT, REVOKE 등이 여기에 해당합니다.


## MYSQL 8버전 이상 유저 생성

```SQL
create user 'connectuser'@'localhost' identified by 'connect123!@#';

grant all privileges on connectdb.* to 'connectuser'@'localhost';

grant all privileges on connectdb.* to 'connectuser'@'%';

flush privileges;
```

### 데이터베이스 접속

```shell
mysql -uroot -p 

mysql -hlocalhost -uconnectuser -p connectdb
```

### examples.sql 파일에 있는 query 실행시키기


터미널 실행 후 우선 examples.sql 이 존재하는 디렉토리로 이동하고 그 후 아래의 명령어 입력

```shell
mysql -uconnectuser -p connectdb < examples.sql
```
