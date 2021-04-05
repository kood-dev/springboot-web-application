# Spring Boot Web Application Sample
개인 포폴을 위한 프로젝트 샘플, 스프링 부트와 웹 어플리케이션

## 목표
    - 커머스 만들기 ????
## 사용기술
1. Spring
    - Boot Stater
        - Security
        - Web
        - JPA
        - Redis
        - Thymeleaf
2. DB
    - H2
99. Third party
    - Thymeleaf
        - security
        - layout
    - Lombok
    - Swagger
## Project module & package
- root project
    - apps
        - api
        - admin-console
    - client
        - core(기본 web 설정들 ...)
        - pay api
    - domains
        - customer
        - board
    - modules
        - etc ... db modules
--- 
# 공부공부해 부르쓰
## Multi module
    서비스 ? 독립적으로 실행 가능한 애플리케이션 
    시스템 ? 1개 이상의 서비스와 공유 인프라를 가진 것  
    애플리케이션 로직 ? 요청 파라미터 검증, 메세징큐 데이터 요청 ...   
    도메인 로직 ? 실제 도메인이 처리하고 있는 로직    
### 모듈 레이어
1. 애플리케이션 모듈 계층
2. 내부 모듈 계층, 도메인 모듈 계층
3. 공통 모듈 계층
4. 독립 모듈 계층
- common: 공통 모듈, 정말 모든 모듈에서 사용하는것만 1개의 모듈이라도 사용하지 않을경우 강력하게...고민해본다.
- domains(core):도메인 모듈, 순수하게 도메인에만 집중하며 하나의 인프라스트럭처만 가진다.
    - 도메인 비지니스는 o / 서비스 비지니스는 X
    - 도메인 간에 결합이 필요한 비지니스가 생길 경우 필요한 도메인들을 결합한 모듈을 생성한다.
- client: 내부 모듈
- modules: 독립 모듈, 프로젝트 내 서비스외 독립적으로 사용가능한 모듈(DB, Cache, AWS...)
### **참고**
>우형 기블 권용근님 https://woowabros.github.io/study/2019/07/01/multi-module.html  
>우형 이동욱님 https://jojoldu.tistory.com/444    
>라인 블로그 https://engineering.linecorp.com/ko/blog/mono-repo-multi-project-gradle-plugin/
### Aha !!!! Eureka
```@ConditionalOnMissingBean```
- 확장, 변경의 가능성을 열어두기 위해 하위 모듈의 ```@Bean```에 선언한다.
- 상위 모듈에서 하위 모듈의 빈을 확장 또는 변경할 경우 하위 모듈의 @Bean은 호출되지 않는다.  
  즉, 상위 모듈에서 새로 선언한 ```@Bean```으로 대체한다.
  ```gradle``` ```implementation``` ```api```
- gradle compile 이 deprecated 되고 두가지 방식을 제공한다.
- ```implementation``` 은 하위 의존 관계를 숨겨준다.
- ```어플리케이션 모듈 계층```에서는 ```implementation```을 사용하여 하위 계층을 숨키고 그외 계층에서는 ```api```를 사용하여 개발
  A Module
```
    public class A {}
```
B Module
``` 
api project(':A') 
```
C Module
``` 
implementation project(':B') 
```
``` 
public class C {
    public void test() {
        new A() <-- compile error 
    }
}
```