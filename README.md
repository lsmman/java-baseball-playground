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
