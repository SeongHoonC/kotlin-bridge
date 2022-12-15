package bridge.util

import bridge.data.ErrorMessage.NOT_INT
import bridge.data.ErrorMessage.SIZE_IN_RANGE
import bridge.data.ErrorMessage.UP_OR_DOWN

fun String.inputTypeException() {
    try {
        this.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(NOT_INT)
    }
}

fun Int.bridgeSizeException(){
    require(this in 3..20){ SIZE_IN_RANGE}
}
fun String.upOrDownException() {
    require(this == "U" || this == "D") { UP_OR_DOWN}
}

fun String.retryOrQuitException(){
    require(this == "R" || this == "Q") { UP_OR_DOWN}
}