package bridge.domain

import bridge.data.Block.UP
import bridge.data.Block.DOWN

class BridgeGame {
    private var playerMoving = PlayerMoving()
    var result = mutableListOf<Pair<String, String>>()
    var round = 1
    var successCount = 0
    fun move(moving: String) {
        when (moving) {
            UP.initial -> playerMoving.insertMoving(UP.initial)
            DOWN.initial -> playerMoving.insertMoving(DOWN.initial)
        }
    }

    fun retry() {
        round++
        successCount = 0
        playerMoving = PlayerMoving()
        result = mutableListOf()
    }

    fun compare(bridge: Bridge): Boolean {
        val moving = playerMoving.movingRecord
        val isAlive = bridge.isBroken(moving.last(), moving.lastIndex)
        if (isAlive) successCount++
        addResult(moving.last(), isAlive)
        return isAlive
    }

    private fun addResult(upDown: String, isAlive: Boolean) {
        when {
            upDown == UP.initial && isAlive -> result.add(Pair(CORRECT, GAP))
            upDown == UP.initial && !isAlive -> result.add(Pair(WRONG, GAP))
            upDown == DOWN.initial && isAlive -> result.add(Pair(GAP, CORRECT))
            upDown == DOWN.initial && !isAlive -> result.add(Pair(GAP, WRONG))
        }
    }

    companion object {
        const val CORRECT = " O "
        const val WRONG = " X "
        const val GAP = "   "
    }
}
