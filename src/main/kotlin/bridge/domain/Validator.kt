package bridge.domain

import bridge.util.bridgeSizeException
import bridge.util.inputTypeException
import bridge.util.retryOrQuitException
import bridge.util.upOrDownException
import bridge.view.InputView

class Validator {
    private val inputView = InputView()

    fun validatedSize(): Int {
        while (true) {
            try {
                val size = inputView.readBridgeSize()
                size.inputTypeException()
                size.bridgeSizeException()
                return size.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validatedCommand(): String {
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

    fun validatedMoving(): String {
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