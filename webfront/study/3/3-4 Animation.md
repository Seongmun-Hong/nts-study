## requestAnimationFrame

setTimeout은 animation을 위한 최적화된 기능이라 보기는 어렵습니다.

animation주기를 16.6 미만으로 하는 경우 불필요한 frame 생성이 되는 등의 문제가 생깁니다.

그 대안으로 생긴 것이 바로 requestAnimationFrame입니다.

아래 예제를 살펴보시죠.

먼저 아래처럼 requestAnimationFrame을 한번 실행시켜줘야 합니다.

그 이후에 특정 조건이 될 때까지(함수의 탈출 조건) 계속 함수를 연속적으로 호출하는 것이죠.

이렇게 requestAnimationFrame함수를 통해서 원하는 함수를 인자로 넣어주면, 브라우저는 인자로 받은 그 비동기 함수가 실행될 가장 적절한 타이밍에 실행시켜줍니다.

우리는 어느 정도 브라우저를 믿고 이 함수를 전달해주는 것입니다. 


## transition

https://thoughtbot.com/blog/transitions-and-transforms