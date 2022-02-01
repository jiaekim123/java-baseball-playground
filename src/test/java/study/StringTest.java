package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    // 요구사항 1
    // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // 요구사항 2
    // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void split1() {
        String actual[] = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split2() {
        String actual[] = "1".split(",");
        assertThat(actual).contains("1");
    }

    // 요구사항 3
    // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    // //JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    @Test
    void substring() {
        String substring = "(1,2)".substring(1, 4);
        String actual[] = substring.split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    @DisplayName("charAt의 특정 문자의 인덱스와 원하는 문자가 같은지 확인한다")
    void charAt() {
        char actual = "abc".charAt(0);
        assertThat(actual).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt으로 index out bound exception이 발생하는지 확인한다.")
    void charAtException() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

    @Test
    @DisplayName("chatAt으로 index out bound exception이 발생하는지 확인한다.")
    void charAtException2() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> "abc".charAt(3))
                .withMessageMatching("String index out of range: 3");
    }
}
