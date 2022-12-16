package bridge

import bridge.domain.Validator
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class ValidatorTest {

    private val validator = Validator()
    @ValueSource(strings = ["U", "2a", "1000a", " "])
    @ParameterizedTest
    fun `다리 문자입력 예외 처리`(input:String) {
        assertThrows<IllegalArgumentException>{
            validator.validateSizeType(input)
        }
    }

    @ValueSource(strings = ["-1", "2", "100"])
    @ParameterizedTest
    fun `다리 범위 예외 처리`(input:String) {
        assertThrows<IllegalArgumentException>{
            validator.validateSizeRange(input)
        }
    }


    @ValueSource(strings = ["UU", "A", "R"," "])
    @ParameterizedTest
    fun `Move 예외 처리`(input:String) {
        assertThrows<IllegalArgumentException>{
            validator.checkMoving(input)
        }
    }

    @ValueSource(strings = ["RR", "D", "P"," "])
    @ParameterizedTest
    fun `Retry 예외 처리`(input:String) {
        assertThrows<IllegalArgumentException>{
            validator.checkRetry(input)
        }
    }
}