package bridge

import bridge.data.ErrorMessage
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputViewTest :NsTest(){

    @ValueSource(strings = [" ","a1","%","UU","10.5"])
    @ParameterizedTest
    fun `문자 예외 테스트`(input:String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(input)
            assertThat(output()).contains(ErrorMessage.NOT_INT)
        }
    }

    @ValueSource(strings = ["2","-1","100"])
    @ParameterizedTest
    fun `숫자 범위 예외 테스트`(input:String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException(input)
            assertThat(output()).contains(ErrorMessage.SIZE_IN_RANGE)
        }
    }

    @ValueSource(strings = [" ","A","UU"])
    @ParameterizedTest
    fun `플레이어 이동 예외 테스트`(input:String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            runException("3",input)
            assertThat(output()).contains(ErrorMessage.UP_OR_DOWN)
        }
    }

    @ValueSource(strings = [" ", "U", "RR", "Q1", "-1"])
    @ParameterizedTest
    fun `R이나 Q가 아닌 입력 예외 테스트`(input: String) {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest({
            runException("3", "U", "D", "D", input)
            assertThat(output()).contains(ErrorMessage.RETRY_OR_QUIT)
            val upSideIndex = output().indexOf("[ O |   |   ]")
            val downSideIndex = output().indexOf("[   | O | X ]")
            assertThat(upSideIndex).isLessThan(downSideIndex)
        }, 1, 0, 1)
    }

    override fun runMain() {
        main()
    }
}