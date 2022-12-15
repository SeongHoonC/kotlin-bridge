package bridge.view

import bridge.data.GameMessage

class OutputView {

    fun printGameStart() {
        println(GameMessage.GAME_START)
        println(GameMessage.INPUT_BRIDGE_SIZE)
    }

    fun printMessage(message: String) {
        println(message)
    }

    fun printMap(result: List<Pair<String, String>>) {
        val size = result.size
        print("[")
        repeat(size) { column ->
            print(result[column].first)
            if (column < size - 1) print("|")
        }
        print("]\n[")
        repeat(size) { column ->
            print(result[column].second)
            if (column < size - 1) print("|")
        }
        println("]")
    }

    fun printResult(result: List<Pair<String, String>>, round: Int, isSuccess: Boolean) {
        println(GameMessage.GAME_END)
        printMap(result)

        print(GameMessage.GAME_SUCCESS_OR_NOT)
        if (isSuccess) println(GameMessage.SUCCESS)
        else println(GameMessage.FAIL)

        print(GameMessage.ROUND_COUNT)
        println(round)
    }
}
