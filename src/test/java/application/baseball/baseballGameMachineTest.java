package application.baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;


class baseballGameMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"234:true","111:false","011:false","aswddasd:false","091:true"}, delimiter = ':')
    void 세개의_0_9까지의_숫자로_이루어진_문자열_유효성_테스트(String input, boolean expected) {
        // 정규 표현식: 0-9의 숫자가 3번 나오고, 각각이 유일해야 한다.
        Pattern pattern = Pattern.compile("^(?!.*(.).*\\1)\\d{3}$");
        boolean isMatches = pattern.matcher(input).matches();
        assertThat(isMatches).isEqualTo(expected);
    }

    @Test
    void 세개의_0_9까지의_숫자로_이루어진_문자열_생성_테스트 () {
        List<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(digits);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            result.append(digits.get(i));
        }
        System.out.println("result.toString() = " + result.toString());

        // 정규 표현식: 0-9의 숫자가 3번 나오고, 각각이 유일해야 한다.
        Pattern pattern = Pattern.compile("^(?!.*(.).*\\1)\\d{3}$");
        boolean isMatches = pattern.matcher(result.toString()).matches();
        assertThat(isMatches).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "123,123,true,0,3",
            "123,132,false,2,1",
            "123,124,false,0,2",
            "123,456,false,0,0",
            "123,789,false,0,0",
            "456,456,true,0,3",
            "156,165,false,2,1",
    })
    void 숫자야구게임_테스트(String computerDigits, String playerDigits, boolean expectedWin, int expectedBalls, int expectedStrikes) throws Exception {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine();
        // 리플렉션을 사용하여 private 필드에 접근하고 설정
        Field computerDigitStringField = BaseballGameMachine.class.getDeclaredField("computerDigitString");
        computerDigitStringField.setAccessible(true);
        computerDigitStringField.set(baseballGameMachine, computerDigits);
        PitchResultVo result = baseballGameMachine.pitched(playerDigits);
        PitchResultVo expected = new PitchResultVo(expectedWin, expectedBalls, expectedStrikes);

        System.out.println(result.getResultString());
        assertThat(result).isEqualTo(expected);
    }
}