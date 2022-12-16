package bridge.domain

import bridge.values.ErrorMessage
import bridge.values.GameMessage

class Validator {

    fun validateSizeRange(size:String){
        require(size.toInt() in MIN_RANGE_BRIDGE..MAX_RANGE_BRIDGE) {ErrorMessage.BRIDGE_RANGE_ERROR}
    }

    fun validateSizeType(input: String): Int {
        kotlin.runCatching {
            input.toInt()
        }
                .onSuccess { return input.toInt() }
                .onFailure { throw IllegalArgumentException(ErrorMessage.INPUT_TYPE_ERROR) }
        return 0
    }

    fun checkMoving(input: String) {
        require(input == UP || input == DOWN) { ErrorMessage.UP_OR_DOWN }
    }

    fun checkRetry(input: String) {
        require(input == RETRY || input == QUIT) { ErrorMessage.RETRY_OR_QUIT }
    }


    companion object {
        const val MIN_RANGE_BRIDGE = 3
        const val MAX_RANGE_BRIDGE = 20
        const val UP = "U"
        const val DOWN = "D"
        const val RETRY = "R"
        const val QUIT = "Q"
    }
}