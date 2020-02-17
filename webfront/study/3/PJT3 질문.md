## 해결해야 할 사항들

패키지 구조
    - jsp를 리턴하는 controller가 들어갈 패키지 네임은 ...?

1. controller의 역할, service의 역할... 
    - view에 렌더링 할 모델을 service에서 만들어서 return 하는 것이 맞지 않나...?

    일반적으로 layered architecture에서 컨트롤레이어의 역할은 구성 요소간의 처리 흐름을 제어, 데이터 조작 의뢰, 데이터 변환 및 연산 비지니스 레이어에서는 Control layer와 Persistence layer를 연결하는 역할

2. DB 값을 그대로 맵핑할 클래스와 이를 가공하여 응답할때 넘겨 줄 클래스의 네이밍을 일반적으로 어떻게 처리하나 ...?