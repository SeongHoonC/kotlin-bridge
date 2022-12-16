package bridge.view

import bridge.data.GameMessage
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val outputView = OutputView()
    fun readBridgeSize(): String {
        outputView.printGameStart()
        return Console.readLine()
    }

    fun readMoving(): String {
        outputView.printMessage(GameMessage.CHOOSE_MOVING)
        return Console.readLine()
    }

    fun readGameCommand(): String {
        outputView.printMessage(GameMessage.INPUT_COMMAND)
        return Console.readLine()
    }
}
