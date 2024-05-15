package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = {"1+1=2","2*3=6","5+10*2=30","5/5=1","5*5/5=5","1+2+3+4+5+6=21","1*2*3*4*5*6=720"}, delimiter = '=')
    void stringNumberCalculate(String input, int expected) throws Exception {
        int result = stringCalculator.stringNumberCalculate(input);
        assertThat(result).isEqualTo(expected);
    }
}