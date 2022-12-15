# 기능목록
다리 길이 만큼 랜덤 다리 생성 - BridgeMaker
플레이어의 기록을 표현하는 다리 - Model 
플레이어 입력 값과 비교해서 저장 - PlayerBridge
게임의 성공 유무를 확인 - PlayerBridge
플레이어의 행동 - BridgeGame

# MVC 적용하기
### Model
- Bridge
  - isAlive()
- BridgeGame
  - move()
  - retry()
### Controller
- GameController
  - runGame()
### View
- InputView
  - readBridgeSize()
  - readMoving()
  - readGameCommand()
- OutputView
    - printMap()
    - printResult()


# 출력예시
다리 건너기 게임을 시작합니다. - OutputView

다리의 길이를 입력해주세요. - OutputView
3 - InputView

이동할 칸을 선택해주세요. (위: U, 아래: D) - OutputView
U - InputView
[ O ] - OutputView, Model 에서 값 비교 후 저장
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D) - OutputView
U
[ O | X ] - OutputView, Model 에서 값 비교 후 저장
[   |   ]

게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q) - OutputView
R
이동할 칸을 선택해주세요. (위: U, 아래: D) - OutputView
U
[ O ]
[   ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   ]
[   | O ]

이동할 칸을 선택해주세요. (위: U, 아래: D)
D
[ O |   |   ]
[   | O | O ]

최종 게임 결과 - OutputView
[ O |   |   ]
[   | O | O ]

게임 성공 여부: 성공 - model
총 시도한 횟수: 2 - model

