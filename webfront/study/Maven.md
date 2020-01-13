# Maven이란 ?

Maven은 지금까지 애플리케이션을 개발하기 위해 반복적으로 진행해왔던 작업들을 지원하기 위하여 등장한 도구

## pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>kr.or.connect</groupId>
    <artifactId>examples</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>mysample</name>
    <url>http://maven.apache.org</url>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

### 각 태그들...
- project : pom.xml 파일의 최상위 루트 엘리먼트(Root Element)입니다.
- modelVersion : POM model의 버전입니다. 
- groupId : 프로젝트를 생성하는 조직의 고유 아이디를 결정합니다. 일반적으로 도메인 이름을 거꾸로 적습니다.
- artifactId : 해당 프로젝트에 의하여 생성되는 artifact의 고유 아이디를 결정합니다. Maven을 이용하여  pom.xml을 빌드할 경우 다음과 같은 규칙으로 artifact가 생성됩니다. artifactid-version.packaging. 위 예의 경우 빌드할 경우 examples-1.0-SNAPSHOT.jar 파일이 생성됩니다.
- packaging : 해당 프로젝트를 어떤 형태로 packaging 할 것인지 결정합니다. jar, war, ear 등이 해당됩니다.
- version : 프로젝트의 현재 버전. 추후 살펴보겠지만 프로젝트가 개발 중일 때는 SNAPSHOT을 접미사로 사용합니다. Maven의 버전 관리 기능은 라이브러리 관리를 편하게 합니다.
- name : 프로젝트의 이름입니다.
- url : 프로젝트 사이트가 있다면 사이트 URL을 등록하는 것이 가능합니다.


### Servlet 추가

```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
    <scope>provided</scope>
</dependency>
```

### Scope ??

- compile 
    - 컴파일 할 때 필요. 테스트 및 런타임에도 클래스 패스에 포함됩니다. scope 을 설정하지 않는 경우 기본값입니다.
- runtime
    - 런타임에 필요. JDBC 드라이버 등이 예가 됩니다. 컴파일 시에는 필요하지 않지만, 실행 시에 필요한 경우입니다.
- provided
    - 컴파일 시에 필요하지만, 실제 런타임 때에는 컨테이너 같은 것에서 제공되는 모듈. servlet, jsp api 등이 이에 해당. 배포 시 제외됩니다. 
- test 
    - 테스트 코드를 컴파일 할 때 필요. 테스트 시 클래스 패스에 포함되며, 배포 시 제외됩니다.

