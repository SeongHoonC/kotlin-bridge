package bridge.domain

class Bridge(private val blocks: List<String>) {

    fun isBroken(moving: String, index: Int): Boolean {
        if (blocks[index] == moving) {
            return true
        }
        return false
    }
}