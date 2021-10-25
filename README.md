# TDD를 위한 숫자 야구 게임 예제

## CONTENTS

- [Package game: 게임 수행을 위한 클래스들](#Package-game)
    - [Game](#Game)
    - [Ball & Balls](#Ball-&-Balls)
    - [BallNumber](#BallNumber)
    - [GameStatus : Enum class](#GameStatus)
    - [GameResult](#GameResult)
- [Service: 게임 수행을 매개하는 서비스 객체](#Service)
    - [GameResponseDTO](#GameResponseDTO)
- [UI](#UI)
- [Controller](#Controller)
- [BaseBallGame](#BaseBallGame)
- [**경험해야할 학습 목표**](#Goals)

<br/>
<br/>

## Package game

- 게임을 실질적으로 수행하는 클래스

### Game

[Link :link:](/src/main/java/baseBall/game/Game.java) / [Test :heavy_check_mark:](/src/test/java/baseBall/game/GameTest.java)
- 베이스볼 게임 클래스입니다.

```
public method: createAnswer
    3자리 수 숫자 야구게임 정답을 만들어 냅니다.

public method: play
    숫자 야구 게임에서 몇 개 맞추었는 지 도출해줍니다.
       ex) com / user
       123 / 123 -> 3 strike
       123 / 456 -> Nothing
       123 / 253 -> 1 ball 1 strike
```

### Ball & Balls

[Link :link:](/src/main/java/baseBall/game/Ball.java) / [Test :heavy_check_mark:](/src/test/java/baseBall/game/BallTest.java)
- Game의 핵심 로직을 더 세밀하게 쪼개보자

```
public method : play
볼 하나씩 비교하여 Strike, Ball, Nothing을 도출합니다.
     com    /   user
    pos num /  pos num
    0    1  /   0   1   -> Strike
    0    1  /   1   1   -> Ball
    0    1  /   2   4   -> Nothing 
```

### BallNumber

[Link :link:](/src/main/java/baseBall/game/BallNumber.java) / [Test :heavy_check_mark:](/src/test/java/baseBall/game/BallNumberTest.java)
- ball의 형태를 안정적으로 사용가능하도록 Integer 보다는 **일급컬렉션**을 사용.

```
public method : isValid
    볼이 0부터 9사이의 수를 가지도록 강제합니다.
    조건을 만족하지 않으면 IllegalArgumentException를 raise합니다.
```

### GameStatus 

[Link :link:](/src/main/java/baseBall/game/GameStatus.java)
- Ball 하나씩의 play 결과를 저장합니다.
- **Enum class**로 Strike, ball, Nothing을 가집니다.

### GameResult

[Link :link:](/src/main/java/baseBall/game/GameResult.java)
- 도메인 내에서 결과를 주고 받기 위한 객체입니다.
- ball, strike의 count 정보와 게임이 성공하였는지 여부를 저장합니다.

<br/>

## Service

[Link :link:](/src/main/java/baseBall/Service.java) / [Test :heavy_check_mark:](/src/test/java/baseBall/ServiceTest.java)
- 게임 수행을 매개하는 서비스 클래스입니다.
- initGame(): Game을 위한 환경을 셋팅합니다.
- playGame(): input을 받아 숫자 야구 게임 결과를 리턴합니다.

### GameResponseDTO

[Link :link:](/src/main/java/baseBall/Dto/GameResponseDto.java)
- Service 객체에서 Controller 객체로 게임 결과를 보낼 때 사용하는 DTO입니다.
- ResponseCode와 Ball, Strike의 수와 게임 성공 여부를 가집니다.

<br/>

## UI

[Link :link:](/src/main/java/baseBall/UI.java)
- 게임의 I/O를 담당합니다.

<br/>

## Controller

[Link :link:](/src/main/java/baseBall/Controller.java)
- UI 객체와 Service 객체를 유일하게 가지는 클래스입니다. (**Singleton pattern**)
- UI의 요청과 응답을 Service에 전달하여 게임이 순서에 맞게 진행되도록 합니다.

<br/>

## BaseBallGame

[Link :link:](/src/main/java/BaseBallGame.java)
- BaseBallGame을 실행하는 메인을 가진 클래스입니다.
- startGame이 실행될 때 Controller 객체를 인스턴스화합니다. (**lazy initialization**)

----

## Goals
- 경험해야할 학습 목표

### 주요 목표
- 자바 **code convention**을 지키면서 프로그래밍하는 경험
- JUnit 사용법을 익혀 **단위 테스트**하는 경험
- 학습테스트를 하면서 JUnit 사용법을 익히는 경험
- **메소드를 분리하는 리팩터링** 경험
- 이번에 지킬 **객체지향 생활 체조 원칙** 연습
    - 규칙 1: 한 메서드에 오직 한 단계의 들여쓰기만 한다.
    - 규칙 2: else 예약어를 쓰지 않는다.
    - 이 두가지 원칙을 통해 메소드를 분리해 메소드가 한 가지 작업만 담당하도록 구현하는 연습을 목표로 한다.


### Clean Code 가이드
#### 함수(메소드)
- 작게 만들어라.
    - 함수를 만드는 첫 번재 규칙은 '작게'다. 함수를 만드는 두 번째 규칙은 '더 작게'다.
- 한 가지만 해라. 
    - 함수는 한 가지를 해야 한다. 그 한 가지를 잘 해야 한다. 그 한 가지만 해야 한다.
- 함수 당 추상화 수준은 하나로
    - 함수가 확실히 '한 가지' 작업만 하려면 함수 내 모든 문장이 동일한 추상화 수준에 있어야 한다.
- 코드는 위에서 아래로 이야기처럼 일해야 좋다.
- 일관성을 가진 서술적인 이름을 사용하라
- 함수 인수
    - 함수에서 이상적인 인수 개수는 0개(무항)이다. 다음은 1개이고, 다음은 2개이다.
    - 4개 이상은 특별한 이유가 있어도 사용하면 안된다
    - 인수가 2 ~ 3개 필요한 경우가 생긴다면 인수를 독자적인 클래스를 생성할 수 있는지 검토해 본다.
- side effect를 만들지 마라.
- 명령과 조회를 분리하라.
- 함수는 뭔가를 수행하거나 답하거나 둘 중 하나만 해야 한다. 둘 다 하면 안된다.
- 개체 상태를 변경하거나 아니면 개체 정보를 반환하거나 둘 중 하나다.
- 오류 코드보다 예외를 사용하라.
- 오류 처리도 한 가지 작업이다.
    - 함수는 '한 가지' 작업만 해야 한다. 오류 처리도 '한 가지' 작업에 속한다.
- 그러므로 오류를 처리하는 함수는 오류만 처리해야 마땅하다.
- try/catch 블록은 원래가 추하다. 코드 구조에 혼란을 일으키며, 정상적인 동작과 오류 처리 동작을 뒤섞는다. try/catch 블록을 별도 함수로 뽑아내는 편이 낫다.
- 반복하지 마라.

### 참고) 함수를 구현하는 방법은?

> 소프트웨어를 구현하는 행위는 여느 글짓기와 비슷하다. 논문이나 기사를 쓸 때는 먼저 생각을 기록한 후 읽기 좋게 다듬는다. 초안은 대개 서투르고 어수선하므로 원하는 대로 읽힐 때까지 말을 다듬고 문장을 고치고 문단을 정리한다.

> 필자는 함수를 구현할 때도 마찬가지다. 처음에는 길고 복잡하다. 들여쓰기 단계도 많고, 중복된 루프도 많다. 인수 목록도 아주 길다. 이름은 즉흥적이고 코드는 중복된다. 하지만 필자는 그 서투른 코드를 빠짐없이 테스트하는 단위 테스트 케이스도 만든다.

> 그런 다음 필자는 코드를 다듬고, 함수를 만들고, 이름을 바꾸고, 중복을 제거한다. 메소드를 줄이고, 순서를 바꾼다. 때로는 전체 클래스를 쪼개기도 한다. 이 와중에도 코드는 항상 단위 테스트를 통과한다.

