# 기능목록

다리 길이 만큼 랜덤 다리 생성 - BridgeMaker
플레이어의 기록을 표현하는 다리 - Model
플레이어 입력 값과 비교해서 저장 - PlayerBridge
게임의 성공 유무를 확인 - PlayerBridge
플레이어의 행동 - BridgeGame

# MVC 적용하기

### Model

- Bridge
    - isBroken()
- BridgeGame
    - move()
    - retry()
    - compare()

### Controller

- GameController
    - run()
    - startGame()
    - oneGameLife()
    - playerMoving()
    - validateSize()
    - validateMoving()
    - validateCommand()

### View

- InputView
    - readBridgeSize()
    - readMoving()
    - readGameCommand()
- OutputView
    - printMap()
    - printResult()

