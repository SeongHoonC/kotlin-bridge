package bridge.data

object ErrorMessage {
    private const val ERROR_MESSAGE = "[ERROR] "
    const val NOT_INT = ERROR_MESSAGE.plus("숫자가 아닙니다.")
    const val SIZE_IN_RANGE = ERROR_MESSAGE.plus("3 이상 20 이하의 숫자를 입력해야 합니다.")
    const val UP_OR_DOWN = ERROR_MESSAGE.plus("U 이나 D를 입력해야 합니다.")
    const val RETRY_OR_QUIT = ERROR_MESSAGE.plus("R 이나 Q를 입력해야 합니다.")
}