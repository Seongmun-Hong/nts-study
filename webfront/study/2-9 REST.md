## Deview REST API 영상

https://youtu.be/RP_f5dMoHFc

## REST가 지켜야할 규약

- client-server
- stateless
- cache
- uniform interface
- layered system
- code-on-demand (optional)

### uniform interface

- 리소스가 URI로 식별되야 합니다.
- 리소스를 생성,수정,추가하고자 할 때 HTTP메시지에 표현을 해서 전송해야 합니다.
- 메시지는 스스로 설명할 수 있어야 합니다. (Self-descriptive message)
- 애플리케이션의 상태는 Hyperlink를 이용해 전이되야 합니다.(HATEOAS)


위의 모든 것들을 지키지 못한다면 Web API 혹은 HTTP API라고 부른다.

(REST의 모든 것을 제공하지 않으면서 REST API라고 말하는 경우도 있습니다.)
    - 하지만 모두 다 따르는 것을 REST API라고 부르기로 하겠다.