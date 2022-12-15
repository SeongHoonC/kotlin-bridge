package bridge.domain

import bridge.controller.GameController
import bridge.view.OutputView

class OneRound(
        private val bridgeGame:BridgeGame,
        private val bridge:Bridge,
){
    private val outputView = OutputView()
    private val validator = Validator()

    fun play(): Boolean {
        val isAlive = playerMoving(bridge, bridgeGame)
        if (!isAlive) {
            val command = validator.validatedCommand()
            if (command == GameController.RETRY) bridgeGame.retry()
            if (command == GameController.QUIT) return false
        }
        return true
    }

    private fun playerMoving(bridge: Bridge, bridgeGame: BridgeGame): Boolean {
        val moving = validator.validatedMoving()
        bridgeGame.move(moving)
        val isSame = bridgeGame.compare(bridge)
        outputView.printMap(bridgeGame.result)
        return isSame
    }

}