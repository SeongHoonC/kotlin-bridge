package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.Bridge
import bridge.domain.BridgeGame
import bridge.util.*
import bridge.view.InputView
import bridge.view.OutputView

class GameController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    fun run() {
        val size = validatedSize()
        val bridge = Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size))
        startGame(bridge, size)
    }

    private fun startGame(bridge: Bridge, size: Int) {
        var isSuccess = true
        while (bridgeGame.successCount < size) {
            val repetition = oneGameLife(bridgeGame, bridge)
            if (!repetition) {
                isSuccess = false
                break
            }
        }
        outputView.printResult(bridgeGame.result, bridgeGame.round, isSuccess)
    }

    private fun oneGameLife(bridgeGame: BridgeGame, bridge: Bridge): Boolean {
        val isAlive = playerMoving(bridge, bridgeGame)
        if (!isAlive) {
            val command = validatedCommand()
            if (command == RETRY) bridgeGame.retry()
            if (command == QUIT) return false
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

    companion object {
        const val RETRY = "R"
        const val QUIT = "Q"
    }


    private fun validatedSize(): Int {
        while (true) {
            try {
                val size = inputView.readBridgeSize().inputTypeException()
                size.bridgeSizeException()
                return size
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
}