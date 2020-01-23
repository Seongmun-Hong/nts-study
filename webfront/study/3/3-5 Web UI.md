1. javascript 파일 구성
    - 간단한 내용의 javascript라면 한 페이지에 표현하는 것도 좋다.
    - 그렇지 않다면 의미에 맞게 구분하는 것이 좋다.

2. HTML안에 javscript 구성
    - CSS는 head 태그 상단에 위치
    - javascript는 body 태그 닫히기 전에 소스 파일 간 의존성을 이해해서 순서대로 배치


## load와 DOMContentLoaded

DOM Tree 분석이 끝나면 DOMContentLoaded 이벤트가 발생하며, 그 외 모든 자원(img, style 등등..)이 다 받아져서 브라우저에 렌더링(화면 표시)까지 다 끝난 시점에는 Load가 발생합니다.

이를 이해하고, 필요한 시점에 두 개의 이벤트를 사용해서 자바스크립트 실행을 할 수 있습니다. 

보통 DOM tree가 다 만들어지면 DOM APIs를 통해서 DOM에 접근할 수 있기 때문에, 실제로 실무에서는 대부분의 자바스크립트코드는 DOMContentLoaded 이후에 동작하도록 구현합니다.

그 방법이 로딩속도 성능에 유리하다고 생각하기 때문입니다.

- DOMContentLoaded 
    - DOM 이 준비 상태이기 때문에, DOM 노드를 제어할 수 있다.
- load 
    - 모든 리소스가 로드된 시점이기에, image 사이즈와 같은 것들을 얻을 수 있다.
- beforeunload / unload 
    - 변화에 따른 저장 여부 및 페이지 이탈 여부를 확인할 수 있다.


## Vender prefix

https://sapjil.net/vender-prefix/