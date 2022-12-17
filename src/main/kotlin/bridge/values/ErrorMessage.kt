package bridge.values

object ErrorMessage {
    private const val ERROR = "[ERROR] "

    const val INPUT_TYPE_ERROR = ERROR.plus("숫자를 입력해야 합니다.")
    const val BRIDGE_RANGE_ERROR = ERROR.plus("3 ~ 20")
    const val UP_OR_DOWN = ERROR.plus("U 나 D 입력")
    const val RETRY_OR_QUIT = ERROR.plus("R 나 Q 입력")
}