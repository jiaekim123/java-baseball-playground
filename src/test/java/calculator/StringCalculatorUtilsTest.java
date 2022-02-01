package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorUtilsTest {

    @Test
    @DisplayName("문자열 계산기 성공 케이스1")
    void calculateSuccessTestOneWords() {
        float actual = StringCalculatorUtils.calculate("2");
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열 계산기 성공 케이스2")
    void calculateSuccessTestTwoWords() {
        float actual = StringCalculatorUtils.calculate("2 / 4");
        assertThat(actual).isEqualTo(0.5f);
    }

    @Test
    @DisplayName("문자열 계산기 성공 케이스3")
    void calculateSuccessTestThreeWords() {
        float actual = StringCalculatorUtils.calculate("2 + 3 / 2");
        assertThat(actual).isEqualTo(2.5f);
    }

    @Test
    @DisplayName("문자열 계산기 성공 케이스4")
    void calculateSuccessTestFourWords() {
        float actual = StringCalculatorUtils.calculate("2 + 3 * 4 / 2");
        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("문자열 계산 부호가 아닌 다른 것을 사용하면 실패한다.")
    void calculateFailWrongSign() {
        assertThatThrownBy(() -> StringCalculatorUtils.calculate("2 ^ 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 부호 입니다.");
    }

    @Test
    @DisplayName("부등호로 끝나면 마지막 부등호를 무시한다.")
    void calculateFailWrongPattern() {
        float actual = StringCalculatorUtils.calculate("2 + 3 + 1 +");
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("부등호로 시작하면 실패한다..")
    void calculateFailWrongFirstPattern() {
        assertThatThrownBy(() -> StringCalculatorUtils.calculate("+ 2 + 3 + 1 +"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("변환할 수 없는 문자가 포함되어 있습니다");
    }


    @Test
    @DisplayName("연속되어 부등호가 나오면 실패한다.")
    void calculateFailWrongSignPattern() {
        assertThatThrownBy(() -> StringCalculatorUtils.calculate("2 + + 3 + 1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("변환할 수 없는 문자가 포함되어 있습니다");
    }


}
