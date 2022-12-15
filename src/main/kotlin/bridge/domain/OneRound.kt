package bridge.domain

import bridge.controller.GameController
import bridge.util.retryOrQuitException
import bridge.util.upOrDownException
import bridge.view.InputView
import bridge.view.OutputView

class OneRound(
        private val bridgeGame:BridgeGame,
        private val bridge:Bridge,
){
    private val inputView = InputView()
    private val outputView = OutputView()

    fun play(): Boolean {
        val isAlive = playerMoving(bridge, bridgeGame)
        if (!isAlive) {
            val command = validatedCommand()
            if (command == GameController.RETRY) bridgeGame.retry()
            if (command == GameController.QUIT) return false
        }
        return true
    }

    private fun playerMoving(bridge: Bridge, bridgeGame: BridgeGame): Boolean {
        val moving = validatedMoving()
        bridgeGame.move(moving)
        val isSame = bridgeGame.compare(bridge)
        outputView.printMap(bridgeGame.result)
        return isSame
    }

    private fun validatedCommand(): String {
        while (true) {
            try {
                val moving = inputView.readGameCommand()
                moving.retryOrQuitException()
                return moving
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validatedMoving(): String {
        while (true) {
            try {
                val moving = inputView.readMoving()
                moving.upOrDownException()
                return moving
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}