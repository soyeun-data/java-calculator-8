package calculator.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {
    Expression expression = new Expression();

    @Test
    void 빈문자열_입력() {
        assertEquals(0, expression.evaluate(""));
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2', 3",
            "'1,2,3', 6",
            "'1,2:3', 6"
    })
    void 기본_구분자_입력(String input, int expected) {
        assertEquals(expected, expression.evaluate(input));
    }

    @Test
    void 커스텀_구분자_입력() {
        assertEquals(6, expression.evaluate("//;\\n1;2;3"));
    }

    @Test
    void 커스텀_구분자가_한자리_이상일경우_예외처리() {
        assertThatThrownBy(() -> expression.evaluate("//ab\\n1ab2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 한 자 이상입니다.");
    }

    @Test
    void 커스텀_구분자가_숫자일경우_예외처리() {
        assertThatThrownBy(() -> expression.evaluate("//8\\n182"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 숫자입니다.");
    }

    @Test
    void 커스텀_구분자가_공백일경우_예외처리() {
        assertThatThrownBy(() -> expression.evaluate("//\\n182"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자가 존재하지 않습니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "'//;1;2', '커스텀 구분자가 잘못되었습니다.'",
            "1//;\\n1;2','커스텀 구분자가 처음부터 시작하지 않습니다.'"
    })
    void 커스텀_구분자를_잘못_선언했을_경우_예외처리(String input, String expectedMessage) {
        assertThatThrownBy(() -> expression.evaluate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

}