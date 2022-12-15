package bridge.data

enum class Block(
        val number: Int,
        val initial: String
) {
    UP(1,"U"),
    DOWN(0, "D")
}