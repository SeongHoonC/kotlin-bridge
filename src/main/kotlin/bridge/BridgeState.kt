package bridge

import bridge.ui.InputView
import bridge.ui.OutputView

class BridgeState {
    private val bridgeGame = BridgeGame()
    private val inputView = InputView()
    private val outputView = OutputView()
    private val playerLife = PlayerLife()

    fun compare(bridge:List<String>):Boolean{
        var playerMoves = mutableListOf<List<String>>()
        for(index in bridge.indices){
            val upOrDown = inputView.readMoving()
            val alive = playerLife.isAlive(bridge[index],upOrDown)
            insertMove(playerMoves,upOrDown,alive)
            if(!alive) return false
        }
        outputView.printResult(playerMoves)
        return true
    }

    private fun insertMove(playerMoves:MutableList<List<String>>,upOrDown:String,alive:Boolean){
        var playerMoves = playerMoves
        playerMoves = bridgeGame.move(playerMoves,upOrDown,alive)
        outputView.printMap(playerMoves)
    }
}