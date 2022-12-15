package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.Bridge
import bridge.domain.BridgeGame
import bridge.domain.OneRound
import bridge.domain.Validator
import bridge.view.InputView
import bridge.view.OutputView

class GameController {
    private val outputView = OutputView()
    private val bridgeGame = BridgeGame()
    private val validator = Validator()
    fun run() {
        val size = validator.validatedSize()
        val bridge = Bridge(BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size))
        startGame(bridge, size)
    }

    private fun startGame(bridge: Bridge, size: Int) {
        var isSuccess = true
        while (bridgeGame.successCount < size) {
            val oneRound = OneRound(bridgeGame, bridge)
            val repetition = oneRound.play()
            if (!repetition) {
                isSuccess = false
                break
            }
        }
        outputView.printResult(bridgeGame.result, bridgeGame.round, isSuccess)
    }

    companion object {
        const val RETRY = "R"
        const val QUIT = "Q"
    }
}