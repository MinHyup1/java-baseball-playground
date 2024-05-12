package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        String[] splitTest = "1,2".split(",");
        assertThat(splitTest).contains("1", "2");

        // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        String[] splitTest2 = "1".split(",");
        assertThat(splitTest2).containsExactly("1");



    }

    @Test
    void subString() {
        /* 요구사항 2 */
        //"(1,2)" 값이 주어졌을 때 String substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        String value = "(1,2)";
        String substringTest = value.substring(1, value.length() - 1);
        assertThat(substringTest).isEqualTo("1,2");
    }

    @Test
    void throwBy() {
        /* 요구사항 3 */
        //"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        //JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

        String given = "abc";
        assertThatThrownBy(() -> {
            given.charAt(5);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
