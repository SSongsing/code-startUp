## code-startUp 1주 

### 고민한 지점 
1. 할인을 어떻게 구현할 것인가?
   - 놀랍게도 고민을 꽤나 깊게 한 지점이었다. 그치만 해답을 찾지 못하고 시간에 쫓겨 개발을 하여 돌아가기만 하는 코드를 만들고 말았다. 더 공부해서 무조건 리팩토링하고 싶은 지점이다.
   - 제대로 된 이해가 없이 회사에서 익숙한 대로 개발하려고 하다보니, db에 할인 정책을 저장해두고 꺼내두는 방식을 처음 구상했으나, 테이블 설계에 막히고 매 주문 db를 찌르면 비효율적이라는 점을 깨달아 코드에 할인율을 지정해두는 방식으로 틀게 되었다.
2. 테스트 코드는 어렵다.
    - 모든 코드를 구현한 후에 보여주기 식으로 작성한 코드를 테스트 코드라 부를 수 있을까
    - api 개발은 맨날하고 있으니 평소에 하지 못한 부분에 집중했어야 했는데 테스트 코드를 또 뒷전으로 둔 점이 가장 아쉽다.
    - 2주차 과제는 단위 테스트에 대한 학습 이후에 시작해야겠다.
3. 설계를 하려면 공부해야한다.
   - 야심차게 좋은 구조를 고민하여 프로젝트를 만들고 싶었으나 아는 게 없으니 결국 이해 없이 익숙한 코드를 베껴서 모든 구조를 만들게 되었다.
   
### 후기
- 문제 해결 전략, 분석한 내용, 실행한 방법을 적어달라고 하셨으나 구현에 급급한 코드 작성으로 그 무엇도 하지 못했다. 2주차는 좀 더 시간의 여유를 두고 해야겠다.
- 업무에 사용하는 언어와 프레임워크에 이해가 부족한 것을 느끼고 남에게 보여주기 부끄럽다는 생각을 했다. 부끄럽지 않기 위해서는 공부해야한다.. 

## 2주차
### 공부
- Stream
  - 쓴 이유: 변수명 헷갈릴 것 같아서 변수 선언 없이 가려고 했다.
  - 알고 있던 것: 함수형 프로그래밍. 
  - 장점: 
- 왜 서비스에서 DTO를 바로 반환하지 않고 view를 쓰는가
  - 다른 팀원에게 물어보니 컨트롤러 - 서비스를 분리하기 위해서라는 답을 얻었다

### 고민한 지점
1. 할인 정책
   - 모르겠쑤!

### 후기