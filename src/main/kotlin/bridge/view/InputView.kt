package bridge.view
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        val input = Console.readLine()
        val size = input.toInt()
        return size
    }

    fun readMoving(): String {
        val input = Console.readLine()
        return input
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        val input = Console.readLine()
        return input
    }
}
