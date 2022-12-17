package bridge.view

import bridge.domain.Validator
import bridge.values.GameMessage
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView(private val outputView : OutputView) {
    private val validator = Validator()
    fun readBridgeSize(): Int {
        outputView.printMessage(GameMessage.INPUT_BRIDGE_LENGTH)
        val input = Console.readLine()
        validator.validateSizeType(input)
        validator.validateSizeRange(input)
        return input.toInt()
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        outputView.printMessage(GameMessage.INPUT_MOVING_BLOCK)
        val input = Console.readLine()
        validator.checkMoving(input)
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        outputView.printMessage(GameMessage.INPUT_RETRY_OR_QUIT)
        val input = Console.readLine()
        validator.checkRetry(input)
        return input
    }
}
