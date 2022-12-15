package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.data.GameMessage.CHOOSE_MOVING
import bridge.data.GameMessage.INPUT_COMMAND
import bridge.domain.Bridge
import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

class GameController {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val bridgeGame = BridgeGame()
    fun run() {
        outputView.printGameStart()
        val size = inputView.readBridgeSize()
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
            outputView.printMessage(INPUT_COMMAND)
            val command = inputView.readGameCommand()
            if (command == RETRY) bridgeGame.retry()
            if (command == QUIT) return false
        }
        return true
    }

    private fun playerMoving(bridge: Bridge, bridgeGame: BridgeGame): Boolean {
        outputView.printMessage(CHOOSE_MOVING)
        bridgeGame.move(inputView.readMoving())
        val isSame = bridgeGame.compare(bridge)
        outputView.printMap(bridgeGame.result)
        return isSame
    }

    companion object {
        const val RETRY = "R"
        const val QUIT = "Q"
    }
}