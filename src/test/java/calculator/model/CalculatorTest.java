package calculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Expression expression = new Expression();

    @Test
    void 커스텀_구분자로_지정한_구분자가_아닌경우_예외처리() {
        assertThatThrownBy(() -> expression.evaluate("//;\\n1.2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용되지 않은 구분자가 포함되어 있습니다.");
    }

    @Test
    void 기본_구분자와_특수_구분자가_아닌_구분자를_사용한경우_예외처리() {
        assertThatThrownBy(() -> expression.evaluate("1.2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용되지 않은 구분자가 포함되어 있습니다.");
    }

    @Test
    void 문자열에_음수값이_있을경우_예외처리() {
        assertThatThrownBy(() -> expression.evaluate("1,-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 허용되지 않습니다.");
    }
}