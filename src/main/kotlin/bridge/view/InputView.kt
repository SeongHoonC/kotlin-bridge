package bridge.view

import bridge.util.bridgeSizeException
import bridge.util.inputTypeException
import bridge.util.retryOrQuitException
import bridge.util.upOrDownException
import camp.nextstep.edu.missionutils.Console

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {

    fun readBridgeSize(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                input.inputTypeException()
                val size = input.toInt()
                size.bridgeSizeException()
                return size
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readMoving(): String {
        while(true) {
            try {
                val input = Console.readLine()
                input.upOrDownException()
                return input
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readGameCommand(): String {
        while(true) {
            try {
                val input = Console.readLine()
                input.retryOrQuitException()
                return input
            }catch(e:IllegalArgumentException){
                println(e.message)
            }
        }
    }
}
